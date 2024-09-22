package com.example.CVMS.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SensorDTO {
    private Integer sensorId;
    private Integer vehicleId;
    private String sensorType;
    private Double sensorReading;
    private LocalDateTime timestamp;

}
