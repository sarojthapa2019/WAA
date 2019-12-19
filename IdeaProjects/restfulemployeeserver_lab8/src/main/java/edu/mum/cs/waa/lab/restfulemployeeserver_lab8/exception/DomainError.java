package edu.mum.cs.waa.lab.restfulemployeeserver_lab8.exception;

public class DomainError {
    private String message;
    private String field;
    public DomainError(String field, String message){
        this.message = message;
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
