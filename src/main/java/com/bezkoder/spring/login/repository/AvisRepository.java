package com.bezkoder.spring.login.repository;


import com.bezkoder.spring.login.models.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvisRepository extends JpaRepository<Avis, Long> {

    List<Avis> findAvisByChauffeur_Id(Long id);

    List<Avis> findAvisByPasseger_Id(Long id);
}
