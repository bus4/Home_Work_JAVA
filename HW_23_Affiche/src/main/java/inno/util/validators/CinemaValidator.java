package inno.util.validators;

import inno.model.Cinema;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CinemaValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Cinema.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Cinema cinema = (Cinema) o;

        if (StringUtils.isEmpty(cinema.getName()) || cinema.getName().length() < 2) {
            errors.rejectValue("name", "", "Название должно быть минимум 2 символа");
        }

        if (StringUtils.isEmpty(cinema.getDescription()) || cinema.getDescription().length() < 10) {
            errors.rejectValue("description", "", "Описание должно быть минимум 10 символов");
        }
    }
}
