package com.easypark.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@Transactional
public class ParkingService {

    @Autowired
    public ParkingRepository repository;

    public List<Parking> findParks(String textFilter) {
        return repository.findAll();
    }

    public void evaluate(Long id, BigDecimal score) {
        Parking parking = repository.findById(id).get();
        score = score.add(parking.getScore().multiply(BigDecimal.valueOf(parking.getReview())));
        parking.setReview(parking.getReview() + 1);
        parking.setScore(score.divide(BigDecimal.valueOf(parking.getReview()), 2, RoundingMode.HALF_EVEN));
        repository.save(parking);

    }
}
