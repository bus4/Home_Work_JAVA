package inno.util.transformers;

import inno.model.Suser;
import inno.util.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserFormTransformer {

    @Autowired
    BCryptPasswordEncoder encoder;

    public Suser toSuser(UserForm form){
        Suser suser = new Suser();
        suser.setName(form.getMail());
        suser.setPassword(encoder.encode(form.getPassword()));

        return suser;
    }

}
