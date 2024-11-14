package com.bezkoder.spring.login.repository;



import com.bezkoder.spring.login.models.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture,Long> {


   List<Voiture> findVoitureByChauffeur_id(Long id);



}
