package edu.mum.cs.waa.exam.category_exam_rest_server.exception;

import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTO {
    private String errorType;
    private String message;
    private List<FieldErrorDTO> fieldErrorDTOList = new ArrayList<>();

    public ValidationErrorDTO() {

    }

    public void addError(FieldErrorDTO field){
        fieldErrorDTOList.add(field);
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
