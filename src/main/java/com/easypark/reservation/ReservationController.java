package com.easypark.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/reservations")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @GetMapping("/{parkingId}")
    List<Reservation> findAll(@PathVariable Long parkingId) {
        return service.findReservations(parkingId);
    }

    @PostMapping
    void create(@RequestBody Reservation reservation) {
         service.create(reservation);
    }
}
