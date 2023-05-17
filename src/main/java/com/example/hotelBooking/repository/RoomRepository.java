package com.example.hotelBooking.repository;

import com.example.hotelBooking.entity.Room;
import com.example.hotelBooking.payload.request.SearchRoomRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("SELECT r FROM Room r WHERE r.type IN :#{#searchPayload.types} " +
            "AND r.adultsMax <= :#{#searchPayload.adultsMax} " +
            "AND r.childrenMax <= :#{#searchPayload.childrenMax}")
    List<Room> searchRoom(@Param("searchPayload") SearchRoomRequest searchPayload);

    List<Room> findByStatus(String status);
}
