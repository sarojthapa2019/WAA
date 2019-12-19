package edu.mum.cs.waa.exam.waaexamserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
public class EmployeeExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public @ResponseBody
    DomainErrors handleValidation(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrorList = bindingResult.getFieldErrors();

        DomainErrors domainErrors = new DomainErrors();
        domainErrors.setErrorType("ValidationError");
        for(FieldError fieldError: fieldErrorList){
            domainErrors.addError(new DomainError(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return domainErrors;
    }
}
