package com.example.CVMS.mapper;

import com.example.CVMS.dto.*;
import com.example.CVMS.entity.*;
import org.springframework.stereotype.Component;

@Component
public class CvmsMapper {
    public Vehicle toEntity(VehicleDTO dto) {
        if (dto == null) {
            return null;
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(dto.getVehicleId());
        vehicle.setMake(dto.getMake());
        vehicle.setModel(dto.getModel());
        vehicle.setYear(dto.getYear());
        vehicle.setFuelType(dto.getFuelType());



        return vehicle;
    }

    public VehicleDTO toDTO(Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        }

        VehicleDTO dto = new VehicleDTO();
        dto.setVehicleId(vehicle.getVehicleId());
        dto.setMake(vehicle.getMake());
        dto.setModel(vehicle.getModel());
        dto.setYear(vehicle.getYear());
        dto.setFuelType(vehicle.getFuelType());
        dto.setOwnerId(vehicle.getOwner().getOwnerId());

        return dto;
    }

    public Owner toEntity(OwnerDTO dto) {
        if (dto == null) {
            return null;
        }

        Owner owner = new Owner();
        owner.setOwnerId(dto.getOwnerId());
        owner.setName(dto.getName());
        owner.setContactInfo(dto.getContactInfo());

        return owner;
    }

    public OwnerDTO toDTO(Owner owner) {
        if (owner == null) {
            return null;
        }

        OwnerDTO dto = new OwnerDTO();
        dto.setOwnerId(owner.getOwnerId());
        dto.setName(owner.getName());
        dto.setContactInfo(owner.getContactInfo());

        return dto;
    }

    public Trip toEntity(TripDTO dto) {
        if (dto == null) {
            return null;
        }

        Trip trip = new Trip();
        trip.setTripId(dto.getTripId());
        trip.setStartTime(dto.getStartTime());
        trip.setEndTime(dto.getEndTime());
        trip.setStartLocation(dto.getStartLocation());
        trip.setEndLocation(dto.getEndLocation());
        trip.setDistanceTraveled(dto.getDistanceTraveled());

        return trip;
    }

    public TripDTO toDTO(Trip trip) {
        if (trip == null) {
            return null;
        }

        TripDTO dto = new TripDTO();
        dto.setTripId(trip.getTripId());
        dto.setVehicleId(trip.getVehicle().getVehicleId());
        dto.setStartTime(trip.getStartTime());
        dto.setEndTime(trip.getEndTime());
        dto.setStartLocation(trip.getStartLocation());
        dto.setEndLocation(trip.getEndLocation());
        dto.setDistanceTraveled(trip.getDistanceTraveled());

        return dto;
    }

    public Sensor toEntity(SensorDTO dto) {
        if (dto == null) {
            return null;
        }

        Sensor sensor = new Sensor();
        sensor.setSensorId(dto.getSensorId());
        sensor.setSensorType(dto.getSensorType());
        sensor.setSensorReading(dto.getSensorReading());
        sensor.setTimestamp(dto.getTimestamp());

        return sensor;
    }

    public SensorDTO toDTO(Sensor sensor) {
        if (sensor == null) {
            return null;
        }

        SensorDTO dto = new SensorDTO();
        dto.setSensorId(sensor.getSensorId());
        dto.setVehicleId(sensor.getVehicle().getVehicleId());
        dto.setSensorType(sensor.getSensorType());
        dto.setSensorReading(sensor.getSensorReading());
        dto.setTimestamp(sensor.getTimestamp());

        return dto;
    }

    public Maintenance toEntity(MaintenanceDTO dto) {
        if (dto == null) {
            return null;
        }

        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceId(dto.getMaintenanceId());
        maintenance.setMaintenanceType(dto.getMaintenanceType());
        maintenance.setYear(dto.getYear());
        maintenance.setMaintenanceDate(dto.getMaintenanceDate());
        maintenance.setMaintenanceCost(dto.getMaintenanceCost());

        return maintenance;
    }

    public static MaintenanceDTO toDTO(Maintenance maintenance) {
        if (maintenance == null) {
            return null;
        }

        MaintenanceDTO dto = new MaintenanceDTO();
        dto.setMaintenanceId(maintenance.getMaintenanceId());
        dto.setVehicleId(maintenance.getVehicle().getVehicleId());
        dto.setMaintenanceType(maintenance.getMaintenanceType());
        dto.setYear(maintenance.getYear());
        dto.setMaintenanceDate(maintenance.getMaintenanceDate());
        dto.setMaintenanceCost(maintenance.getMaintenanceCost());

        return dto;
    }
}
