package com.example.FleetManagementDemo.Controller.BusController;

import com.example.FleetManagementDemo.Entity.Bus;
import com.example.FleetManagementDemo.Helpers.BusHelper.BusRequest;
import com.example.FleetManagementDemo.Helpers.BusHelper.BusResponse;
import com.example.FleetManagementDemo.Service.BusService.IBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Buses")
public class BusController {

    @Autowired
    private IBusService busService;

    @GetMapping
    public ResponseEntity<BusResponse> fetchAllBuses(){
        List<Bus> buses = busService.getAllBuses();
        if(buses==null){
            return ResponseEntity.notFound().build();
        }
        BusResponse busResponse = new BusResponse(buses);
        return ResponseEntity.ok(busResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Bus> fetchBus(@PathVariable("id") Long id){
        if(id==null){
            return ResponseEntity.badRequest().build();
        }
        Bus bus = busService.getBus(id);
        if(bus ==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bus);
    }

    @PostMapping
    public ResponseEntity<Bus> createBus(@RequestBody BusRequest busRequest){
        if(busRequest==null){
            return ResponseEntity.badRequest().build();
        }
        Bus bus = busService.addNewBus(busRequest);
        if(bus!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body(bus);
        }
        return  ResponseEntity.internalServerError().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Bus> updateBus(@PathVariable("id") Long id,@RequestBody BusRequest busRequest){
        if(busRequest==null||id ==null){
            return ResponseEntity.badRequest().build();
        }
        Bus bus = busService.updateBus(busRequest,id);
        if(bus!=null){
            return ResponseEntity.status(HttpStatus.OK).body(bus);
        }
        return  ResponseEntity.internalServerError().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBus(@PathVariable("id") Long id){
        if(id ==null){
            return ResponseEntity.badRequest().build();
        }
        boolean isDeleted= busService.deleteBus(id);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body("Bus Deleted Successfully");
        }
        return ResponseEntity.internalServerError().build();
    }

}
