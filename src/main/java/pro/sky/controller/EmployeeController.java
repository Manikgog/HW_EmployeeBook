package pro.sky.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import pro.sky.model.Employee;
import pro.sky.service.EmployeeService;


import java.util.ArrayList;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam(value = "firstName", required = false) String name,
                              @RequestParam(value = "lastName", required = false) String lastName) {
        return employeeService.addEmployee(name, lastName);
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
    public ArrayList<Employee> showEmployees(){
        return employeeService.showEmployees();
    }


}
