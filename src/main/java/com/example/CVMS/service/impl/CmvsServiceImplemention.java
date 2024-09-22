package com.example.CVMS.service.impl;

import com.example.CVMS.dto.MaintenanceDTO;
import com.example.CVMS.entity.Maintenance;
import com.example.CVMS.entity.Sensor;
import com.example.CVMS.entity.Vehicle;
import com.example.CVMS.entity.derived.VehicleAnomalyInfo;
import com.example.CVMS.entity.derived.VehicleDistanceInfo;
import com.example.CVMS.entity.derived.VehicleTripInfo;
import com.example.CVMS.mapper.CvmsMapper;
import com.example.CVMS.repository.MaintenanceRepository;
import com.example.CVMS.repository.TripRepository;
import com.example.CVMS.repository.VehicleRepository;
import com.example.CVMS.repository.SensorRepository;
import com.example.CVMS.service.CmvsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CmvsServiceImplemention implements CmvsService {
    @Autowired
    private SensorRepository sensorRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private MaintenanceRepository maintenanceRepository;



    @Override
    public List<VehicleDistanceInfo> calculateTotalDistanceLast30Days() {
        LocalDateTime thirtyDaysAgo = LocalDateTime.now().minusDays(30);
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream().map(vehicle -> {
            Double totalDistance = tripRepository.findByVehicleIdAndStartTimeAfter(vehicle.getVehicleId(), thirtyDaysAgo);
            //Double and double are different data type Double can accept null but double cant
            if (totalDistance == null) {
                totalDistance = 0.0;
            }
            String ownerName = vehicle.getOwner().getName();

            return new VehicleDistanceInfo(
                    vehicle.getMake(),
                    vehicle.getModel(),
                    ownerName,
                    totalDistance
            );
        }).collect(Collectors.toList());
    }
    @Override
    public Double getTotalDistanceByVehicleId(Integer vehicleId) {
        return tripRepository.calculateTotalDistanceByVehicleId(vehicleId);
    }

    @Override
    public String getVehicleNameByVehicleId(Integer vechicleId) {
        Vehicle vehicle = vehicleRepository.findById(vechicleId).orElseThrow(() -> new RuntimeException("Error: id not found!!" + vechicleId));
        return vehicle.getMake() + " " + vehicle.getModel();
    }

    @Override
    public List<VehicleAnomalyInfo> findVehiclesWithAnomalies() {
        List<Sensor> sensors = sensorRepository.findAll();

        return sensors.stream()
                .filter(sensor ->
                        (sensor.getSensorType().equals("Speed") && sensor.getSensorReading() > 120) ||
                                (sensor.getSensorType().equals("Fuel Level") && sensor.getSensorReading() < 10))
                .map(sensor -> {
                    Vehicle vehicle = vehicleRepository.findById(sensor.getVehicle().getVehicleId()).orElseThrow(() -> new RuntimeException("Error: id not found!!" + sensor.getVehicle().getVehicleId()));
                    return new VehicleAnomalyInfo(vehicle.getMake(), vehicle.getModel(), vehicle.getOwner().getOwnerId(), sensor.getSensorType(), sensor.getSensorReading());
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<MaintenanceDTO> getMaintenanceHistoryByVehicleId(Integer vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));
        List<Maintenance> maintenance  = maintenanceRepository.findByVehicle(vehicle);
        return maintenance.stream().map(CvmsMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<VehicleTripInfo> findVehiclesWithMoreThanFiveTrips() {
        LocalDateTime startDate = LocalDateTime.now().minusDays(7);
        List<Object[]> results = tripRepository.findVehiclesWithMoreThanFiveTrips(startDate);

        List<VehicleTripInfo> vehicleTripInfos = new ArrayList<>();
        for (Object[] result : results) {
            Integer vehicleId = (Integer) result[0];
            Long tripCount = (Long) result[1];

            vehicleRepository.findById(vehicleId).ifPresent(vehicle -> vehicleTripInfos.add(new VehicleTripInfo(vehicleId, vehicle.getMake(), vehicle.getModel(), tripCount)));
        }
        return vehicleTripInfos;
    }
}


/*
            double totalDistance = trips.stream().mapToDouble(Trip::getDistanceTraveled).sum();
            List<Trip> trips = tripRepository.findByVehicleIdAndStartTimeAfter(vehicle.getVehicleId(), thirtyDaysAgo);
*/
