package com.bezkoder.spring.login.controllers;


import com.bezkoder.spring.login.models.MarqueVoiture;
import com.bezkoder.spring.login.repository.MarqueVoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/marque")
public class MarquevoitureRestController {

    @Autowired
    MarqueVoitureRepository marqueVoitureRepository;





    @GetMapping("/all")
    public List<MarqueVoiture> getall() {


        return (List<MarqueVoiture>) marqueVoitureRepository.findAll();

    }


    @PostMapping("/add")
    public MarqueVoiture register(@RequestBody MarqueVoiture MarqueVoiture) {

        return this.marqueVoitureRepository.save(MarqueVoiture);

    }



    @PutMapping("/edit/{id}")
    public MarqueVoiture editMarquevoiture  (@RequestBody MarqueVoiture marqueVoiture, @PathVariable Long id) {

                  marqueVoiture.setId(id);

        return marqueVoitureRepository.save(marqueVoiture);

    }


    @DeleteMapping("/delete/{id}")
    public HashMap deleteMarque(@PathVariable Long id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            marqueVoitureRepository.deleteById(id);
            hashMap.put("state", "yes");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "no");
            return hashMap;
        }
    }
        @GetMapping("/one/{id}")
        public MarqueVoiture getOne(@PathVariable Long id){
            return marqueVoitureRepository.getById(id);
        }
    }











