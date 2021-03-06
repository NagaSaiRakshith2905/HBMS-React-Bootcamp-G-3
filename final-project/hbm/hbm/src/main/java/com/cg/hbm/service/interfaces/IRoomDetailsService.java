package com.cg.hbm.service.interfaces;

import com.cg.hbm.entities.RoomDetails;
import com.cg.hbm.pojo.RoomDetailsUpdatePojo;

import java.util.List;

public interface IRoomDetailsService {
    public RoomDetails addRoomDetails(RoomDetails roomDetails);
    public RoomDetails updateRoomDetails(RoomDetailsUpdatePojo roomDetailsUpdatePojo);
    public void removeRoomDetails(int roomDetails_id);
    public List<RoomDetails> showAllRoomDetails();
    public RoomDetails showRoomDetails(int roomDetails_id);
}
