package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation,Long> {



}
