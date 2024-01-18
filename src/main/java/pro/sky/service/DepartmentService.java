package pro.sky.service;

import pro.sky.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Map<Integer, List<Employee>> getEmployees();
    List<Employee> getEmployeesByDepartment(int department);
    float summSalaryByDepartment(int department);
    float getMaxSalaryByDepartment(int department);
    float getMinSalaryByDepartment(int department);
}
