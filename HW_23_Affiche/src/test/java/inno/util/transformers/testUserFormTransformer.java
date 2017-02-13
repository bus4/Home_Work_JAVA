package inno.util.transformers;

import inno.util.form.UserForm;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class testUserFormTransformer {

    @Test
    public void testTransformPassword (){
        UserForm userForm = new UserForm();
        userForm.setPassword("123");
        UserFormTransformer userFormTransformer = new UserFormTransformer();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userFormTransformer.encoder = encoder;
        userFormTransformer.toSuser(userForm).getPassword();

        Assert.assertTrue(encoder.matches("123", userFormTransformer.toSuser(userForm).getPassword()));
    }
}
