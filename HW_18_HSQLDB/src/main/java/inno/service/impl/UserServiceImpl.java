package inno.service.impl;

import inno.model.Suser;
import inno.repository.UserRepository;
import inno.service.UserService;
import inno.util.form.UserForm;
import inno.util.transformers.UserFormTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserFormTransformer transformer;

//    @PostConstruct
//    public void initialize() {
//    }

    @Override
    public void saveUser(UserForm form) {
        Suser suser = transformer.toSuser(form);
        userRepository.save(suser);
    }
}
