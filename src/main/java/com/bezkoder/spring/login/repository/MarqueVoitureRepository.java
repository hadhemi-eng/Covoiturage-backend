package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.Chauffeur;
import com.bezkoder.spring.login.models.MarqueVoiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarqueVoitureRepository extends JpaRepository<MarqueVoiture,Long> {




}
