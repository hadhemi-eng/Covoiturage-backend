package com.bezkoder.spring.login.controllers;

import com.bezkoder.spring.login.repository.MarqueVoitureRepository;
import com.bezkoder.spring.login.repository.ModelVoitureRepository;
import com.bezkoder.spring.login.models.Modelvoiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/model")
public class ModelRestController {
    @Autowired
    ModelVoitureRepository modelVoitureRepository;
@Autowired
    MarqueVoitureRepository marqueVoitureRepository;

    @GetMapping("/all")
    public List<Modelvoiture> getall() {


        return (List<Modelvoiture>) modelVoitureRepository.findAll();

    }


    @PostMapping("/add/{idmarque}")
    public Modelvoiture addModelvoiture(@RequestBody Modelvoiture Modelvoiture, @PathVariable Long idmarque ) {

        Modelvoiture.setMarqueVoiture(marqueVoitureRepository.getById(idmarque));
        return this.modelVoitureRepository.save(Modelvoiture);

    }



    @PutMapping("/edit/{id}/{idMarque}")
    public Modelvoiture editModelvoiture  (@RequestBody Modelvoiture Modelvoiture, @PathVariable Long id, @PathVariable Long idMarque) {




        Modelvoiture.setId(id);
        Modelvoiture.setMarqueVoiture(marqueVoitureRepository.getById(idMarque));
        return modelVoitureRepository.save(Modelvoiture);




    }



    @GetMapping("/one/{id}")
    public Modelvoiture getOne(@PathVariable Long id){
        return modelVoitureRepository.getById(id);
    }
    @GetMapping("/modelbymarque/{nommarque}")
    public  List<Modelvoiture> getmodelbymarque (@PathVariable String nommarque) {
        return modelVoitureRepository.findModelvoitureByMarqueVoiture_Nom(nommarque);
    }
}
