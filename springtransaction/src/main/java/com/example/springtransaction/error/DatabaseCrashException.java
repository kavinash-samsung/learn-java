package com.example.springtransaction.error;


public class DatabaseCrashException extends Exception{
    public DatabaseCrashException(){
        super();
    }
    public DatabaseCrashException(String msg){
        super(msg);
    }
    public DatabaseCrashException(Throwable cause){
        super(cause);
    }
    public DatabaseCrashException(String msg, Throwable cause){
        super(msg, cause);
    }
    public DatabaseCrashException(String msg, Throwable cause, Boolean enableSupression, Boolean writableStack){
        super(msg, cause, enableSupression, writableStack);
    }
}
