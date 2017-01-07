package inno.util.validators;

//import inno.model.Post;
import inno.model.Suser;
import inno.repository.UserRepository;
import inno.util.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SuserValidator implements Validator {

    @Autowired
    UserRepository repository;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserForm.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserForm form = (UserForm) target;
        if (!form.getPassword().equals(form.getRepassword())) {
            errors.rejectValue("repassword", "", "Пароль и повтор пароля не совпадают");
        }

        if (form.getMail().contains(" ")) {
            errors.rejectValue("mail", "", "Имя пользователя должно быть длиннее 4-х символов и состоять из цифр и букв английского алфавита");
        }

        //TODO Проверять юзера на уникальность?
        if (repository.findByMail(form.getMail())!=null) {
            errors.rejectValue("mail", "", "Пользователь с таким именем уже зарегистрирован");
        }


    }
}
