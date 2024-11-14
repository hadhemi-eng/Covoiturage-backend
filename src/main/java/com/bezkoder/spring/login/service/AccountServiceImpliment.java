package com.bezkoder.spring.login.service;


import com.bezkoder.spring.login.models.*;
import com.bezkoder.spring.login.repository.RoleRepository;
import com.bezkoder.spring.login.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AccountServiceImpliment implements AccountService{
  private UserRepository userRepository;
  private RoleRepository roleRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  public AccountServiceImpliment(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }






    @Override
    public Passeger savePassager(String username, String password, String confirmedPassword, String firstName, String lastName, String tel, String genre, String birthdate, String email, Boolean isPhoneVerified) {
        User user=userRepository.findByUsername(username);

        if(user!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        Passeger appUser=new Passeger();
        appUser.setUsername(username);
        appUser.setLastName(lastName);
        appUser.setFirstName(firstName);
        appUser.setTel(tel);
        appUser.setGenre(genre);
        appUser.setBirthdate(birthdate);
        appUser.setEmail(email);

        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUser.setConfirmedPassword(bCryptPasswordEncoder.encode(confirmedPassword));

        Role role=roleRepository.findRoleByName("PASSAGER");
        if(role != null){
            appUser.getRoles().add(role);
            userRepository.save(appUser);
        }

        addRoleToUser(username,"PASSAGER");

        return appUser;
    }
    @Override
    public Chauffeur saveChaufeur(String confirmedPassword, String email, String firstName, String lastName, String tel, String username, String password, String genre, String birthdate, String permis, String cin, String photo, String adress, Boolean isPhoneVerified) {
        User  user=userRepository.findByUsername(username);

        if(user!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        Chauffeur appUser=new Chauffeur();
        appUser.setConfirmedPassword(bCryptPasswordEncoder.encode(confirmedPassword));
        appUser.setEmail(email);
        appUser.setFirstName(firstName);
        appUser.setLastName(lastName);
        appUser.setTel(tel);
        appUser.setPhoneVerified(false);
        appUser.setUsername(username);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));

        appUser.setGenre(genre);
        appUser.setBirthdate(birthdate);
        appUser.setPermis(permis);
        appUser.setCin(cin);
        appUser.setPhoto(photo);
        appUser.setAdress(adress);
  Role role=roleRepository.findRoleByName("CONDUCTEUR");
        if(role != null){
            appUser.getRoles().add(role);
            userRepository.save(appUser);
        }
        addRoleToUser(username,"CONDUCTEUR");
        return appUser;

    }


    @Override
    public Admin saveAdmin(String username, String password, String confirmedPassword, String firstName, String lastName, String tel, String genre, String birthdate , String email, Boolean isPhoneVerified) {
        User  user=userRepository.findByUsername(username);

        if(user!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        Admin appUser=new Admin();
        appUser.setUsername(username);
        appUser.setLastName(lastName);
        appUser.setFirstName(firstName);
        appUser.setTel(tel);
        appUser.setPhoneVerified(false);
        appUser.setGenre(genre);
        appUser.setBirthdate(birthdate);
        appUser.setEmail(email);

        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUser.setConfirmedPassword(bCryptPasswordEncoder.encode(confirmedPassword));


        Role role=roleRepository.findRoleByName("ADMIN");
        if(role != null){
            appUser.getRoles().add(role);
            userRepository.save(appUser);
        }
        addRoleToUser(username,"ADMIN");
        return appUser;
    }








    @Override
  //ajouter une role
  public Role save(Role role) {
    return roleRepository.save(role);
  }

  @Override
  //recherche de user
  public User loadUserByUsername(String username)
  {
    return userRepository.findByUsername(username);
  }



  @Override
//  //affectation de role d'utilisateur
  public void addRoleToUser(String username, String rolename) {

     User appUser=userRepository.findByUsername(username);
    Role appRole=roleRepository.findRoleByName(rolename);

    appUser.getRoles().add(appRole);
    //userRepository.save(appUser);
  }



  }

