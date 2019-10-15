package edu.mum.cs.waa.exam.category_exam_rest_server.exception;

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
public class RestErrorhandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)

    public @ResponseBody ValidationErrorDTO processValidationError(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrorList = result.getFieldErrors();
        ValidationErrorDTO validationErrorDTO = new ValidationErrorDTO();
        validationErrorDTO.setErrorType("ValidationError");
        for(FieldError fieldError: fieldErrorList){
            validationErrorDTO.addError(new FieldErrorDTO(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return validationErrorDTO;
    }
//    private ValidationErrorDTO processFieldError(List<FieldError> fieldErrorList){
////        ValidationErrorDTO validationErrorDTO = new ValidationErrorDTO("ValidationError");
////        for(FieldError fieldError: fieldErrorList){
////            validationErrorDTO.addError(fieldError.getField(), fieldError.getDefaultMessage());
////        }
////        return validationErrorDTO;
//    }
}
