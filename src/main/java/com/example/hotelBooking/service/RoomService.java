package com.example.hotelBooking.service;

import com.example.hotelBooking.entity.Room;
import com.example.hotelBooking.payload.request.SearchRoomRequest;

import java.util.Date;
import java.util.List;

public interface RoomService {
    List<Room> getAllRoom();

    Room getRoomById(Long id);

    Room createRoom(Room room);

    Room updateRoom(Long id, Room room);

    Boolean deleteRoom(Long id);

    List<Room> searchRoomByAvailability(SearchRoomRequest searchRoomRequest);

    int getMaxNumberOfAdult();

    int getMaxNumberOfChildren();
}
