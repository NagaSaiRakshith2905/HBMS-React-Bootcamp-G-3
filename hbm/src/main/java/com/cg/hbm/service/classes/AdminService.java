package com.cg.hbm.service.classes;

import com.cg.hbm.entities.Admin;
import com.cg.hbm.service.interfaces.IAdminService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class AdminService implements IAdminService {
    @Override
    public Admin signIn(Admin admin) {
        return null;
    }

    @Override
    public Admin signOut(Admin admin) {
        return null;
    }
}
