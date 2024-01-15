package pro.sky.model;

import java.util.Objects;

public class Employee {
    private final String lastName;    // фамилия
    private final String firstname;   // имя
    public Employee(String firstname, String lastName){
        this.lastName = lastName;
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "{<br>" +
                "\"lastName\"=\"" + lastName + "\"" +
                ",<br>\"firstname\"=\"" + firstname + "\"<br>" +
                "}";
    }

    @Override public boolean equals(Object employee){
        if(this == employee){
            return true;
        }
        if (employee == null || this.getClass() != employee.getClass()) {
            return false;
        }
        Employee e = (Employee) employee;
        return this.lastName.equals(e.lastName) &&
                this.firstname.equals(e.firstname);
    }

    @Override public int hashCode() {
        return Objects.hash(this.firstname, this.lastName);
    }

    public String getLastName(){
        return this.lastName;
    }
    public String getFirstName(){
        return this.firstname;
    }


}