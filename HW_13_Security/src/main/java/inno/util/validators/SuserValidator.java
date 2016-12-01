package inno.util.validators;

import inno.model.Post;
import inno.model.Suser;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//@Component
public class SuserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Suser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Suser suser = (Suser) o;

//        if (StringUtils.isEmpty(suser.getTitle()) || suser.getTitle().length() < 5) {
//            errors.rejectValue("mail", "", "Заголовок должен быть минимум 5 символов");
//        }
//
//        if (StringUtils.isEmpty(suser.getText()) || suser.getText().length() < 10) {
//            errors.rejectValue("password", "", "Текст должен быть минимум 10 символов");
//        }

    }
}
