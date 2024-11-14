package com.bezkoder.spring.login.repository;

import com.bezkoder.spring.login.models.Passeger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassegerRepository  extends JpaRepository<Passeger,Long> {

    Passeger findPassegerByUsername(String username);
    List<Passeger> findChauffeurByIdNotNull();
}
