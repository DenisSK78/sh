package by.den.configuration.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AddressValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
