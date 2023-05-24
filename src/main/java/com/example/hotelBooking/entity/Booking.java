package com.example.hotelBooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bookings")
public class Booking {
    @Id
    @Column(name = "booking_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "email")
    private String customerEmail;

    @Column(name = "phone_number")
    private String customerPhoneNumber;

    @Column(name = "price")
    private double price;

    @Column(name = "checkin_date")
    @Temporal(TemporalType.DATE)
    private Date checkInDate;

    @Column(name = "checkout_date")
    @Temporal(TemporalType.DATE)
    private Date checkOutDate;

    @Column(name = "adults_number")
    private int adultsNumber;

    @Column(name = "children_number")
    private int childrenNumber;

    @Column(name = "status")
    private String status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id")
    private List<Person> personList;
}
