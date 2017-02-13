package inno.util.validators;

import inno.model.Film;
import inno.model.FilmComment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class FilmCommentValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return FilmComment.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        FilmComment comment = (FilmComment) o;

        if (StringUtils.isEmpty(comment.getRating()) || comment.getRating() >= 0 || comment.getRating() <= 10) {
            errors.rejectValue("rating", "", "Рейтинг должно быть от 0 до 10 пунктов");
        }
//
//        if (StringUtils.isEmpty(comment.getDescription()) || comment.getDescription().length() < 10) {
//            errors.rejectValue("description", "", "Описание должно быть минимум 10 символов");
//        }
    }
}
