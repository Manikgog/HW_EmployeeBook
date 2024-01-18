package pro.sky.exceptions;

public class NoSuchDepartmentException extends IllegalArgumentException {
    public NoSuchDepartmentException(){
        super();
    }

    public NoSuchDepartmentException(String str){
        super(str);
    }

    @Override
    public String toString(){
        return super.getMessage();
    }
}
