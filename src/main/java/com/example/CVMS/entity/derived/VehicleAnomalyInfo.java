package com.example.CVMS.entity.derived;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VehicleAnomalyInfo {
    private String make;
    private String model;
    private int ownerId;
    private String anomalyType;
    private double reading;

}

