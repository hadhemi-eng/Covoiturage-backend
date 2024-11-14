package com.bezkoder.spring.login.controllers;


import com.bezkoder.spring.login.models.Annonce;
import com.bezkoder.spring.login.models.Reservation;
import com.bezkoder.spring.login.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/annonce")
public class AnnonceRestController {


    @Autowired
    AnnonceRepository annonceRepository;
    @Autowired
    PassegerRepository passegerRepository;
    @Autowired
    VoitureRepository voitureRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    ChauffeurRepository chauffeurRepository;

    @GetMapping("/all")
    public List<Annonce> allannonce() {
        return annonceRepository.findAll();
    }


    @PostMapping("/add/{idC}/{idV}")
    public Annonce addannonce(@RequestBody Annonce annonce, @PathVariable Long idC, @PathVariable Long idV) {

        annonce.setChauffeur(chauffeurRepository.getById(idC));
        annonce.setVoiture(voitureRepository.getById(idV));
        annonce.setCanModify(true);
        return this.annonceRepository.save(annonce);

    }


    @PutMapping("/edit/{id}/{idC}/{idV}")
    public Annonce editannonce(@RequestBody Annonce annonce, @PathVariable Long id, @PathVariable Long idC, @PathVariable Long idV) {
        Annonce annonce1 = annonceRepository.getById(id);

        if (reservationRepository.findReservationByAnnonce_Id(id).size() == 0) {
            annonce.setCanModify(true);
            annonce.setChauffeur(chauffeurRepository.getById(idC));
            annonce.setVoiture(voitureRepository.getById(idV));
            annonce.setId(id);


            return annonceRepository.save(annonce);
        } else {
            annonce1.setCanModify(false);
            System.out.println("you can not edit");
            return annonceRepository.save(annonce1);
        }

    }

    @GetMapping("/one/{id}")
    public Annonce getOne(@PathVariable Long id) {
        return annonceRepository.getById(id);
    }
//    @DeleteMapping("/delete/{id}")
//    public Chauffeur deletechauffeur(@PathVariable String id){ chauffeurRepository.deleteById(id);
//    return null;}

    @DeleteMapping("/delete/{id}")
    public HashMap deleteannonce(@PathVariable Long id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {

            for (Reservation r:reservationRepository.findReservationByAnnonce_Id(id)){
                reservationRepository.deleteById(r.getId());
            }
            annonceRepository.deleteById(id);
            hashMap.put("state", "yes");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "no");
            return hashMap;
        }


    }


    @GetMapping("/get/historique/{idC}")
    public List<Annonce> gethistorique(Long idC) {
        return annonceRepository.findAnnonceByChauffeur_Id(idC);
    }
}









