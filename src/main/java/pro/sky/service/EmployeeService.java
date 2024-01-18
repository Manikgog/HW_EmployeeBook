package pro.sky.service;

import pro.sky.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, Float salary, Integer department);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    List<Employee> getEmployees();
    int getMaxNumberOfEmployees();
}
