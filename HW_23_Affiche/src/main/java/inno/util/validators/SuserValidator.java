package inno.util.validators;

import inno.model.Post;
import inno.model.Suser;
import inno.util.form.UserForm;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SuserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserForm.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserForm form = (UserForm) target;
        if (!form.getPassword().equals(form.getRepassword())) {
            errors.rejectValue("repassword", "", "Passwords are not equal to each other");
        }

        //TODO Проверять юзера на уникальность?
    }
}
