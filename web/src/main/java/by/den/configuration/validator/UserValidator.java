package by.den.configuration.validator;

import by.den.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {

    @Autowired
    private Environment environment;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "login", "user.login.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "user.password.empty");

        UserDTO user = (UserDTO) target;

        Pattern pattern;
        if (!user.getLogin().isEmpty() && user.getLogin() != null) {
            pattern = Pattern.compile("^[a-zA-ZS\\.0-9_]+@[a-zA-Z0-9\\.]+\\.[a-zA-Z]{2,6}$",
                    Pattern.CASE_INSENSITIVE);
            if (!(pattern.matcher(user.getLogin()).matches())) {
                errors.rejectValue("login", "user.login.invalid");
            }
        }
        if (!user.getPassword().isEmpty() && user.getPassword() != null) {
            pattern = Pattern.compile("^[a-zA-Z0-9_-]{8,20}$",
                    Pattern.CASE_INSENSITIVE);
            if (!(pattern.matcher(user.getPassword()).matches())) {
                errors.rejectValue("password", "user.password.invalid");
            }
        }
    }
}
