package pro.sky.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.exceptions.EmployeeAlreadyAddedException;
import pro.sky.exceptions.EmployeeNotFoundException;
import pro.sky.exceptions.EmployeeStorageIsFullException;
import pro.sky.exceptions.NoAllParametersException;
import pro.sky.model.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EmployeeServiceImplTest {
    private final EmployeeServiceImpl employeeServiceImpl;

    public EmployeeServiceImplTest() {
        this.employeeServiceImpl = new EmployeeServiceImpl();

        employeeServiceImpl.addEmployee("Chendler", "Bing", 10000f, 1);
        employeeServiceImpl.addEmployee("Monica", "Bing", 12000f, 2);
        employeeServiceImpl.addEmployee("Rachel", "Grin", 15000f, 2);
        employeeServiceImpl.addEmployee("Fuiby", "Buffey", 14000f, 2);
        employeeServiceImpl.addEmployee("Ross", "Geller", 16000f, 1);
        employeeServiceImpl.addEmployee("Joe", "Tribiany", 9000f, 1);
    }


    public static Stream<Arguments> provideParamsForPositiveAddEmployeeMethodTest() {
        return Stream.of(
                Arguments.of("Ivan", "Ivanov", 25.6f, 3),
                Arguments.of("Serg", "Grigorjev", 23.2f, 3)
        );
    }

    @ParameterizedTest  // проверка добавления новых работников
    @MethodSource("provideParamsForPositiveAddEmployeeMethodTest")
    public void positiveTest_AddEmployee(String firstName, String lastName, Float salary, Integer department) {
        int numberOfEmployeesBeforeAdding = employeeServiceImpl.getEmployees().size();
        Employee actualResult = employeeServiceImpl.addEmployee(firstName, lastName, salary, department);
        Assertions.assertEquals(new Employee(firstName, lastName, salary, department), actualResult);
        // проверка увеличения списка работников после добавления
        Assertions.assertEquals(numberOfEmployeesBeforeAdding + 1, employeeServiceImpl.getEmployees().size());
        // проверка наличия добавленного работника в списке
        Assertions.assertTrue(employeeServiceImpl.getEmployees().contains(actualResult));
    }

    public static Stream<Arguments> provideParamsForNegativeAddEmployeeMethodTest() {
        return Stream.of(
                Arguments.of(null, "Ivanov", 25.6f, 3),
                Arguments.of("Ivan", null, 25.6f, 3),
                Arguments.of("Serg", "Grigorjev", null, 3),
                Arguments.of("Serg", "Grigorjev", 23.2f, null),
                Arguments.of(null, null, 23.2f, 3),
                Arguments.of(null, "Grigorjev", null, 3),
                Arguments.of(null, "Grigorjev", 23.2f, null),
                Arguments.of("Serg", null, null, 3),
                Arguments.of("Serg", null, 23.2f, null),
                Arguments.of("Serg", "Grigorjev", null, null),
                Arguments.of(null, null, null, 3),
                Arguments.of(null, null, 23.2f, null),
                Arguments.of(null, "Grigorjev", null, null),
                Arguments.of("Serg", null, null, null),
                Arguments.of(null, null, null, null)
        );
    }

    @ParameterizedTest  // проверка добавления работника с невалидными данными
    @MethodSource("provideParamsForNegativeAddEmployeeMethodTest")
    public void negativeTest_AddEmployee(String firstName, String lastName, Float salary, Integer department) {
        Assertions.assertThrows(NoAllParametersException.class, () -> employeeServiceImpl.addEmployee(firstName, lastName, salary, department));
    }

    public static Stream<Arguments> provideParamsForAddEmployeeMethodTest() {
        return Stream.of(
                Arguments.of("Chendler", "Bing", 10000f, 1),
                Arguments.of("Rachel", "Grin", 15000f, 2)
        );
    }

    @ParameterizedTest  // проверка добавления уже существующего работника
    @MethodSource("provideParamsForAddEmployeeMethodTest")
    public void addingAlreadyAddedEmployees_AddEmployeeTest(String firstName, String lastName, Float salary, Integer department) {
        Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> employeeServiceImpl.addEmployee(firstName, lastName, salary, department));
    }

    public static Stream<Arguments> provideParamsForAddEmployeeInFullListOfEmployeeTest() {
        return Stream.of(
                Arguments.of("William", "Shots", 16500f, 2)
        );
    }

    @ParameterizedTest  // проверка добавления работника при отсутствии свободной вакансии
    @MethodSource("provideParamsForAddEmployeeInFullListOfEmployeeTest")
    public void addingEmployeeInFullListOfEmployeeTest(String firstName, String lastName, Float salary, Integer department){
        employeeServiceImpl.addEmployee("Radju", "Gandi", 10000f, 1);
        employeeServiceImpl.addEmployee("Gerbert", "Shildt", 17000f, 4);
        employeeServiceImpl.addEmployee("Laurenciu", "Spilke", 13000f, 3);
        employeeServiceImpl.addEmployee("Creig", "Wols", 11000f, 2);

        Assertions.assertThrows(EmployeeStorageIsFullException.class, () -> employeeServiceImpl.addEmployee(firstName, lastName, salary, department));
    }

    public static Stream<Arguments> provideParamsForPositiveRemoveEmployeeMethodTest() {
        return Stream.of(
                Arguments.of("Chendler", "Bing", 10000f, 1),
                Arguments.of("Rachel", "Grin", 15000f, 2)
        );
    }

    @ParameterizedTest  // проверка удаления существующих работников
    @MethodSource("provideParamsForPositiveRemoveEmployeeMethodTest")
    public void testRemoveEmployee(String firstName, String lastName, Float salary, Integer department){
        int sizeBeforeDeletion = employeeServiceImpl.getEmployees().size(); // размер списка работников до удаления работника
        Employee actualResult = employeeServiceImpl.removeEmployee(firstName, lastName);
        int sizeAfterDeletion = employeeServiceImpl.getEmployees().size();  // размер списка работников после удаления работника
        Assertions.assertEquals(new Employee(firstName, lastName, salary, department), actualResult);
        Assertions.assertEquals(sizeBeforeDeletion - 1, sizeAfterDeletion); // проверка уменьшения размера на единицу
        // проверка отсутствия работника в списке после удаления
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeServiceImpl.removeEmployee(firstName, lastName));
    }

    // поток работников для удаления несуществующих работников
    public static Stream<Arguments> provideParamsForRemoveNoExistEmployeeMethodTest() {
        return Stream.of(
                Arguments.of("Roman", "Semjonov"),
                Arguments.of("Radju", "Gandi")
        );
    }

    @ParameterizedTest // проверка удаления несуществующих работников
    @MethodSource("provideParamsForRemoveNoExistEmployeeMethodTest")
    public void testRemoveNoExistEmployee(String firstName, String lastName){
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> employeeServiceImpl.removeEmployee(firstName, lastName));
    }

    @Test
    public void testGetEmployee(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Chendler", "Bing", 10000f, 1));
        list.add(new Employee("Monica", "Bing", 12000f, 2));
        list.add(new Employee("Rachel", "Grin", 15000f, 2));
        list.add(new Employee("Fuiby", "Buffey", 14000f, 2));
        list.add(new Employee("Ross", "Geller", 16000f, 1));
        list.add(new Employee("Joe", "Tribiany", 9000f, 1));

        Assertions.assertEquals(list.size(), employeeServiceImpl.getEmployees().size());
        Assertions.assertEquals(list, employeeServiceImpl.getEmployees());
    }

}
