package com.cg.hbm.controller;

import com.cg.hbm.entities.Admin;
import com.cg.hbm.entities.UserDetails;
import com.cg.hbm.service.classes.AdminService;
import com.cg.hbm.service.classes.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/login/")
public class LoginController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;


    @PostMapping(path = "adminLogin")
    public Admin adminLogin(@RequestParam("admin_name") String adminUsername,
                            @RequestParam("password") String adminPassword){
        return adminService.signIn(adminUsername, adminPassword);
    }

    @PostMapping(path = "userLogin")
    public UserDetails userLogin(@RequestParam("user_name") String Username,
                                 @RequestParam("password") String Password){
        return userService.loginUser(Username, Password);
    }
}
