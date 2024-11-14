package com.bezkoder.spring.login.service;


import com.bezkoder.spring.login.models.Reservation;
import com.bezkoder.spring.login.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository ;
    public List getAllReservations() {

        List reservations = new ArrayList<>();
        reservationRepository.findAll().forEach(reservations::add);

        return reservations;
    }

    public Reservation getReservation(Long id) {
        return reservationRepository.getById(id);

    }

    public void addReservation(Reservation reservation) {
           reservationRepository.save(reservation);
    }
}
