package pro.sky.service;

import pro.sky.model.Employee;

import java.util.ArrayList;

public interface EmployeeService {
    ArrayList<Employee> listOfEmployees = new ArrayList<>();
    int maxNumberOfEmployees = 10;

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    ArrayList<Employee> showEmployees();
}
