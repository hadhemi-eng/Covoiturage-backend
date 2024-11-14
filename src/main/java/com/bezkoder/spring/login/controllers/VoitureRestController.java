package com.bezkoder.spring.login.controllers;


import com.bezkoder.spring.login.models.Voiture;
import com.bezkoder.spring.login.repository.ChauffeurRepository;
import com.bezkoder.spring.login.repository.MarqueVoitureRepository;
import com.bezkoder.spring.login.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/voitur")
public class VoitureRestController {



    @Autowired
    MarqueVoitureRepository marquevoiturerepository;


    @Autowired
    VoitureRepository voitureRepository;

@Autowired
ChauffeurRepository chauffeurRepository;

    @GetMapping("/all")
    public List<Voiture> allvoitur() {
        return voitureRepository.findAll();
    }




    @PostMapping("/add/{idC}/{idM}")
    public Voiture addvoitur(@RequestBody Voiture voiture, @PathVariable Long idC, @PathVariable Long idM ) {

        voiture.setChauffeur(chauffeurRepository.getById(idC));
        voiture.setMarqueVoiture(marquevoiturerepository.getById(idM));
            return this.voitureRepository.save(voiture);

    }




    @PutMapping("/edit/{id}/{idC}/{idM}")
    public Voiture editvoiture (@RequestBody Voiture voiture, @PathVariable Long id, @PathVariable Long idC , @PathVariable Long idM ) {




            voiture.setId(id);
        voiture.setChauffeur(chauffeurRepository.getById(idC));
        voiture.setMarqueVoiture(marquevoiturerepository.getById(idM));
            return voitureRepository.save(voiture);




    }



    @DeleteMapping("/delete/{id}")
    public HashMap deletevoiture(@PathVariable Long id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            voitureRepository.deleteById(id);
            hashMap.put("state", "yes");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "no");
            return hashMap;
        }


    }
    @GetMapping("/voiturcond/{idC}")
    public  List<Voiture> getvoiturconducteur (@PathVariable Long idC){
        return voitureRepository.findVoitureByChauffeur_id(idC);
    }





}






