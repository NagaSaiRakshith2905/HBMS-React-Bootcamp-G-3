package com.cg.hbm.service.classes;

import com.cg.hbm.entities.RoomDetails;
import com.cg.hbm.service.interfaces.IRoomDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoomDetailsService implements IRoomDetailsService {
    @Override
    public RoomDetails addRoomDetails(RoomDetails roomDetails) {
        return null;
    }

    @Override
    public RoomDetails updateRoomDetails(RoomDetails roomDetails) {
        return null;
    }

    @Override
    public RoomDetails removeRoomDetails(RoomDetails roomDetails) {
        return null;
    }

    @Override
    public List<RoomDetails> showAllRoomDetails() {
        return null;
    }

    @Override
    public RoomDetails showRoomDetails(int roomDetails_id) {
        return null;
    }
}
