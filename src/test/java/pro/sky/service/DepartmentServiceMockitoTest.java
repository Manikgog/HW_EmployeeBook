package pro.sky.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.checkservice.CheckService;
import pro.sky.model.Employee;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;
import static pro.sky.constants.EmployeesContants.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceMockitoTest {
    @Mock
    private EmployeeService employeeService;

    @Mock
    private CheckService checkService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void getEmployeeByDepartmentTest(){
        when(employeeService.getEmployees()).thenReturn(EMPLOYEES_LIST);
        List<Employee> actualList = departmentService.getEmployeesByDepartment(1);
        Assertions.assertEquals(EMPLOYEES_LIST_1, actualList);
        actualList = departmentService.getEmployeesByDepartment(2);
        Assertions.assertEquals(EMPLOYEES_LIST_2, actualList);
        Map<Integer, List<Employee>> map = departmentService.getEmployees();
        Assertions.assertEquals(EMPLOYEES_MAP, map);
    }

    @Test
    public void getEmployeesTest(){
        when(employeeService.getEmployees()).thenReturn(EMPLOYEES_LIST);
        Map<Integer, List<Employee>> map = departmentService.getEmployees();
        Assertions.assertEquals(EMPLOYEES_MAP, map);
    }

    @Test
    public void summSalaryByDepartment(){
        when(employeeService.getEmployees()).thenReturn(EMPLOYEES_LIST);
        float actualSum = departmentService.summSalaryByDepartment(1);
        Assertions.assertEquals(SALARY_SUMM_1, actualSum);
        actualSum = departmentService.summSalaryByDepartment(2);
        Assertions.assertEquals(SALARY_SUMM_2, actualSum);
    }

    @Test
    public void getMaxSalaryByDepartment(){
        when(employeeService.getEmployees()).thenReturn(EMPLOYEES_LIST);
        float actualMaxSalary = departmentService.getMaxSalaryByDepartment(1);
        Assertions.assertEquals(MAX_SALARY_1, actualMaxSalary);
        actualMaxSalary = departmentService.getMaxSalaryByDepartment(2);
        Assertions.assertEquals(MAX_SALARY_2, actualMaxSalary);
    }

    @Test
    public void getMinSalaryByDepartment(){
        when(employeeService.getEmployees()).thenReturn(EMPLOYEES_LIST);
        float actualMinSalary = departmentService.getMinSalaryByDepartment(1);
        Assertions.assertEquals(MIN_SALARY_1, actualMinSalary);
        actualMinSalary = departmentService.getMinSalaryByDepartment(2);
        Assertions.assertEquals(MIN_SALARY_2, actualMinSalary);
    }

}
