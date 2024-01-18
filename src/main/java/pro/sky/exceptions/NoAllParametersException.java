package pro.sky.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoAllParametersException extends IllegalArgumentException {
    public NoAllParametersException(){
        super();
    }

    public NoAllParametersException(String str){
        super(str);
    }

    @Override
    public String toString(){
        return super.getMessage();
    }
}
