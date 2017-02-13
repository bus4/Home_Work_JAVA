package inno.util.validators;

import inno.model.Film;
import inno.model.Post;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class FilmValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Film.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Film film = (Film) o;

        if (StringUtils.isEmpty(film.getName()) || film.getName().length() < 2) {
            errors.rejectValue("name", "", "Название должно быть минимум 2 символа");
        }

        if (StringUtils.isEmpty(film.getDescription()) || film.getDescription().length() < 10) {
            errors.rejectValue("description", "", "Описание должно быть минимум 10 символов");
        }
    }
}
