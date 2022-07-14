package com.cg.hbm.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class UserDetails {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int user_id;
    private String user_name;
    private String email;
    private String password;
    private String role;
    private String mobile;
    private String address;

    public UserDetails() {
    }

    public UserDetails(String user_name, String email, String password, String mobile, String address) {
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.role = "user";
        this.mobile = mobile;
        this.address = address;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
