package pro.sky.repo;

import pro.sky.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOfEmployeesImpl implements ListOfEmployees {
    private List<Employee> listOfEmployees;
    private final int maxNumberOfEmployees = 10;

    public ListOfEmployeesImpl(){
        this.listOfEmployees = new ArrayList<>();
    }
    public void add(Employee employee){
        listOfEmployees.add(employee);
    }

    public void remove(Employee employee){
        listOfEmployees.remove(employee);
    }

    public List<Employee> getAll(){
        return Collections.unmodifiableList(listOfEmployees);
    }

    public int getMaxNumberOfEmployees(){
        return maxNumberOfEmployees;
    }

    public Employee get(Employee employee){
        return listOfEmployees.get(listOfEmployees.indexOf(employee));
    }
}
