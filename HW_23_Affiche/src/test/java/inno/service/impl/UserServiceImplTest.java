package inno.service.impl;

import inno.model.Post;
import inno.model.Suser;
import inno.repository.UserRepository;
import inno.repository.impl.JpaRepository;
import inno.util.form.UserForm;
import inno.util.transformers.UserFormTransformer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:security-config.xml")
public class UserServiceImplTest {

    @Autowired
    UserFormTransformer transformer;

    UserServiceImpl service;
    UserForm form;
    Object suserN;
    UserRepository repository;

    @Before
    public void setUp() {
        form = new UserForm();
        form.setPassword("123");
        form.setMail("sss@sss");
        form.setRepassword("123");
    }

    @Test
    public void testSaveUserToRepository() {
        suserN = transformer.toSuser(form);
        Assert.assertEquals(Suser.class, suserN.getClass());
    }

    @Test
    public void testGoesToRepository() throws Exception {
        repository = Mockito.mock(UserRepository.class);
        service = new UserServiceImpl();
        service.userRepository = repository;
//        Mockito.when(repository.save(suser)).thenReturn(new Post());
        service.saveUser(form);
        Mockito.verify(repository, Mockito.times(1)).save(transformer.toSuser(form));
//        Mockito.verify(repository, Mockito.times(1)).save(transformer.toSuser(form));

//        Assert.assertEquals(Suser.class, suserN.getClass());
    }

}
