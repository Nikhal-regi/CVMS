package com.example.CVMS.entity.derived;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VehicleTripInfo {
    private Integer vehicleId;
    private String make;
    private String model;
    private Long totalTrips;
}
