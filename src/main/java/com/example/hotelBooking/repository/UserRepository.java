package com.example.hotelBooking.repository;

import com.example.hotelBooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsUserByUsername(String username);

    Boolean existsUserByEmail(String email);

    Boolean existsUserByPhoneNumber(String phoneNumber);
}
