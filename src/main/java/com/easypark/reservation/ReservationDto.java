package com.easypark.reservation;

import com.easypark.parking.Parking;
import com.easypark.vehicle.Vehicle;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReservationDto {
    private Long id;
    private LocalDateTime entryDate;
    private LocalDateTime departureDate;
    private BigDecimal value;
    private String status;
    private Parking parking;
    private Vehicle vehicle;
}
