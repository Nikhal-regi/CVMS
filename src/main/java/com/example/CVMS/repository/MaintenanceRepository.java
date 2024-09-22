package com.example.CVMS.repository;

import com.example.CVMS.entity.Maintenance;
import com.example.CVMS.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
    List<Maintenance> findByVehicle(Vehicle vehicle);
}
