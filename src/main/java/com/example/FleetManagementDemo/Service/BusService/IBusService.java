package com.example.FleetManagementDemo.Service.BusService;

import com.example.FleetManagementDemo.Entity.Bus;
import com.example.FleetManagementDemo.Helpers.BusHelper.BusRequest;

import java.util.List;

public interface IBusService {
    List<Bus> getAllBuses();

    Bus getBus(Long id);

    Bus addNewBus(BusRequest busRequest);

    Bus updateBus(BusRequest busRequest,Long id);

    boolean deleteBus(Long id);
}
