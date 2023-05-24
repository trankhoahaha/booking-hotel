package com.example.hotelBooking.controller;

import com.example.hotelBooking.entity.Room;
import com.example.hotelBooking.payload.request.SearchRoomRequest;
import com.example.hotelBooking.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rooms")
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRoom();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        Room room = roomService.getRoomById(id);
        if (room != null) {
            return ResponseEntity.ok(room);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room createdRoom = roomService.createRoom(room);

        if (!ObjectUtils.isEmpty(room)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdRoom);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room updatedRoom) {
        Room room = roomService.updateRoom(id, updatedRoom);
        if (room != null) {
            return ResponseEntity.ok(room);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        boolean deleted = roomService.deleteRoom(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/search")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<List<Room>> searchRoom(@RequestBody SearchRoomRequest searchRoomRequest) {
        List<Room> rooms = roomService.searchRoomByAvailability(searchRoomRequest);
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/max-adult")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Integer> getMaxNumberOfAdult() {
        try {
            int maxAdults = roomService.getMaxNumberOfAdult();
            return ResponseEntity.ok(maxAdults);
        } catch (Exception e) {
            // Handle any exceptions or error cases
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/max-children")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Integer> getMaxNumberOfChildren() {
        try {
            int maxChildren = roomService.getMaxNumberOfChildren();
            return ResponseEntity.ok(maxChildren);
        } catch (Exception e) {
            // Handle any exceptions or error cases
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
