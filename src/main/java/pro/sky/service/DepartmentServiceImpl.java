package pro.sky.service;

import org.springframework.stereotype.Service;
import pro.sky.checkservice.CheckServiceImpl;
import pro.sky.model.Employee;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    private final CheckServiceImpl checkService;
    private final EmployeeService employeeService;
    public DepartmentServiceImpl(CheckServiceImpl checkService,
                                 EmployeeService employeeService){
        this.checkService = checkService;
        this.employeeService = employeeService;
    }

    public Map<Integer, List<Employee>> showEmployees(){
        return employeeService.getEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public List<Employee> showEmployeesByDepartment(int department){
        checkService.checkNumberDepartment(department);
        return employeeService.getEmployees().stream().filter((employee)->employee.getDepartment() == department).toList();
    }

    public float summSalaryByDepartment(int department){
        checkService.checkNumberDepartment(department);
        List<Employee> list = getListByDepartment(department);
        float sum = 0;
        for(Employee e : list){
            sum += e.getSalary();
        }
        return sum;
    }

    public List<Employee> getListByDepartment(int department){
        checkService.checkNumberDepartment(department);
        return employeeService
                .getEmployees()
                .stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    public float getMaxSalaryByDepartment(int department){
        checkService.checkNumberDepartment(department);
        List<Employee> list = getListByDepartment(department);
        float maxSalary = list.get(0).getSalary();
        for(Employee e : list){
            if(maxSalary < e.getSalary()){
                maxSalary = e.getSalary();
            }
        }
        return maxSalary;
    }

    public float getMinSalaryByDepartment(int department){
        checkService.checkNumberDepartment(department);
        List<Employee> list = getListByDepartment(department);
        float minSalary = list.get(0).getSalary();
        for(Employee e : list){
            if(minSalary > e.getSalary()){
                minSalary = e.getSalary();
            }
        }
        return minSalary;
    }

}
