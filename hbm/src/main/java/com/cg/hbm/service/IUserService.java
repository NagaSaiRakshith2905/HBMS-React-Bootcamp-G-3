package com.cg.hbm.service;

import com.cg.hbm.entities.UserDetails;

import java.util.List;

public interface IUserService {
    public UserDetails addUser(UserDetails user);
    public UserDetails updateUser(UserDetails user);
    public UserDetails removeUser(UserDetails user);
    public List<UserDetails> showAllUsers();
    public UserDetails showUser(UserDetails user);
}
