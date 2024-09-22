package com.example.CVMS.service;

import com.example.CVMS.dto.MaintenanceDTO;
import com.example.CVMS.entity.Maintenance;
import com.example.CVMS.entity.derived.VehicleAnomalyInfo;
import com.example.CVMS.entity.derived.VehicleDistanceInfo;
import com.example.CVMS.entity.derived.VehicleTripInfo;

import java.util.List;

public interface CmvsService {
    List<VehicleDistanceInfo> calculateTotalDistanceLast30Days();
    List<VehicleAnomalyInfo> findVehiclesWithAnomalies();
    List<MaintenanceDTO> getMaintenanceHistoryByVehicleId(Integer vehicleId);
    List<VehicleTripInfo> findVehiclesWithMoreThanFiveTrips();
    Double getTotalDistanceByVehicleId(Integer vehicleId);
    String getVehicleNameByVehicleId(Integer vechicleId);
}
