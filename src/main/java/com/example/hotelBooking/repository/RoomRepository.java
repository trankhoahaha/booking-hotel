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
    @Query("select max(r.adultsMax) from Room r")
    int getMaxNumberOfAdult();

    @Query("select max(r.childrenMax) from Room r")
    int getMaxNumberOfChildren();

    @Query("SELECT r FROM Room r WHERE " +
            ":#{#searchPayload.adultsMax} <= r.adultsMax and " +
            ":#{#searchPayload.childrenMax} <= r.childrenMax and " +
            "r.id NOT IN " +
            "(SELECT b.room.id FROM Booking b WHERE " +
            "((:#{#searchPayload.endDate} > b.checkInDate AND :#{#searchPayload.endDate}  < b.checkOutDate) OR " +
            "(:#{#searchPayload.startDate}  > b.checkInDate AND :#{#searchPayload.startDate}  < b.checkOutDate) OR " +
            "(:#{#searchPayload.startDate}  <= b.checkInDate AND :#{#searchPayload.endDate}  >= b.checkOutDate)) " +
            "AND b.status in ('booked', 'checked in'))")
    List<Room> searchRoomByAvailability(@Param("searchPayload") SearchRoomRequest searchPayload);

}
