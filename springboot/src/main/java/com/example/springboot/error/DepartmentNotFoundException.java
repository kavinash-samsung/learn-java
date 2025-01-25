package com.example.springboot.error;

public class DepartmentNotFoundException extends Exception{
    public DepartmentNotFoundException(){
        super();
    }
    public DepartmentNotFoundException(String msg){
        super(msg);
    }
    public DepartmentNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
    public DepartmentNotFoundException(Throwable cause){
        super(cause);
    }
    public DepartmentNotFoundException(String message, Throwable cause, Boolean enableSupression, Boolean writableStackTrace){
        super(message, cause, enableSupression, writableStackTrace);
    }
}
