package com.example.CVMS.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    private Integer vehicleId;
    private String make;
    private String model;
    private Integer year;
    private String fuelType;
    private Integer ownerId;
}
