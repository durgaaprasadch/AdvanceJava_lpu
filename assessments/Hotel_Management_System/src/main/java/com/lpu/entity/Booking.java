package com.lpu.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "booking_details")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @Column(nullable = false)
    private String customerName;

    private String roomType;
    private String checkInDate;
    private String checkOutDate;
    private double totalAmount;

    // default constructor
    public Booking() {}

    // constructor with values
    public Booking(String customerName, String roomType,
                   String checkInDate, String checkOutDate) {
        this.customerName = customerName;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        calculateAmount();
    }

    // amount calculation based on room type
    private void calculateAmount() {
        int price = 0;

        if (roomType.equalsIgnoreCase("Standard"))
            price = 2000;
        else if (roomType.equalsIgnoreCase("Deluxe"))
            price = 3500;
        else if (roomType.equalsIgnoreCase("Suite"))
            price = 5000;

        long days = ChronoUnit.DAYS.between(
                LocalDate.parse(checkInDate),
                LocalDate.parse(checkOutDate)
        );

        totalAmount = days * price;
    }

    // getters and setters
    public int getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
        calculateAmount();
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
