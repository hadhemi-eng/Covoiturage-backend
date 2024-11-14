package com.bezkoder.spring.login.controllers;


import com.bezkoder.spring.login.models.Annonce;
import com.bezkoder.spring.login.models.Reservation;
import com.bezkoder.spring.login.repository.AnnonceRepository;
import com.bezkoder.spring.login.repository.ChauffeurRepository;
import com.bezkoder.spring.login.repository.PassegerRepository;
import com.bezkoder.spring.login.repository.ReservationRepository;
import com.bezkoder.spring.login.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/res")

public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ChauffeurRepository chauffeurRepository;
    @Autowired
    private AnnonceRepository annonceRepository;
    @Autowired
    private PassegerRepository passegerRepository;
    @Autowired
    private ReservationRepository reservationRepository;


    @GetMapping("/reservations")
    public List getAllReservations() {

        return reservationService.getAllReservations();
    }

    @GetMapping("/validerreservation/{id}")
    public Reservation validerReservation(@PathVariable Long id) {
        Reservation reservation = reservationRepository.getById(id);


        reservation.setEtat("accepter");
        reservation.setDatevu(new Date());
        Annonce a = reservation.getAnnonce();
        if(a.getNbrplacesdisponible().intValue() >= reservation.getNbplaces().intValue()){

        a.setNbrplacesdisponible(a.getNbrplacesdisponible().intValue() - reservation.getNbplaces().intValue());
        annonceRepository.saveAndFlush(a);}
        return reservationRepository.save(reservation);
    }
    @GetMapping("/refusereservation/{id}")
    public Reservation refuseReservation(@PathVariable Long id) {
        Reservation reservation = reservationRepository.getById(id);

        reservation.setEtat("refuser");
        reservation.setDatevu(new Date());
        return reservationRepository.save(reservation);
    }
    @GetMapping("/annullerreservation/{id}")
    public Reservation annullerreservation(@PathVariable Long id) {
        Reservation reservation = reservationRepository.getById(id);

        reservation.setEtat("annuler");
        reservation.setDatevu(new Date());
        return reservationRepository.save(reservation);
    }


    @GetMapping("/resrvationpassager/{idP}")
    public List<Reservation> getReservationbyidpassager(@PathVariable Long idP) {


        return reservationRepository.findReservationByPasseger_Id(idP);


    }

    @GetMapping("/resrvationaccepter/{idP}")
    public List<Reservation> getReservationaccepterbyidpassager(@PathVariable Long idP) {

        List<Reservation> reservations = new ArrayList<>();
        for (Reservation reservation : reservationRepository.findReservationByPasseger_Id(idP)) {
            if (reservation.getEtat().equals("accepter")) {
                reservations.add(reservation);
            }
        }
        return reservations;

    }

    @GetMapping("/reservationrefuser/{idP}")
    public List<Reservation> Resrefuserbyidpass(@PathVariable Long idP) {

        List<Reservation> reservations = new ArrayList<>();
        for (Reservation reservation : reservationRepository.findReservationByPasseger_Id(idP)) {
            if (reservation.getEtat().equals("refuser")) {
                reservations.add(reservation);
            }
        }
        return reservations;

    }

    @GetMapping("/reservationenattendpassger/{idpassager}")
    public List<Reservation> getReservatiionattend(@PathVariable Long idpassager) {

        List<Reservation> reservations = new ArrayList<>();
        for (Reservation reservation : reservationRepository.findReservationByPasseger_Id(idpassager)) {
            if (reservation.getEtat().equals("enattend")) {
                reservations.add(reservation);
            }

        }
        return reservations;
    }

    @GetMapping("/reservationenattend/{idconducteur}")
    public List<Reservation> getReservationrejeter(@PathVariable Long idconducteur) {

        List<Reservation> reservations = new ArrayList<>();
        for (Reservation reservation : reservationRepository.findAll()) {
            if (reservation.getEtat().equals("enattend") && reservation.getAnnonce().getChauffeur().getId().equals(idconducteur)) {
                reservations.add(reservation);
            }
        }

        return reservations;
    }


    @GetMapping("/reservations/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationService.getReservation(id);
    }

//        @PostMapping("/addreservation/{idPas}/{idC}")
//        public Reservation addReservation(@RequestBody Reservation reservation, @PathVariable String idPas,@PathVariable String idC ) {
//
//            reservation.setAnnonce(annonceRepository.find_id(idC));
//            reservation.setPasseger(passegerRepository.find_id(idPas));
//              reservation.setEtat(false);
//
//            return reservationRepository.save(reservation);
//
//    }

    @PostMapping("/limitreservation/{idPas}/{idC}")
    public Reservation ajoutReservation(@RequestBody Reservation reservation, @PathVariable Long idPas, @PathVariable Long idC) {
        reservation.setAnnonce(annonceRepository.getById(idC));
        reservation.setPasseger(passegerRepository.getById(idPas));

        reservation.setEtat("enattend");
        reservation.setValide(true);
        int place = 0;
        for (Reservation res : reservationRepository.findReservationByAnnonce_Id(idC)) {
            place += res.getNbplaces().intValue();
            if (res.getAnnonce().getNbrplacesdisponible().intValue() > place) {
                System.out.println(place);


            } else {

                System.out.println("annonce plein");
                reservation.setValide(false);

            }
        }


        return reservationRepository.save(reservation);
    }


    @GetMapping("/allnonvalid")
    public List<Reservation> gettalnonvalide() {
        List<Reservation> reservationList = new ArrayList<>();
        for (Reservation reservation : reservationRepository.findAll())
            if (!reservation.getValide())
                reservationList.add(reservation);
        return reservationList;
    }

    @DeleteMapping("supp")
    public HashMap suppnonvalid() {
        HashMap<String, String> hashMap = new HashMap<>();

        try {
            List<Reservation> reservations = gettalnonvalide();
            for (int i = 0; i < reservations.size(); i++)

                reservationRepository.deleteById(reservations.get(i).getId());
            hashMap.put("state", "yes");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "no");
            return hashMap;
        }
    }

    @DeleteMapping("/deleteresrvation/{id}")
    public HashMap deletereservation(@PathVariable Long id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            reservationRepository.deleteById(id);
            hashMap.put("state", "yes");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "no");
            return hashMap;
        }


    }

    @GetMapping("/historique/{idP}")
    public List<Reservation> gethistoriquepassager(@PathVariable Long idP) {


        return reservationRepository.findReservationByPasseger_Id(idP);
    }

    @GetMapping("/historiquec/{idc}")
    public List<Reservation> gethistoriqueconducteur(@PathVariable Long idc) {


        return reservationRepository.findReservationByAnnonce_Chauffeur_Id(idc);
    }


}
