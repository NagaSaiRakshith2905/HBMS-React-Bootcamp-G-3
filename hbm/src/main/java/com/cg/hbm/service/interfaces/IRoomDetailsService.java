package com.cg.hbm.service.interfaces;

import com.cg.hbm.entities.RoomDetails;

import java.util.List;

public interface IRoomDetailsService {
    public RoomDetails addRoomDetails(RoomDetails roomDetails);
    public RoomDetails updateRoomDetails(RoomDetails roomDetails);
    public RoomDetails removeRoomDetails(RoomDetails roomDetails);
    public List<RoomDetails> showAllRoomDetails();
    public RoomDetails showRoomDetails(int roomDetails_id);
}
