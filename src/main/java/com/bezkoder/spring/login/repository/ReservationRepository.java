package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {



    List<Reservation> findReservationByPasseger_Id(Long id);

    List<Reservation> findReservationByAnnonce_Id(Long id);
    List<Reservation> findReservationByAnnonce_Chauffeur_Id(Long id);

}
