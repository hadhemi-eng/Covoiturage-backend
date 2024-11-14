package com.bezkoder.spring.login.controllers;


import com.bezkoder.spring.login.models.*;
import com.bezkoder.spring.login.repository.ChauffeurRepository;
import com.bezkoder.spring.login.repository.PassegerRepository;
import com.bezkoder.spring.login.repository.ReclamationRepository;
import com.bezkoder.spring.login.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/reclamation")
public class ReclamationRestController {


    @Autowired
    private ReclamationRepository reclamationRepository;

    @Autowired
    private ChauffeurRepository chauffeurRepository;

    @Autowired
    private PassegerRepository passegerRepository;

    @Autowired
    private MailService mailService;

    @GetMapping("/all")
    public List<Reclamation> getAll() {
        return (List<Reclamation>) reclamationRepository.findAll();
    }

    @PostMapping("/add/{idU}")
    public Reclamation addreclamation(@RequestBody Reclamation r, @PathVariable Long idU) {
        for (Chauffeur chauffeur : chauffeurRepository.findAll()) {
            if (chauffeur.getId().equals(idU)) {
                r.setAppUser(chauffeur);
            }
        }

        for (Passeger passeger : passegerRepository.findAll()) {
            if (passeger.getId().equals(idU)) {
                r.setAppUser(passeger);
            }
        }

        return this.reclamationRepository.save(r);
    }

    @PutMapping("/update/{id}/{idU}")

    public Reclamation updatereclamtion(@RequestBody Reclamation r, @PathVariable Long id, @PathVariable Long idU) {
        r.setId(id);
        for (Chauffeur chauffeur : chauffeurRepository.findAll()) {
            if (chauffeur.getId().equals(idU)) {
                r.setAppUser(chauffeur);
            }
        }

        for (Passeger passeger : passegerRepository.findAll()) {
            if (passeger.getId().equals(idU)) {
                r.setAppUser(passeger);
            }
        }

        return reclamationRepository.save(r);
    }

    @PostMapping("/reponse/{id}")
    public Response reponse(@PathVariable Long id, @RequestBody String reponce) {
        Response rs = new Response();
        try {
            Reclamation reclamation;
            reclamation = reclamationRepository.getById(id);
            reclamation.setReponseRec(true);
            reclamation.setReponse(reponce);
            reclamationRepository.save(reclamation);
            rs.setState("ok");
            return rs;
        } catch (Exception e) {
            rs.setState("non");
            return rs;
        }
    }

    @DeleteMapping("/delete/{id}")
    public Response deleteUser(@PathVariable Long id) {

        Response res = new Response();
        System.out.println("id=" + id);
        try {
            reclamationRepository.deleteById(id);
            res.setState("ok");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            res.setState("non");
        }
        return res;
    }

    @GetMapping("/one/{id}")
    public Reclamation getOne(@PathVariable Long id) {

        return reclamationRepository.getById(id);
    }

    @PostMapping(value = "/sendMail/{idreclamation}")
    public Response sendMail(@RequestBody Mail mail, @PathVariable Long idreclamation) {
        Response rs = new Response();


        System.out.println("Spring Mail - Sending Simple Email with JavaMailSender Example");

        mail.setFrom("rimesbenabdallh@gmail.com");
        mail.setTo(mail.getTo());
        mail.setSubject("Reponse pour votre Reclamation");
        mail.setContent(mail.getContent());
        mailService.sendSimpleMessage(mail);


        rs.setState("email ok");
        return rs;

    }

}
