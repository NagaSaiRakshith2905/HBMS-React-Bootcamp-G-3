package com.cg.hbm.service.classes;


import com.cg.hbm.entities.UserDetails;
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
    public UserDetails loginUser(String Username, String Password) {

        UserDetails user = userRepository.findUser(Username);
        Optional<UserDetails> userName = Optional.of(user);
        if (userName.isPresent()){
            if(userName.get().getPassword().equals(Password)){
                return userName.get();
            }
            else
                throw new IllegalStateException("Please check username and password");
        }
        else
            throw new IllegalStateException("User doesn't exists");
    }

    @Override
    public UserDetails addUser(UserDetails user) {

        return userRepository.save(user);
    }

    @Override
    public UserDetails updateUser(UserDetails user) {

        Optional<UserDetails> optionalUser = userRepository.findById(user.getUser_id());
        if(optionalUser.isEmpty())
            throw new IllegalStateException("User with id:"+ user.getUser_id()+" not found ");
        return userRepository.save(user);
    }

    @Override
    public void removeUser(int id) {

        Optional<UserDetails> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty())
            throw new IllegalStateException("User with id:"+ id+" not found ");
        userRepository.deleteById(id);
    }


    @Override
    public List<UserDetails> showAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public UserDetails showUser(int id) {

        Optional<UserDetails> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty())
            throw new IllegalStateException("User with id:"+ id+" not found ");
        return optionalUser.get();
    }
}
