package com.cg.hbm.service.classes;

import com.cg.hbm.entities.User;
import com.cg.hbm.repository.UserRepository;
import com.cg.hbm.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User addUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {

        Optional<User> optionalUser = userRepository.findById(user.getUser_id());
        if(optionalUser.isEmpty())
            throw new IllegalStateException("User with id:"+ user.getUser_id()+" not found ");
        return userRepository.save(user);
    }

    @Override
    public void removeUser(int id) {

        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty())
            throw new IllegalStateException("User with id:"+ id+" not found ");
        userRepository.deleteById(id);
    }


    @Override
    public List<User> showAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public User showUser(int id) {

        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty())
            throw new IllegalStateException("User with id:"+ id+" not found ");
        return optionalUser.get();
    }
}
