package pro.sky.checkservice;

import org.springframework.stereotype.Service;
import pro.sky.exceptions.*;
import pro.sky.model.Employee;
import pro.sky.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckServiceImpl implements CheckService{
    public CheckServiceImpl(){}
    public void checkParameters(String name, String lastName, Float salary, Integer department){
        List<String> listOfParameters = new ArrayList<>();
        if(name == null){
            listOfParameters.add("firstName=имя");
        }
        if(lastName == null){
            listOfParameters.add("lastName=фамилию");
        }
        if(salary == null){
            listOfParameters.add("salary=зарплату");
        }
        if(department == null){
            listOfParameters.add("department=номер отдела");
        }
        if(!listOfParameters.isEmpty()){
            StringBuilder result = new StringBuilder("необходимо ввести: ");
            for (int i = 0; i < listOfParameters.size(); i++){
                if(i == 0){
                    result.append(listOfParameters.get(i));
                }else {
                    result.append("&");
                    result.append(listOfParameters.get(i));
                }
            }
            throw new NoAllParametersException(result.toString());
        }
    }


        public void checkNameAndLastName(String name, String lastName){
        if(name == null && lastName == null){
            throw new NoAllParametersException("необходимо ввести имя и фамилию.");
        }else if(name == null){
            throw new NoAllParametersException("необходимо ввести имя.");
        }else if(lastName == null){
            throw new NoAllParametersException("необходимо ввести фамилию.");
        }
    }

    public void checkVacancy(EmployeeService employeeService){
        if(employeeService.getEmployees().size() >= employeeService.getMaxNumberOfEmployees()){
            throw new EmployeeStorageIsFullException("Вакансий нет.");
        }
    }

    public void checkingAvailabilityOfEmployee(String name, String lastName, EmployeeService employeeService){
        for (Employee employee : employeeService.getEmployees()){
            if(employee.getFirstName().equals(name) && employee.getLastName().equals(lastName)){
                throw new EmployeeAlreadyAddedException("Работник уже есть в списке");
            }
        }
    }

    public void checkEmployeeInList(String name, String lastName, EmployeeService employeeService){
        for (Employee employee : employeeService.getEmployees()) {
            if (employee.getFirstName().equals(name) && employee.getLastName().equals(lastName)) {
                return;
            }
        }
        throw new EmployeeNotFoundException("Работника нет в списке.");
    }

    public void checkNumberDepartment(int department, EmployeeService employeeService){
        for (Employee e : employeeService.getEmployees()){
            if(e.getDepartment() == department){
                return;
            }
        }
        throw new NoSuchDepartmentException("Такого номера отдела нет.");
    }

}
