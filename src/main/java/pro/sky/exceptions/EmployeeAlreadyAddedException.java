package pro.sky.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(){
        super();
    }

    public EmployeeAlreadyAddedException(String str){
        super(str);
    }

    @Override
    public String toString(){
        return super.getMessage();
    }
}
