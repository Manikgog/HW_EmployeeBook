package pro.sky.service;

import org.springframework.stereotype.Service;
import pro.sky.checkservice.CheckServiceImpl;
import pro.sky.model.Employee;
import pro.sky.exceptions.EmployeeAlreadyAddedException;
import pro.sky.exceptions.EmployeeNotFoundException;
import pro.sky.exceptions.EmployeeStorageIsFullException;
import pro.sky.repo.ListOfEmployees;

import java.util.ArrayList;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final CheckServiceImpl checkService;
    private final ListOfEmployees listOfEmployees;
    public EmployeeServiceImpl(CheckServiceImpl checkService,
                               ListOfEmployees listOfEmployees){
        this.checkService = checkService;
        this.listOfEmployees = listOfEmployees;
    }

    public Employee addEmployee(String firstName, String lastName){
        checkService.checkVacancy(firstName, lastName);
        checkService.checkingAvailabilityOfEmployee(firstName, lastName);
        Employee emp = new Employee(firstName, lastName);
        listOfEmployees.add(emp);
        return listOfEmployees.get(emp);
    }

    public Employee removeEmployee(String firstName, String lastName){
        Employee employee = findEmployee(firstName, lastName);
        listOfEmployees.remove(employee);
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName){
        Employee employee = new Employee(firstName, lastName);
        Employee employee1 = getEmployee(employee);
        if(employee1 != null){
            return employee1;
        }
        throw new EmployeeNotFoundException("EmployeeNotFound");
    }

    public ArrayList<Employee> showEmployees(){
        return new ArrayList<>(listOfEmployees);
    }


    private Employee getEmployee(Employee employee){
        for (Employee emp :
                listOfEmployees) {
            if(emp.equals(employee)){
                return emp;
            }
        }
        return null;
    }

}
