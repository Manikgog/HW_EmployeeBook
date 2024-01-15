package pro.sky.checkservice;

public interface CheckService {
    void checkNameAndLastName(String name, String lastName);
    void checkVacancy(String name, String lastName);
    void checkingAvailabilityOfEmployee(String name, String lastName);
}
