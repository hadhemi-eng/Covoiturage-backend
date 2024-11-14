package com.bezkoder.spring.login.controllers;


import com.bezkoder.spring.login.models.Passeger;
import com.bezkoder.spring.login.models.Reservation;
import com.bezkoder.spring.login.repository.PassegerRepository;
import com.bezkoder.spring.login.repository.ReservationRepository;
import com.bezkoder.spring.login.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/passeger")
public class PassegerRestController {

    @Autowired
    private PassegerRepository passegerRepository;
    @Autowired

    private AccountService accountService;
    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/all")
    public List<Passeger> getAll() {
        return passegerRepository.findAll();
    }
 /*   @PostMapping("/add")
    public Passeger addpassager(String username, String password, String confirmedPassword, String firstName, String lastName, String tel, String sexe, String email){
        return this.accountService.savePassager(username,password, confirmedPassword,firstName, lastName,tel, sexe, email);
    }
    */

    @PostMapping("/add")
    public Passeger register(@RequestBody Passeger appUser) {
        return accountService.savePassager(appUser.getUsername(), appUser.getPassword(), appUser.getConfirmedPassword(), appUser.getFirstName(), appUser.getLastName(), appUser.getTel(), appUser.getGenre(), appUser.getBirthdate(), appUser.getEmail(),appUser.getPhoneVerified());
    }

//    @PostMapping("/ajouter")
//    public Passeger addpassager(@RequestBody Passeger passager) {
//
//        return this.passegerRepository.save(passager);
//
//    }


    @PutMapping("/update/{id}")
    public Passeger updateUser(@RequestBody Passeger user, @PathVariable Long id) {
          user.setId(id);
        Passeger client1 = passegerRepository.getById(id);

            user.setUsername(client1.getUsername());
            user.setPassword(client1.getPassword());
            user.setConfirmedPassword(client1.getConfirmedPassword());
            user.setRoles(client1.getRoles());

            return passegerRepository.save(user);

        }




    @DeleteMapping("/delete/{id}")
    public HashMap deleteconducteur(@PathVariable Long id) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            passegerRepository.deleteById(id);
            hashMap.put("state", "yes");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("state", "no");
            return hashMap;
        }


    }

    @GetMapping("/one/{id}")
    public Passeger getOne(@PathVariable Long id) {
        return passegerRepository.getById(id);
    }



    @GetMapping("/onebyuser/{username}")
    public Passeger getOnebyusername(@PathVariable String username) {
        return passegerRepository.findPassegerByUsername(username);
    }

    @GetMapping("/allreservationbyP/{idP}")
    public List<Reservation> getreservationbyPassager(@PathVariable Long idP) {

        return reservationRepository.findReservationByPasseger_Id(idP);

    }
}
