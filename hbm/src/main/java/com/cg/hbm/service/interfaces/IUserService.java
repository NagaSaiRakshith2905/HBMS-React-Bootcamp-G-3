package com.cg.hbm.service.interfaces;

import com.cg.hbm.entities.User;

import java.util.List;

public interface IUserService {
    public User addUser(User user);
    public User updateUser(User user);
    public User removeUser(User user);
    public List<User> showAllUsers();
    public User showUser(User user);
}
