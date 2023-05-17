package com.example.hotelBooking.service;

import com.example.hotelBooking.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUser();

    Optional<User> getUserById(Long id);

    void createUser(User user);

    User updateUser(Long id, User user);

    Boolean deleteUser(Long id);

    Boolean existsUserByUsername(String username);

    Boolean existsUserByEmail(String email);

    Boolean existsUserByPhoneNumber(String phoneNumber);
}
