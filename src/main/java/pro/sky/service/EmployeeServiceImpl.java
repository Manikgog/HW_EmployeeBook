package pro.sky.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import pro.sky.checkservice.CheckService;
import pro.sky.model.Employee;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final CheckService checkService;
    private final List<Employee> listOfEmployees;
    @Getter
    private final int maxNumberOfEmployees = 10;
    public EmployeeServiceImpl(CheckService checkService){
        listOfEmployees = new ArrayList<>();
        this.checkService = checkService;
    }

    public Employee addEmployee(String firstName, String lastName, Float salary, Integer department){
        checkService.checkParameters(firstName, lastName, salary, department);
        checkService.checkVacancy(this);    // проверка наличия свободных вакансий
        checkService.checkingAvailabilityOfEmployee(firstName, lastName, this);   // проверка наличия работника с такими же именем и фамилией
        Employee emp = new Employee(firstName, lastName, salary, department);
        listOfEmployees.add(emp);
        return emp;
    }

    public Employee removeEmployee(String firstName, String lastName){
        checkService.checkNameAndLastName(firstName, lastName);
        Employee employee = findEmployee(firstName, lastName);
        listOfEmployees.remove(employee);
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName){
        checkService.checkNameAndLastName(firstName, lastName);
        checkService.checkEmployeeInList(firstName, lastName, this);
        Employee employee = null;
        for (Employee emp : listOfEmployees){
            if (emp.getFirstName().equals(firstName) && emp.getLastName().equals(lastName)){
                employee = emp;
                break;
            }
        }
        return employee;
    }

    public List<Employee> getEmployees(){
        return Collections.unmodifiableList(listOfEmployees);
    }

}
