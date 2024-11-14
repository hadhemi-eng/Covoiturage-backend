package com.bezkoder.spring.login.repository;


import com.bezkoder.spring.login.models.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChauffeurRepository extends JpaRepository<Chauffeur,Long> {

    Chauffeur findChauffeurByUsername(String username);
}
