package com.example.hotelBooking.repository;

import com.example.hotelBooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Modifying
    @Query("UPDATE Booking b SET b.status = :status WHERE b.id = :id")
    Boolean updateStatusById(@Param("id") Long id, @Param("status") String status);

    @Query("SELECT b FROM Booking b WHERE b.checkInDate = cast(:today as date) AND b.status = 'booked'")
    List<Booking> getAllCheckInToday(@Param("today") String today);

    List<Booking> getBookingByStatus(String status);

}
