package pro.sky.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.model.Employee;
import pro.sky.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> showEmployees(){
        return departmentService.getEmployees();
    }

    @GetMapping("/{id}/employees")
    public List<Employee> showEmployeesByDepartment(@PathVariable Integer id){
        return departmentService.getEmployeesByDepartment(id);
    }

    @GetMapping("/{id}/salary/sum")
    public float getSumSalaryByDepartment(@PathVariable Integer id) {
        return departmentService.summSalaryByDepartment(id);
    }

    @GetMapping("/{id}/salary/max")
    public float getMaxSalaryByDepartment(@PathVariable Integer id){
        return departmentService.getMaxSalaryByDepartment(id);
    }

    @GetMapping("/{id}/salary/min")
    public float getMinSalaryByDepartment(@PathVariable Integer id){
        return departmentService.getMinSalaryByDepartment(id);
    }
}
