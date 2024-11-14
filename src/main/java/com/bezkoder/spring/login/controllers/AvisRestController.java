package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.models.Avis;
import com.bezkoder.spring.login.models.Chauffeur;
import com.bezkoder.spring.login.repository.AvisRepository;
import com.bezkoder.spring.login.repository.ChauffeurRepository;
import com.bezkoder.spring.login.repository.PassegerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/avis")
public class AvisRestController {
    @Autowired
    AvisRepository avisRepository;
    @Autowired
    ChauffeurRepository chauffeurRepository;
    @Autowired
    PassegerRepository passegerRepository;

    @GetMapping("/all")
    public List<Avis> allavis() {
        return avisRepository.findAll();
    }

    @PostMapping("/add/{idC}/{idP}")
    public Avis addavis(@RequestBody Avis avis, @PathVariable Long idC, @PathVariable Long idP) {

        avis.setChauffeur(chauffeurRepository.getById(idC));
        avis.setPasseger(passegerRepository.getById(idP));
        return this.avisRepository.save(avis);

    }

    @PostMapping("/addavis/{idC}")
    public Avis addavis(@PathVariable Long idC, @RequestBody Avis avis) {

        Chauffeur chauffeur = chauffeurRepository.getById(idC);

        chauffeur.setId(idC);
        avis.setChauffeur(chauffeur);

        if (chauffeur.getNote() == 0) {
            chauffeur.setNote(avis.getRaiting());
        }
        chauffeurRepository.save(chauffeur);

        return avisRepository.save(avis);
    }

    @PutMapping("/edit/{id}/{idC}/{idP}")
    public Avis editavis(@RequestBody Avis avis, @PathVariable Long id, @PathVariable Long idC, @PathVariable Long idP) {


        avis.setId(id);
        avis.setChauffeur(chauffeurRepository.getById(idC));
        avis.setPasseger(passegerRepository.getById(idP));

        return avisRepository.save(avis);


    }

    @DeleteMapping("/delete/{id}")
    public HashMap deleteavis(@PathVariable Long id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            avisRepository.deleteById(id);
            hashMap.put("state", "yes");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "no");
            return hashMap;
        }


    }

    @GetMapping("/avisconducteur/{idC}")
    public List<Avis> getAvisconducteur(@PathVariable Long idC) {
        return avisRepository.findAvisByChauffeur_Id(idC);
    }


}
