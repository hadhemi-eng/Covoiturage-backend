package com.bezkoder.spring.login.service;


import com.bezkoder.spring.login.models.*;

public interface AccountService {
  Passeger savePassager(String username, String password, String confirmedPassword, String firstName, String lastName,
                        String tel, String genre, String birthdate, String email, Boolean isPhoneVerified);

  Chauffeur saveChaufeur(String confirmedPassword, String email, String firstName, String lastName, String tel,
                         String username, String password, String genre, String birthdate,
                         String permis, String cin, String photo, String adress, Boolean isPhoneVerified) ;


  Admin saveAdmin(String username, String password, String confirmedPassword, String firstName, String lastName,
                  String tel, String genre, String birthdate, String email, Boolean isPhoneVerified);

  Role save(Role role);
  User loadUserByUsername(String username);
  void addRoleToUser(String username, String rolename);
}
