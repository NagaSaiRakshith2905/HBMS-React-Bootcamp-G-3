package com.cg.hbm.service.classes;

import com.cg.hbm.entities.Admin;
import com.cg.hbm.exception_handler.UserNotFoundException;
import com.cg.hbm.repository.AdminRepository;
import com.cg.hbm.service.interfaces.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
@Transactional
public class AdminService implements IAdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin signIn(String adminUsername, String adminPassword) {

        Admin admin = adminRepository.findByAdmin_name(adminUsername);
        Optional<Admin> adminName = Optional.of(admin);
        if (adminName.isPresent()){
            if(adminName.get().getPassword().equals(adminPassword)){
                return adminName.get();
            }
            else
                throw new UserNotFoundException("Incorrect Password");
        }
        else
            throw new UserNotFoundException("Admin doesn't exists");
    }

    @Override
    public Admin signOut(Admin admin) {
        return null;
    }
}
