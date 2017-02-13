package inno.util.validators;

import inno.model.Film;
import inno.model.Seance;
import inno.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Component
public class SeanceValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Seance.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Seance seance = (Seance) o;

        if (StringUtils.isEmpty(seance.getDate()) || StringUtils.isEmpty(seance.getCinema()) || StringUtils.isEmpty(seance.getFilm())) {
            errors.rejectValue("date", "", "Не все данные введены");
        }

//        if (StringUtils.isEmpty(film.getDescription()) || film.getDescription().length() < 10) {
//            errors.rejectValue("description", "", "Описание должно быть минимум 10 символов");
//        }
    }
}
