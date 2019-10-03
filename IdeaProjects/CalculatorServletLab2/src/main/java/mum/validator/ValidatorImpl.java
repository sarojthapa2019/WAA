package mum.validator;

import mum.domain.Calculator;

import javax.jnlp.IntegrationService;
import java.util.ArrayList;
import java.util.List;

public class ValidatorImpl implements Validator {
    @Override
    public List<String> validate(Object object) {
        List<String> errors  = new ArrayList<String>();
        Calculator calculator = (Calculator) object;
        Integer add1 = calculator.getAdd1();
        Integer add2 = calculator.getAdd2();
        Integer mult1 = calculator.getMult1();
        Integer mult2 = calculator.getMult2();
        if((add1 != null && add2 == null) || (add1 == null && add1 != null)){
            errors.add("Number to add cannot be empty");
        }
        if((mult1 != null && mult2 == null) || (mult1 == null && mult2 != null)){
            errors.add("Number to multiply cannot be empty");
        }
        return errors;
    }
}
