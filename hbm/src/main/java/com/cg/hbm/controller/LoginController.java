package com.cg.hbm.controller;

import com.cg.hbm.entities.Admin;
import com.cg.hbm.entities.UserDetails;
import com.cg.hbm.service.classes.AdminService;
import com.cg.hbm.service.classes.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/login/")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;


    @PostMapping(path = "admin_login/")
    public Admin adminLogin(@RequestParam("admin_name") String adminUsername,
                            @RequestParam("password") String adminPassword){
        return adminService.signIn(adminUsername, adminPassword);
    }

    @PostMapping(path = "user_login/")
    public UserDetails userLogin(@RequestParam("user_name") String Username,
                                 @RequestParam("password") String Password){
        return userService.loginUser(Username, Password);
    }
}
