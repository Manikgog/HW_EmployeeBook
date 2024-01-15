package pro.sky.checkservice;

import org.springframework.stereotype.Service;
import pro.sky.exceptions.EmployeeAlreadyAddedException;
import pro.sky.exceptions.EmployeeStorageIsFullException;
import pro.sky.exceptions.NoAllParametersException;
import pro.sky.model.Employee;
import pro.sky.repo.ListOfEmployees;

@Service
public class CheckServiceImpl implements CheckService{

    private final ListOfEmployees listOfEmployees;

    public CheckServiceImpl(ListOfEmployees listOfEmployees){
        this.listOfEmployees = listOfEmployees;
    }
    public void checkNameAndLastName(String name, String lastName){
        if(name == null && lastName == null){
            throw new NoAllParametersException("необходимо ввести имя и фамилию.");
        }else if(name == null){
            throw new NoAllParametersException("необходимо ввести имя.");
        }else if(lastName == null){
            throw new NoAllParametersException("необходимо ввести фамилию.");
        }
    }

    public void checkVacancy(String name, String lastName){
        if(listOfEmployees.getAll().size() >= listOfEmployees.getMaxNumberOfEmployees()){
            throw new EmployeeStorageIsFullException("Вакансий нет.");
        }
    }

    public void checkingAvailabilityOfEmployee(String name, String lastName){
        if(listOfEmployees.getAll().contains(new Employee(name, lastName))){
            throw new EmployeeAlreadyAddedException("Работник уже есть в списке");
        }
    }
}
