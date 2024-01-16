package pro.sky.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pro.sky.model.ErrorMessage;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(EmployeeAlreadyAddedException.class)
    public ResponseEntity<ErrorMessage> addEmployeeException(EmployeeAlreadyAddedException exception){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage(exception.getMessage()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorMessage> employeeNotFoundException(EmployeeNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(exception.getMessage()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EmployeeStorageIsFullException.class)
    public ResponseEntity<ErrorMessage> listOfEmployeeIsFullException(EmployeeStorageIsFullException exception){
        return ResponseEntity.status(HttpStatus.REQUEST_ENTITY_TOO_LARGE).body(new ErrorMessage(exception.getMessage()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NoAllParametersException.class)
    public ResponseEntity<ErrorMessage> noAllParametersException(NoAllParametersException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(exception.getMessage()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NoSuchDepartmentException.class)
    public ResponseEntity<ErrorMessage> noSuchDepartmentException(NoSuchDepartmentException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(exception.getMessage()));
    }

}
