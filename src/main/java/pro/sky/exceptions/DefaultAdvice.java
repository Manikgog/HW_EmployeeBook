package pro.sky.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pro.sky.model.ErrorMessage;


@ControllerAdvice
public class DefaultAdvice {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorMessage> employeeNotFoundException(EmployeeNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(exception.getMessage()));
    }

    @ExceptionHandler(EmployeeStorageIsFullException.class)
    public ResponseEntity<ErrorMessage> listOfEmployeeIsFullException(EmployeeStorageIsFullException exception){
        return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).body(new ErrorMessage(exception.getMessage()));
    }

    @ExceptionHandler(NoAllParametersException.class)
    public ResponseEntity<ErrorMessage> noAllParametersException(NoAllParametersException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(exception.getMessage()));
    }

    @ExceptionHandler(NoSuchDepartmentException.class)
    public ResponseEntity<ErrorMessage> noSuchDepartmentException(NoSuchDepartmentException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(exception.getMessage()));
    }

}
