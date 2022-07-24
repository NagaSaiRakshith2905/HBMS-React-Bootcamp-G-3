package com.cg.hbm.service.classes;

import com.cg.hbm.entities.UserDetails;
import com.cg.hbm.exception_handler.UserNotFoundException;
import com.cg.hbm.pojo.UserUpdatePojo;
import com.cg.hbm.repository.UserRepository;
import com.cg.hbm.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loginUser(String Username, String Password) {
        Optional<UserDetails> user = userRepository.findUser(Username);
        if (user.isPresent()) {
            if (user.get().getPassword().equals(Password)) {
                return user.get();
            } else
                throw new UserNotFoundException("Incorrect password");
        } else
            throw new UserNotFoundException("Username doesn't exists");
    }

    @Override
    public UserDetails addUser(UserDetails user) {
        Optional<UserDetails> optional = userRepository.findUser(user.getUser_name());
        if (optional.isPresent())
            throw new UserNotFoundException("User with username:"+user.getUser_name()+"already exist");
        return userRepository.save(user);
    }

    @Override
    public UserDetails updateUser(UserUpdatePojo userUpdatePojo) {

        System.out.println(userUpdatePojo.getUser_id());
        Optional<UserDetails> user = userRepository.findById(userUpdatePojo.getUser_id());

        if (user.isEmpty()) {
            throw new UserNotFoundException("User with id " + userUpdatePojo.getUser_id() + " does not Exist");
        }

        if (userUpdatePojo.getAddress() != null && userUpdatePojo.getAddress().length() > 0 && !Objects.equals(user.get().getAddress(), userUpdatePojo.getAddress())) {
            user.get().setAddress(userUpdatePojo.getAddress());
        }

        if (userUpdatePojo.getEmail() != null && userUpdatePojo.getEmail().length() > 0 && !Objects.equals(user.get().getEmail(), userUpdatePojo.getEmail())) {
            user.get().setEmail(userUpdatePojo.getEmail());
        }

        if (userUpdatePojo.getMobile() != null && userUpdatePojo.getMobile().length() > 0 && !Objects.equals(user.get().getMobile(), userUpdatePojo.getMobile())) {
            user.get().setMobile(userUpdatePojo.getMobile());
        }

        if (userUpdatePojo.getPassword() != null && userUpdatePojo.getPassword().length() > 0 && !Objects.equals(user.get().getPassword(), userUpdatePojo.getPassword())) {
            user.get().setPassword(userUpdatePojo.getPassword());
        }

        if (userUpdatePojo.getRole() != null && userUpdatePojo.getRole().length() > 0 && !Objects.equals(user.get().getRole(), userUpdatePojo.getRole())) {
            user.get().setRole(userUpdatePojo.getRole());
        }

        if (userUpdatePojo.getUser_name() != null && userUpdatePojo.getUser_name().length() > 0 && !Objects.equals(user.get().getUser_name(), userUpdatePojo.getUser_name())) {
            user.get().setUser_name(userUpdatePojo.getUser_name());

        }

        return user.get();

    }

    @Override
    public void removeUser(int id) {
        Optional<UserDetails> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty())
            throw new UserNotFoundException("User with id:" + id + " not found ");
        userRepository.deleteById(id);
    }


    @Override
    public List<UserDetails> showAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails showUser(int id) {
        Optional<UserDetails> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty())
            throw new UserNotFoundException("User with id:" + id + " not found ");
        return optionalUser.get();
    }
}
