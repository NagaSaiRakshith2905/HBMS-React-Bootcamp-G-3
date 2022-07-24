package com.cg.hbm.service.classes;

import com.cg.hbm.entities.UserDetails;
import com.cg.hbm.exception_handler.BookingDetailsNotFoundException;
import com.cg.hbm.exception_handler.UserNotFoundException;
import com.cg.hbm.repository.UserRepository;
import com.cg.hbm.service.interfaces.IUserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private IUserService userService = new UserService();

    @Mock
    private UserRepository userRepository;

    @Test
    void addUser() {
        UserDetails userDetails = new UserDetails();
        userDetails.setUser_id(101);
        String user_name = "user_1";
        userDetails.setUser_name(user_name);
        String email = "user1@gmail.com";
        userDetails.setEmail(email);
        String password = "1234";
        userDetails.setPassword(password);

        when(userRepository.save(userDetails)).thenReturn(userDetails);

        UserDetails newUser = userService.addUser(userDetails);

        assertThat(newUser.getUser_name()).isEqualTo(user_name);
        assertThat(newUser.getEmail()).isEqualTo(email);
    }

    @Test
    void removeUser() {
        UserDetails userDetails = new UserDetails();
        int user_id = 101;
        userDetails.setUser_id(user_id);
        String user_name = "user_1";
        userDetails.setUser_name(user_name);
        String email = "user1@gmail.com";
        userDetails.setEmail(email);
        String password = "1234";
        userDetails.setPassword(password);

        when(userRepository.findById(user_id)).thenReturn(Optional.of(userDetails));

        userService.removeUser(user_id);

        verify(userRepository,times(1)).findById(user_id);
        verify(userRepository,times(1)).deleteById(user_id);
    }

    @Test
    void showAllUsers() {
        UserDetails userDetails1 = new UserDetails();
        userDetails1.setUser_id(101);
        userDetails1.setUser_name("user_1");
        userDetails1.setEmail("user1@gmail.com");
        userDetails1.setPassword("1234");

        UserDetails userDetails2 = new UserDetails();
        userDetails2.setUser_id(102);
        userDetails2.setUser_name("user_2");
        userDetails2.setEmail("user2@gmail.com");
        userDetails2.setPassword("1234");

        UserDetails userDetails3 = new UserDetails();
        userDetails3.setUser_id(103);
        userDetails3.setUser_name("user_3");
        userDetails3.setEmail("user3@gmail.com");
        userDetails3.setPassword("1234");

        List<UserDetails> list = new ArrayList<>();
        list.add(userDetails1);
        list.add(userDetails2);
        list.add(userDetails3);

        when(userRepository.findAll()).thenReturn(list);

        List<UserDetails> allUsers = userService.showAllUsers();

        assertThat(allUsers.size()).isEqualTo(3);
    }

    @Test
    void showUser() {
        UserDetails userDetails = new UserDetails();
        int user_id = 101;
        userDetails.setUser_id(user_id);
        String user_name = "user_1";
        userDetails.setUser_name(user_name);
        String email = "user1@gmail.com";
        userDetails.setEmail(email);
        String password = "1234";
        userDetails.setPassword(password);

        when(userRepository.findById(user_id)).thenReturn(Optional.of(userDetails));

        UserDetails newUser = userService.showUser(user_id);

        assertThat(newUser.getUser_name()).isEqualTo(user_name);
    }


    @Test
    void getUserByIdWithException(){
        when(userRepository.findById(101)).thenThrow(UserNotFoundException.class);
        assertThrows(UserNotFoundException.class,()->userService.showUser(101));
    }
}