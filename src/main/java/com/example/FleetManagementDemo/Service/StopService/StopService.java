package com.example.FleetManagementDemo.Service.StopService;

import com.example.FleetManagementDemo.Entity.Stop;
import com.example.FleetManagementDemo.Helpers.StopHelper.StopRequest;
import com.example.FleetManagementDemo.Repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopService implements IStopService{
    @Autowired
    private StopRepository stopRepository;


    @Override
    public Stop createStop(StopRequest stopRequest) {
        Stop stop = new Stop();
        stop.setCity(stopRequest.getCity());
        stop.setTrip(stopRequest.getTrip());
        stop.setStopOrder(stopRequest.getStopOrder());
        stopRepository.save(stop);
        return stop;
    }

    @Override
    public List<Stop> getAllStops() {
        return stopRepository.findAll();
    }

    @Override
    public Stop getStop(Long id) {
        return stopRepository.findById(id).orElseThrow(() -> new RuntimeException("Stop not found with id: "+id));
    }

    @Override
    public Stop updateStop(StopRequest stopRequest, Long id) {
        Stop stop=stopRepository.findById(id).orElseThrow(() -> new RuntimeException("Stop not found with id: "+id));
        stop.setCity(stopRequest.getCity());
        stop.setTrip(stopRequest.getTrip());
        stop.setStopOrder(stopRequest.getStopOrder());
        stopRepository.save(stop);
        return stop;
    }

    @Override
    public boolean deleteStop(Long id) {
        Stop deletedStop=stopRepository.findById(id).orElseThrow(() -> new RuntimeException("Stop not found with id: "+id));
        if(deletedStop!=null){
            stopRepository.delete(deletedStop);
            return true;
        }
        return false;
    }
}
