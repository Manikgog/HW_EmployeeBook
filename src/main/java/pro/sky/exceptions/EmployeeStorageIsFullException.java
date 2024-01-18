package pro.sky.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(){
        super();
    }

    public EmployeeStorageIsFullException(String str){
        super(str);
    }

    @Override
    public String toString(){
        return super.getMessage();
    }
}
