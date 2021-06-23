package com.easypark.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> findReservations(Long id) {

        return reservationRepository.findByParkingId(id);
    }

    public Reservation create(Reservation reservation) {

        Reservation rv = reservationRepository.save(reservation);


        return reservationRepository.findById(rv.getId()).get();
    }
}
