package com.cg.hbm.service.interfaces;

import com.cg.hbm.entities.Admin;

public interface IAdminService {
    public Admin signIn(String adminUsername, String adminPassword);
}
