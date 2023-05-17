package com.example.hotelBooking.service.impl;

import com.example.hotelBooking.entity.ERole;
import com.example.hotelBooking.entity.Role;
import com.example.hotelBooking.repository.RoleRepository;
import com.example.hotelBooking.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(ERole name) {
        return roleRepository.findByName(name);
    }
}
