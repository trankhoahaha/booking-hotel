package com.example.hotelBooking.service.impl;

import com.example.hotelBooking.entity.Room;
import com.example.hotelBooking.payload.request.SearchRoomRequest;
import com.example.hotelBooking.repository.RoomRepository;
import com.example.hotelBooking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    @Override
    public List<Room> getAllRoom() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    @Override
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Long id, Room updatedRoom) {
        Room existingRoom = roomRepository.findById(id).orElse(null);
        if (existingRoom != null) {
            existingRoom.setType(updatedRoom.getType());
            existingRoom.setAdultsMax(updatedRoom.getAdultsMax());
            existingRoom.setChildrenMax(updatedRoom.getChildrenMax());
            existingRoom.setDescription(updatedRoom.getDescription());
            existingRoom.setStatus(updatedRoom.getStatus());
            existingRoom.setPrice(updatedRoom.getPrice());
            // Update images if provided
            if (updatedRoom.getImages() != null) {
                existingRoom.setImages(updatedRoom.getImages());
            }
            return roomRepository.save(existingRoom);
        }
        return null;
    }


    @Override
    public Boolean deleteRoom(Long id) {
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Room> searchRoom(SearchRoomRequest searchRoomRequest) {
        return roomRepository.searchRoom(searchRoomRequest);
    }

    @Override
    public List<Room> searchRoomByStatus(String status) {
        if(StringUtils.isEmpty(status)) {
            return roomRepository.findAll();
        }
        return roomRepository.findByStatus(status);
    }
}
