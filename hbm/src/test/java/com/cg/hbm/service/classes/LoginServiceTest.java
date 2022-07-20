package com.cg.hbm.service.classes;

import com.cg.hbm.entities.Admin;
import com.cg.hbm.entities.UserDetails;
import com.cg.hbm.repository.AdminRepository;
import com.cg.hbm.repository.UserRepository;
import com.cg.hbm.service.interfaces.IAdminService;
import com.cg.hbm.service.interfaces.IUserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class LoginServiceTest {

    @InjectMocks
    private IUserService userService = new UserService();
    @InjectMocks
    private IAdminService adminService = new AdminService();

    @Mock
    private UserRepository userRepository;
    @Mock
    private AdminRepository adminRepository;

    @Test
    void userLogin() {
        UserDetails userDetails = new UserDetails();
        userDetails.setUser_id(101);
        String user_name = "user_1";
        userDetails.setUser_name(user_name);
        String email = "user1@gmail.com";
        userDetails.setEmail(email);
        String password = "1234";
        userDetails.setPassword(password);

        when(userRepository.findUser(user_name)).thenReturn(userDetails);

        UserDetails user = userService.loginUser(user_name, password);
        assertThat(user.getPassword()).isEqualTo(password);

    }

    @Test
    void adminLogin() {
        Admin admin = new Admin();
        admin.setAdmin_id(101);
        String user_name = "admin1";
        admin.setAdmin_name(user_name);
        String password = "1234";
        admin.setPassword(password);

        when(adminRepository.findByAdmin_name(user_name)).thenReturn(admin);

        Admin admin1 = adminService.signIn(user_name, password);
        assertThat(admin1.getPassword()).isEqualTo(password);

    }
}
