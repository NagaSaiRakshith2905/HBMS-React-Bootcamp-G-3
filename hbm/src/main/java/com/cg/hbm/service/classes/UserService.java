package com.cg.hbm.service.classes;

import com.cg.hbm.entities.User;
import com.cg.hbm.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {
    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User removeUser(User user) {
        return null;
    }

    @Override
    public List<User> showAllUsers() {
        return null;
    }

    @Override
    public User showUser(User user) {
        return null;
    }
}
