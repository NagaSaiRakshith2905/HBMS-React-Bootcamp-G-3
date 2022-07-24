package com.cg.hbm.service.classes;

import com.cg.hbm.entities.Hotel;
import com.cg.hbm.entities.RoomDetails;
import com.cg.hbm.entities.UserDetails;
import com.cg.hbm.exception_handler.BookingDetailsNotFoundException;
import com.cg.hbm.exception_handler.RoomDetailsNotFoundException;
import com.cg.hbm.pojo.RoomDetailsPojo;
import com.cg.hbm.repository.HotelRepository;
import com.cg.hbm.repository.RoomDetailsRepository;
import com.cg.hbm.service.interfaces.IRoomDetailsService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import javax.management.relation.RelationNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RoomDetailsServiceTest {

    @InjectMocks
    private IRoomDetailsService roomDetailsService = new RoomDetailsService();

    @Mock
    private RoomDetailsRepository roomDetailsRepository;


    @Test
    void addRoomDetails() {

        // room details
        RoomDetails roomDetails = new RoomDetails();
        roomDetails.setRoom_id(1);
        roomDetails.setRoom_no("asdf");
        roomDetails.setAvailable(false);

        when(roomDetailsRepository.save(roomDetails)).thenReturn(roomDetails);

        RoomDetails newDetails = roomDetailsService.addRoomDetails(roomDetails);

        assertThat(newDetails.getRoom_id()).isEqualTo(1);
    }

    @Test
    void removeRoomDetails() {
        // room details
        RoomDetails roomDetails = new RoomDetails();
        int room_id = 1;
        roomDetails.setRoom_id(room_id);
        roomDetails.setRoom_no("asdf");
        roomDetails.setAvailable(false);

        when(roomDetailsRepository.findById(room_id)).thenReturn(Optional.of(roomDetails));

        roomDetailsService.removeRoomDetails(room_id);

        verify(roomDetailsRepository,times(1)).findById(room_id);
        verify(roomDetailsRepository,times(1)).deleteById(room_id);
    }

    @Test
    void showAllRoomDetails() {
        RoomDetails roomDetails1 = new RoomDetails();
        roomDetails1.setRoom_id(1);
        roomDetails1.setRoom_no("asdf");
        roomDetails1.setAvailable(false);

        RoomDetails roomDetails2 = new RoomDetails();
        roomDetails2.setRoom_id(1);
        roomDetails2.setRoom_no("asdf");
        roomDetails2.setAvailable(false);

        RoomDetails roomDetails3 = new RoomDetails();
        roomDetails3.setRoom_id(1);
        roomDetails3.setRoom_no("asdf");
        roomDetails3.setAvailable(false);

        List<RoomDetails> roomDetailsList = new ArrayList<>();
        roomDetailsList.add(roomDetails1);
        roomDetailsList.add(roomDetails2);
        roomDetailsList.add(roomDetails3);

        when(roomDetailsRepository.findAll()).thenReturn(roomDetailsList);

        List<RoomDetails> allRooms = roomDetailsService.showAllRoomDetails();

        assertThat(allRooms.size()).isEqualTo(3);
    }

    @Test
    void showRoomDetails() {
        RoomDetails roomDetails = new RoomDetails();
        int room_id = 1;
        roomDetails.setRoom_id(room_id);
        roomDetails.setRoom_no("asdf");
        roomDetails.setAvailable(true);

        when(roomDetailsRepository.findById(room_id)).thenReturn(Optional.of(roomDetails));

        RoomDetails newRoom = roomDetailsService.showRoomDetails(room_id);

        assertThat(newRoom.isAvailable()).isTrue();
    }

    @Test
    void getRoomByIdWithException(){
        when(roomDetailsRepository.findById(101)).thenThrow(RoomDetailsNotFoundException.class);
        assertThrows(RoomDetailsNotFoundException.class,()->roomDetailsService.showRoomDetails(101));
    }
}