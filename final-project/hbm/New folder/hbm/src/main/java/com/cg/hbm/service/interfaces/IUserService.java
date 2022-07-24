package com.cg.hbm.service.interfaces;

import com.cg.hbm.entities.UserDetails;
import com.cg.hbm.pojo.UserUpdatePojo;

import java.util.List;

public interface IUserService {
    public UserDetails loginUser(String Username, String Password);

    public UserDetails addUser(UserDetails user);

    public UserDetails updateUser(UserUpdatePojo userUpdatePojo);

    public void removeUser(int id);

    public List<UserDetails> showAllUsers();

    public UserDetails showUser(int id);
}
