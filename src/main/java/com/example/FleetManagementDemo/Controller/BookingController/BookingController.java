package com.example.FleetManagementDemo.Controller.BookingController;

import com.example.FleetManagementDemo.Entity.Booking;
import com.example.FleetManagementDemo.Helpers.BookingHelper.BookingRequest;
import com.example.FleetManagementDemo.Helpers.BookingHelper.BookingResponse;
import com.example.FleetManagementDemo.Service.BookingService.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Bookings")
public class BookingController {

    @Autowired
    private IBookingService bookingService;
    @GetMapping
    public ResponseEntity<BookingResponse> fetchAllBookings(){
        List<Booking> bookings = bookingService.findAllBookings();
        if(bookings==null){
            return ResponseEntity.notFound().build();
        }
        BookingResponse bookingResponse  = new BookingResponse(bookings);
        return ResponseEntity.ok(bookingResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Booking> fetchBooking(@PathVariable("id") Long id){
        if(id==null){
            return ResponseEntity.badRequest().build();
        }
        Booking booking = bookingService.findBookingById(id);
        if(booking ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(booking);
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody BookingRequest bookingRequest){
        if(bookingRequest==null){
            return ResponseEntity.badRequest().build();
        }
        Booking booking = bookingService.createBooking(bookingRequest);
        if(booking!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(booking);
        }
        return  ResponseEntity.internalServerError().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable("id") Long id,@RequestBody BookingRequest bookingRequest){
        if(bookingRequest==null||id ==null){
            return ResponseEntity.badRequest().build();
        }
        Booking booking = bookingService.updateBooking(bookingRequest,id);
        if(booking!=null){
            return ResponseEntity.status(HttpStatus.OK).body(booking);
        }
        return  ResponseEntity.internalServerError().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable("id") Long id){
        if(id ==null){
            return ResponseEntity.badRequest().build();
        }
        boolean isDeleted= bookingService.deleteBooking(id);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body("Booking Deleted Successfully");
        }
        return ResponseEntity.internalServerError().build();
    }
}
