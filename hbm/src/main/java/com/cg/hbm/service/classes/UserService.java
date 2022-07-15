package com.cg.hbm.service.classes;

import com.cg.hbm.entities.UserDetails;
import com.cg.hbm.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {
    @Override
    public UserDetails addUser(UserDetails user) {
        return null;
    }

    @Override
    public UserDetails updateUser(UserDetails user) {
        return null;
    }

    @Override
    public UserDetails removeUser(UserDetails user) {
        return null;
    }

    @Override
    public List<UserDetails> showAllUsers() {
        return null;
    }

    @Override
    public UserDetails showUser(UserDetails user) {
        return null;
    }
}
