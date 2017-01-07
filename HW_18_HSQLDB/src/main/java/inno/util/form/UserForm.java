package inno.util.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UserForm {


    @NotEmpty(message = "Пароль не может быть пустым")
    @Length(min = 4, message = "Имя пользователя должно быть длиннее 4-х символов и состоять из цифр и букв английского алфавита")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Имя пользователя должно быть длиннее 4-х символов и состоять из цифр и букв английского алфавита")
    private String mail;

    @NotEmpty(message = "Пароль не может быть пустым")
    @Length(min = 8, message = "Пароль недостаточно сложен: должны быть цифры, заглавные и строчные буквы и длина минимум 8 символов")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$", message = "Пароль недостаточно сложен: должны быть цифры, заглавные и строчные буквы и длина минимум 8 символов")
    private String password;

    private String repassword;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }
}
