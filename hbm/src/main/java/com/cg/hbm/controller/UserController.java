package com.cg.hbm.controller;

import com.cg.hbm.entities.RoomDetails;
import com.cg.hbm.entities.User;
import com.cg.hbm.pojo.RoomDetailsPojo;
import com.cg.hbm.service.classes.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/user/")
    public class UserController {

        @Autowired
        private UserService userService;

        @PostMapping("add_user/")
        public User addUser(@RequestBody User user) {
            return userService.addUser(user);
        }

        @GetMapping("view_user/")
        public User showUser(@RequestParam("user_id") int id) {
            return userService.showUser(id);
        }

        @GetMapping("view_allUsers/")
        public List<User> showAllUsers() {
            return userService.showAllUsers();
        }

        @DeleteMapping("remove_user")
        public void removeUser(@RequestParam("user_id") int id) {
            userService.removeUser(id);
        }

        @PutMapping("update_user")
        public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
    }

