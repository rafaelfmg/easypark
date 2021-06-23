package com.easypark.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/parking-lots")
public class ParkingController {

    @Autowired
    private ParkingService service;

    @GetMapping
    List<Parking> findAll(@RequestParam(required = false) String text) {

        return service.findParks(text);
    }

    @PutMapping("/{id}")
    void evaluateParking(@PathVariable Long id, @RequestBody BigDecimal score) {
        service.evaluate(id, score);
    }

}
