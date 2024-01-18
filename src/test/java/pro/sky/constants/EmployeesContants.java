package pro.sky.constants;

import pro.sky.model.Employee;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeesContants {
    public static final Employee EMPLOYEE_1 = new Employee("Chendler", "Bing", 10000f, 1);
    public static final Employee EMPLOYEE_2 = new Employee("Monica", "Bing", 12000f, 2);
    public static final Employee EMPLOYEE_3 = new Employee("Rachel", "Grin", 15000f, 2);
    public static final Employee EMPLOYEE_4 = new Employee("Fuiby", "Buffey", 14000f, 2);
    public static final Employee EMPLOYEE_5 = new Employee("Ross", "Geller", 16000f, 1);
    public static final Employee EMPLOYEE_6 = new Employee("Joe", "Tribiany", 9000f, 1);
    public static final List<Employee> EMPLOYEES_LIST = List.of(
            EMPLOYEE_1,
            EMPLOYEE_2,
            EMPLOYEE_3,
            EMPLOYEE_4,
            EMPLOYEE_5,
            EMPLOYEE_6
    );

    public static final List<Employee> EMPLOYEES_LIST_1 = List.of(
            EMPLOYEE_1,
            EMPLOYEE_5,
            EMPLOYEE_6
    );

    public static final List<Employee> EMPLOYEES_LIST_2 = List.of(
            EMPLOYEE_2,
            EMPLOYEE_3,
            EMPLOYEE_4
    );


    public static final Map<Integer, List<Employee>> EMPLOYEES_MAP = new HashMap<>()
            {{put(1, EMPLOYEES_LIST_1);
                put(2, EMPLOYEES_LIST_2);}};

    public static final float SALARY_SUMM_1 = 35000f;
    public static final float SALARY_SUMM_2 = 41000f;
    public static final float MAX_SALARY_1 = 16000f;
    public static final float MAX_SALARY_2 = 15000f;
    public static final float MIN_SALARY_1 = 9000f;
    public static final float MIN_SALARY_2 = 12000f;


}
