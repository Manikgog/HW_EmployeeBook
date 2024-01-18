package pro.sky.checkservice;

import pro.sky.service.EmployeeService;

public interface CheckService {
    void checkParameters(String name, String lastName, Float salary, Integer department);
    void checkNameAndLastName(String name, String lastName);
    void checkVacancy(EmployeeService employeeService);
    void checkingAvailabilityOfEmployee(String name, String lastName, EmployeeService employeeService);
    void checkEmployeeInList(String name, String lastName, EmployeeService employeeService);
    void checkNumberDepartment(int department, EmployeeService employeeService);
}
