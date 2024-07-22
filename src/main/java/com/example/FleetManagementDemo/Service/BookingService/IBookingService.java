package com.example.FleetManagementDemo.Service.BookingService;

import com.example.FleetManagementDemo.Entity.Booking;
import com.example.FleetManagementDemo.Entity.Seat;
import com.example.FleetManagementDemo.Entity.Trip;
import com.example.FleetManagementDemo.Helpers.BookingHelper.BookingRequest;

import java.util.List;

public interface IBookingService {
    List<Seat> getAvailableSeats(Long tripId,Long busId);
    Booking createBooking(BookingRequest bookingRequest);
    List<Booking>findAllBookings();
    Booking findBookingById(Long id);

    Booking updateBooking(BookingRequest bookingRequest,Long bookingId);

    boolean deleteBooking(Long bookingId);

}
