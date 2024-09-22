package com.example.CVMS.dto;

import com.example.CVMS.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceDTO {
    private Integer maintenanceId;
    private Integer vehicleId;
    private String maintenanceType;
    private Integer year;
    private LocalDateTime maintenanceDate;
    private Double maintenanceCost;
}
