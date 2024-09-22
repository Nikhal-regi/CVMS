package com.example.CVMS.controller;

import com.example.CVMS.dto.MaintenanceDTO;
import com.example.CVMS.entity.Maintenance;
import com.example.CVMS.entity.derived.VehicleAnomalyInfo;
import com.example.CVMS.entity.derived.VehicleDistanceInfo;
import com.example.CVMS.entity.derived.VehicleTripInfo;
import com.example.CVMS.service.CmvsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class CmvsController{

    @Autowired
    private CmvsService _service;

    @GetMapping("/distances")
    public ResponseEntity<List<VehicleDistanceInfo>> getTotalDistanceLast30Days() {
        List<VehicleDistanceInfo> distanceInfo = _service.calculateTotalDistanceLast30Days();
        return ResponseEntity.ok(distanceInfo);
    }

    @GetMapping("/distance")
    public ResponseEntity<String> getTotalDistanceByVehicleId(@RequestParam("vehicle_id") Integer vehicleId) {
        Double totalDistance = _service.getTotalDistanceByVehicleId(vehicleId);
        String Name = _service.getVehicleNameByVehicleId(vehicleId);
        return ResponseEntity.ok("The Total Distance covered by "+ Name +" is: "+totalDistance);
    }


    @GetMapping("/sensor_anomalies")
    public List<VehicleAnomalyInfo> getAnomalies() {
        return _service.findVehiclesWithAnomalies();
    }


    @GetMapping("/{vehicleId}/maintenance_history")
    public List<MaintenanceDTO> getMaintenanceHistory(@PathVariable Integer vehicleId) {
        return _service.getMaintenanceHistoryByVehicleId(vehicleId);
    }

    @GetMapping("/frequent_trips")
    public ResponseEntity<List<VehicleTripInfo>> getVehiclesWithMoreThanFiveTrips() {
        List<VehicleTripInfo> vehicleTripInfos = _service.findVehiclesWithMoreThanFiveTrips();
        return ResponseEntity.ok(vehicleTripInfos);
    }
}