package com.bezkoder.spring.login.controllers;


import com.bezkoder.spring.login.models.Response;
import com.bezkoder.spring.login.models.User;
import com.bezkoder.spring.login.repository.UserRepository;
import com.bezkoder.spring.login.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserRestController {
  @Autowired
  private UserRepository userRepository;
    @Autowired
    private AccountService accountService;


//    public Optional findUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//
//    public Optional findUserByResetToken(String resetToken) {
//        return userRepository.findByResetToken(resetToken);
//    }

    @PostMapping("/register")
    public User register(@RequestBody User appUser){
        return (User) accountService.saveAdmin(appUser.getUsername(),appUser.getPassword(),appUser.getConfirmedPassword(),appUser.getFirstName(),appUser.getLastName(),appUser.getTel(),appUser.getGenre(),appUser.getBirthdate(),appUser.getEmail(),appUser.getPhoneVerified());
//
//    @PostMapping("/registerpassager")
//    public Passeger register(@RequestBody Passeger appUser){
//        return  accountService.savePassager(appUser.getUsername(),appUser.getPassword(),appUser.getConfirmedPassword(),appUser.getFirstName(),appUser.getLastName(),appUser.getTel(),appUser.getSexe(),appUser.getEmail());
//    }
//
//    @PostMapping("/addconducteur")
//    public Chauffeur ajouterconducteur(String confirmedPassword, String email, String firstName, String lastName, String tel,
//                                       String username, String password, String ville, String sexe,
//                                       String permis, String cin, String photo, String adress, String age) {
//
//
//
//        return this.accountService.saveChaufeur( confirmedPassword, email, firstName, lastName,tel,
//                username, password, ville,sexe,
//                permis, cin, photo, adress,age);
//
//
//
//
//
//    }
//
//    @PostMapping("/addadmin")
//    public Admin addnewadmin(String username, String password, String confirmedPassword, String firstName, String lastName, String tel, String sexe, String email) {
//
//
//
//
//
//        return this.accountService.saveAdmin(username,password, confirmedPassword,firstName, lastName,tel, sexe, email);
//
//
   }





    @GetMapping("/all")
  public List<User> getAll(){
    return (List<User>) userRepository.findAll();
  }

  @PutMapping("/update/{id}")
  public User updateUser(@RequestBody User user, @PathVariable Long id){
    user.setId(id);
    return userRepository.save(user);

  }
  @DeleteMapping("/delete/{id}")
public Response deleteUser(@PathVariable Long id){

      Response res = new Response();
    System.out.println("id=" +id);
    try {
      userRepository.deleteById(id);
      res.setState("ok");
    }catch (Exception e){
      System.out.println(e.getMessage());
      res.setState("non");
    }
    return res ;
}
@GetMapping("/byiduser/{id}")
    public User  getUser(@PathVariable Long id){
    User appUser = userRepository.getById(id);
    return appUser ;
}


}



