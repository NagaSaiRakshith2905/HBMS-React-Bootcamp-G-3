package com.cg.hbm.service.interfaces;

import com.cg.hbm.entities.RoomDetails;
import com.cg.hbm.pojo.RoomDetailsPojo;

import java.util.List;

public interface IRoomDetailsService {
    public RoomDetails addRoomDetails(RoomDetailsPojo roomDetails);
    public RoomDetails updateRoomDetails(RoomDetailsPojo roomDetailsPojo);
    public void removeRoomDetails(int roomDetails_id);
    public List<RoomDetails> showAllRoomDetails();
    public RoomDetails showRoomDetails(int roomDetails_id);
}
