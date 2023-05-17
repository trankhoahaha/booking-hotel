package com.example.hotelBooking.service;

import com.example.hotelBooking.entity.ERole;
import com.example.hotelBooking.entity.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(ERole name);
}
