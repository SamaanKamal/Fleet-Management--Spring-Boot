package com.example.FleetManagementDemo.Service.BookingService;

import com.example.FleetManagementDemo.Entity.*;
import com.example.FleetManagementDemo.Helpers.BookingHelper.BookingRequest;
import com.example.FleetManagementDemo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService implements IBookingService{
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private StopRepository stopRepository;
    @Autowired
    private BusRepository busRepository;

    @Override
    public Booking createBooking(BookingRequest bookingRequest) {
        Trip trip = tripRepository.findById(bookingRequest.getTrip().getId())
                .orElseThrow(() -> new RuntimeException("Trip not found with id " + bookingRequest.getTrip().getId()));
        User user = userRepository.findById(bookingRequest.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found with id " + bookingRequest.getUser().getId()));

        // Get all stops for the trip
        List<Stop> stops = stopRepository.findByTripIdOrderByStopOrderAsc(bookingRequest.getTrip().getId());

        // Find all buses that service this trip's stops
        List<Bus> buses = busRepository.findAll();

        // Filter seats based on seat number and availability
        Seat seat = null;
        for (Bus bus : buses) {
            Optional<Seat> foundSeat = seatRepository.findBySeatNumberAndBusId(String.valueOf(bookingRequest.getSeatNumber()), bus.getId());
            if (foundSeat.isPresent() && isSeatAvailableInAllSegments(trip, foundSeat.get(),trip.getStartCity().getId(), trip.getEndCity().getId())) {
                seat = foundSeat.get();
                break;
            }
        }

        if (seat == null) {
            throw new RuntimeException("Seat not found or already booked");
        }

        seat.setUser(user);
        seatRepository.save(seat);

        Booking booking = new Booking();
        booking.setTrip(trip);
        booking.setUser(user);
//        booking.setSeat(seat);

        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking findBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id " + id));
    }

    @Override
    public Booking updateBooking(BookingRequest bookingRequest, Long bookingId) {
        Booking booking= bookingRepository.findById(bookingId).orElseThrow(()->new RuntimeException("Booking not found with id " + bookingId));
        booking.setTrip(bookingRequest.getTrip());
        booking.setUser(bookingRequest.getUser());
        booking.setSeatNumber(bookingRequest.getSeatNumber());
        bookingRepository.save(booking);
        return booking;
    }

    @Override
    public boolean deleteBooking(Long bookingId) {
        Booking booking= bookingRepository.findById(bookingId).orElseThrow(()->new RuntimeException("Booking not found with id " + bookingId));
        if(booking!=null){
            bookingRepository.delete(booking);
            return true;
        }
        return false;
    }

    @Override
    public List<Seat> getAvailableSeats(Long startCityId, Long endCityId) {
        List<Trip> trips = tripRepository.findByStartCityIdAndEndCityId(startCityId, endCityId);
        List<Seat> availableSeats = new ArrayList<>();

        for (Trip trip : trips) {
            List<Seat> seats = seatRepository.findAvailableSeatsByTripId(trip.getId());
            for (Seat seat : seats) {
                if (isSeatAvailableInAllSegments(trip, seat, startCityId, endCityId)) {
                    availableSeats.add(seat);
                }
            }
        }

        return availableSeats;
    }

    private boolean isSeatAvailableInAllSegments(Trip trip,Seat seat, Long startCityId, Long endCityId) {
        List<Stop> stops = stopRepository.findByTripIdOrderByStopOrderAsc(trip.getId());
        int startOrder = stops.stream().filter(stop -> stop.getCity().getId().equals(startCityId)).findFirst().get().getStopOrder();
        int endOrder = stops.stream().filter(stop -> stop.getCity().getId().equals(endCityId)).findFirst().get().getStopOrder();

        for (int i = startOrder; i < endOrder; i++) {
            Stop currentStop = stops.get(i);
            Stop nextStop = stops.get(i + 1);
            if (seatRepository.isSeatBookedBetweenStops(seat.getId(), currentStop.getCity().getId(), nextStop.getCity().getId())) {
                return false;
            }
        }

        return true;
    }
}
