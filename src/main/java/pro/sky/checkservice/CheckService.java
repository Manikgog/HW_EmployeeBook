package pro.sky.checkservice;

public interface CheckService {
    void checkParameters(String name, String lastName, Float salary, Integer department);
    void checkNameAndLastName(String name, String lastName);
    void checkVacancy();
    void checkingAvailabilityOfEmployee(String name, String lastName);
    void checkEmployeeInList(String name, String lastName);
    void checkNumberDepartment(int department);
}
