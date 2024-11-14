package com.bezkoder.spring.login.repository;



import com.bezkoder.spring.login.models.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnonceRepository  extends JpaRepository<Annonce,Long> {

    List<Annonce> findAnnonceByChauffeur_Id(Long id);






}
