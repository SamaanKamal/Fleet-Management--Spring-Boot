package com.example.FleetManagementDemo.Service.BusService;

import com.example.FleetManagementDemo.Entity.Bus;
import com.example.FleetManagementDemo.Entity.City;
import com.example.FleetManagementDemo.Helpers.BusHelper.BusRequest;
import com.example.FleetManagementDemo.Repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService implements IBusService{

    @Autowired
    private BusRepository busRepository;
    @Override
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    @Override
    public Bus getBus(Long id) {
        return busRepository.findById(id).orElseThrow(()-> new RuntimeException("Bus not found with id:"  + id));
    }

    @Override
    public Bus addNewBus(BusRequest busRequest) {
        Bus bus = new Bus();
        bus.setRegistrationNumber(busRequest.getRegistrationNumber());
        bus.setCapacity(busRequest.getCapacity());
        return busRepository.save(bus);
    }

    @Override
    public Bus updateBus(BusRequest busRequest, Long id) {
        Bus bus =busRepository.findById(id).orElseThrow(()-> new RuntimeException("Bus not found with id:"  + id));
        bus.setRegistrationNumber(busRequest.getRegistrationNumber());
        bus.setCapacity(busRequest.getCapacity());
        busRepository.save(bus);
        return bus;
    }

    @Override
    public boolean deleteBus(Long id) {
        Bus deletedBus =busRepository.findById(id).orElseThrow(()-> new RuntimeException("Bus not found with id:"  + id));
        if(deletedBus!=null){
            busRepository.delete(deletedBus);
            return true;
        }
        return false;
    }
}
