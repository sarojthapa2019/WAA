package edu.mum.cs.waa.lab.restfulemployeeserver_lab8.exception;

import java.util.ArrayList;
import java.util.List;

public class DomainErrors {
    private String errorType;
    private String message;
    private List<DomainError> errors = new ArrayList<>();

    public List<DomainError> getErrors(){
        return errors;
    }
    public void addError(DomainError error){
        errors.add(error);
    }
    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
