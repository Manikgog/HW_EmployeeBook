package pro.sky.repo;

import pro.sky.EmployeeApplication;
import pro.sky.model.Employee;

import java.util.List;
import java.util.Set;

public interface ListOfEmployees {
    void add(Employee employee);

    void remove(Employee employee);

    List<Employee> getAll();

    int getMaxNumberOfEmployees();

    Employee get(Employee employee);
}
