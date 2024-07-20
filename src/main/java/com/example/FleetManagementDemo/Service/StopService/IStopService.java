package com.example.FleetManagementDemo.Service.StopService;

import com.example.FleetManagementDemo.Entity.Stop;
import com.example.FleetManagementDemo.Helpers.StopHelper.StopRequest;

import java.util.List;

public interface IStopService {
    Stop createStop(StopRequest stopRequest);

    List<Stop> getAllStops();

    Stop getStop(Long id);

    Stop updateStop(StopRequest stopRequest, Long id);

    boolean deleteStop(Long id);
}
