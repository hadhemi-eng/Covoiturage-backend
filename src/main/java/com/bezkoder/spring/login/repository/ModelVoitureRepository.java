package com.bezkoder.spring.login.repository;


import com.bezkoder.spring.login.models.Modelvoiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelVoitureRepository extends JpaRepository<Modelvoiture,Long> {

   List<Modelvoiture> findModelvoitureByMarqueVoiture_Nom(String nom);
}
