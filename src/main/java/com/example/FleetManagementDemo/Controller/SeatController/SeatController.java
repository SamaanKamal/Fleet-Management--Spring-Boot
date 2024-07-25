package com.example.FleetManagementDemo.Controller.SeatController;

import com.example.FleetManagementDemo.Entity.Seat;
import com.example.FleetManagementDemo.Entity.Trip;
import com.example.FleetManagementDemo.Helpers.SeatHelper.SeatResponse;
import com.example.FleetManagementDemo.Service.SeatService.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Seats")
public class SeatController {

    @Autowired
    private ISeatService seatService;
    @GetMapping("/byBus/{id}")
    public ResponseEntity<SeatResponse> fetchAllAvailableSeats(@PathVariable("id")Long id){
        List<Seat> seats = seatService.getAvailableSeatsByBusId(id);
        if(seats==null){
            return ResponseEntity.notFound().build();
        }
        SeatResponse seatResponse  = new SeatResponse(seats);
        return ResponseEntity.ok(seatResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Seat> fetchSeat(@PathVariable("id") Long id){
        if(id==null){
            return ResponseEntity.badRequest().build();
        }
        Seat seat = seatService.getSeatById(id);
        if(seat ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seat);
    }


}
