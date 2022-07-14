package com.cg.hbm.service;

import com.cg.hbm.entities.Admin;

public interface IAdminService {
    public Admin signIn(Admin admin);
    public Admin signOut(Admin admin);
}
