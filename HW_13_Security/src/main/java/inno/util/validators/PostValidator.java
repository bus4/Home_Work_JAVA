package inno.util.validators;

import inno.model.Post;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PostValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Post.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Post post = (Post) o;

        if (StringUtils.isEmpty(post.getTitle()) || post.getTitle().length() < 5) {
            errors.rejectValue("title", "", "Заголовок должен быть минимум 5 символов");
        }

        if (StringUtils.isEmpty(post.getText()) || post.getText().length() < 10) {
            errors.rejectValue("text", "", "Текст должен быть минимум 10 символов");
        }
    }
}
