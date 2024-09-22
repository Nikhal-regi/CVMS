package com.example.CVMS.entity.derived;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VehicleDistanceInfo {
    private String make;
    private String model;
    private String ownerName;
    private double totalDistance;

}
