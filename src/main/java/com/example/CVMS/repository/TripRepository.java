package com.example.CVMS.repository;

import com.example.CVMS.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Integer> {
    @Query("SELECT SUM(t.distanceTraveled) FROM Trip t WHERE t.vehicle.vehicleId = :vehicleId AND t.startTime >= :startTime")
    Double findByVehicleIdAndStartTimeAfter(@Param("vehicleId") int vehicleId, @Param("startTime") LocalDateTime startTime);

    @Query("SELECT t.vehicle.vehicleId, COUNT(t) FROM Trip t WHERE t.startTime >= :startDate GROUP BY t.vehicle.vehicleId HAVING COUNT(t) > 5")
    List<Object[]> findVehiclesWithMoreThanFiveTrips(@Param("startDate") LocalDateTime startDate);

    @Query("SELECT SUM(t.distanceTraveled) FROM Trip t WHERE t.vehicle.vehicleId = :vehicleId")
    Double calculateTotalDistanceByVehicleId(@Param("vehicleId") int vehicleId);

}
