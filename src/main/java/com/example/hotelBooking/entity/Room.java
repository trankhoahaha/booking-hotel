package com.example.hotelBooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rooms")
public class Room {
    @Id
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "adults_max")
    private int adultsMax;

    @Column(name = "children_max")
    private int childrenMax;

    @Column(name = "status")
    private String status;

    @Column(name = "price")
    private double price;

    @OneToMany
    @JoinColumn(referencedColumnName = "room_id")
    private List<Image> images;
}
