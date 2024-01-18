package pro.sky.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.model.Employee;
import pro.sky.service.EmployeeService;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam(value = "firstName", required = false) String name,
                              @RequestParam(value = "lastName", required = false) String lastName,
                                @RequestParam(value = "salary", required = false) Float salary,
                                @RequestParam(value = "department", required = false) Integer department) {
        return employeeService.addEmployee(name, lastName, salary, department);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam(value = "firstName", required = false) String name,
                                   @RequestParam(value = "lastName", required = false) String lastName) {
        return employeeService.removeEmployee(name, lastName);
    }

    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam(value = "firstName", required = false) String name,
                               @RequestParam(value = "lastName", required = false) String lastName) {
        return employeeService.findEmployee(name, lastName);
    }

    @GetMapping
    public List<Employee> showEmployees(){
        return employeeService.getEmployees();
    }


}
