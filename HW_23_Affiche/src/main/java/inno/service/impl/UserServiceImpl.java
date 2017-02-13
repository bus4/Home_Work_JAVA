package inno.service.impl;

import inno.model.Comment;
import inno.model.Post;
import inno.model.Role;
import inno.model.Suser;
import inno.repository.RoleRepository;
import inno.repository.UserRepository;
import inno.service.UserService;
import inno.util.form.UserForm;
import inno.util.transformers.UserFormTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
//@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private static final String DEFAULY_ROLE_NAME = "ROLE_USER";
    private Role defaultRole;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserFormTransformer transformer;

    @PostConstruct
    public void initialize() {
        defaultRole = roleRepository.findByName(DEFAULY_ROLE_NAME);
    }

    @Override
    public void saveUser(UserForm form) {

        Suser suser = transformer.toSuser(form);
        List<Post> npost = new ArrayList<>();
        Set<Role> nrole = new HashSet<>();
        nrole.add(defaultRole);
//        suser.setPosts(npost);
        suser.setRoles(nrole);
        userRepository.save(suser);
    }
}
