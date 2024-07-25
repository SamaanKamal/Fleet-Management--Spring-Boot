package com.example.FleetManagementDemo.Controller.StopController;

import com.example.FleetManagementDemo.Entity.Stop;
import com.example.FleetManagementDemo.Entity.Trip;
import com.example.FleetManagementDemo.Helpers.StopHelper.StopRequest;
import com.example.FleetManagementDemo.Helpers.StopHelper.StopResponse;
import com.example.FleetManagementDemo.Helpers.TripHelper.TripRequest;
import com.example.FleetManagementDemo.Service.StopService.IStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Stops")
public class StopController {
    @Autowired
    private IStopService stopService;

    @GetMapping
    public ResponseEntity<StopResponse> fetchStops(){
        List<Stop> stops= stopService.getAllStops();
        if(stops==null){
            return ResponseEntity.notFound().build();
        }
        StopResponse stopResponse =new StopResponse(stops);
        return ResponseEntity.ok(stopResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Stop> fetchStop(@PathVariable("id") Long id){
        if(id==null){
            return ResponseEntity.badRequest().build();
        }
        Stop stop= stopService.getStop(id);
        if(stop==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(stop);
    }

    @PostMapping
    public ResponseEntity<Stop> createStop(@RequestBody StopRequest stopRequest){
        if(stopRequest==null){
            return ResponseEntity.badRequest().build();
        }
        Stop stop=stopService.createStop(stopRequest);
        if(stop!=null){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.internalServerError().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stop> updateStop(@PathVariable("id") Long id,@RequestBody StopRequest stopRequest){
        if(stopRequest==null||id ==null){
            return ResponseEntity.badRequest().build();
        }
        Stop stop = stopService.updateStop(stopRequest,id);
        if(stop!=null){
            return ResponseEntity.status(HttpStatus.OK).body(stop);
        }
        return  ResponseEntity.internalServerError().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStop(@PathVariable("id") Long id){
        if(id ==null){
            return ResponseEntity.badRequest().build();
        }
        boolean isDeleted= stopService.deleteStop(id);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body("Stop Deleted Successfully");
        }
        return ResponseEntity.internalServerError().build();
    }
}
