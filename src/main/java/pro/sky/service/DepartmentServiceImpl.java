package pro.sky.service;

import org.springframework.stereotype.Service;
import pro.sky.checkservice.CheckService;
import pro.sky.model.Employee;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final CheckService checkService;
    private final EmployeeService employeeService;
    public DepartmentServiceImpl(CheckService checkService,
                                 EmployeeService employeeService){
        this.checkService = checkService;
        this.employeeService = employeeService;
    }

    public Map<Integer, List<Employee>> getEmployees(){
        return employeeService.getEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public List<Employee> getEmployeesByDepartment(int department){
        checkService.checkNumberDepartment(department, employeeService);
        return employeeService.getEmployees().stream().filter((employee)->employee.getDepartment() == department).toList();
    }

    public float summSalaryByDepartment(int department){
        checkService.checkNumberDepartment(department, employeeService);
        double sumSalary = getEmployeesByDepartment(department)
                .stream()
                .mapToDouble(Employee::getSalary)
                .sum();
        return (float)sumSalary;
    }

    public float getMaxSalaryByDepartment(int department){
        checkService.checkNumberDepartment(department, employeeService);
        OptionalDouble maxSalary = getEmployeesByDepartment(department)
                .stream()
                .mapToDouble(Employee::getSalary)
                .max();
        return (float) maxSalary.getAsDouble();
    }

    public float getMinSalaryByDepartment(int department){
        checkService.checkNumberDepartment(department, employeeService);
        OptionalDouble minSalary = getEmployeesByDepartment(department)
                .stream()
                .mapToDouble(Employee::getSalary)
                .min();
        return (float) minSalary.getAsDouble();
    }

}
