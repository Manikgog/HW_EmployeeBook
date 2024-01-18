package pro.sky.model;

import lombok.Getter;

import java.util.Objects;

public class Employee {
    private static int countId = 0;
    @Getter
    private final int id;
    @Getter
    private final float salary;             // зарплата
    @Getter
    private final int department;        // отдел
    @Getter
    private final String lastName;    // фамилия
    private final String firstname;   // имя
    public Employee(String firstname, String lastName, float salary, int department){
        countId++;
        this.id = countId;
        this.lastName = lastName;
        this.firstname = firstname;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public boolean equals(Object employee){
        if(this == employee){
            return true;
        }
        if (employee == null || this.getClass() != employee.getClass()) {
            return false;
        }
        Employee e = (Employee) employee;
        return this.lastName.equals(e.lastName) &&
                this.firstname.equals(e.firstname) &&
                this.salary == e.salary &&
                this.department == e.department;
    }

    @Override public int hashCode() {
        return Objects.hash(this.firstname, this.lastName);
    }

    public String getFirstName(){
        return this.firstname;
    }


}