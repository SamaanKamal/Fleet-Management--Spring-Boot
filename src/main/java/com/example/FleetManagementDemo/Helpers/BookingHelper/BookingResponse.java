package com.example.FleetManagementDemo.Helpers.BookingHelper;

import com.example.FleetManagementDemo.Entity.Booking;

import java.util.List;

public class BookingResponse {
    List<Booking> bookings;

    public BookingResponse(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}
