package com.bezkoder.spring.login.repository;


import com.bezkoder.spring.login.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

    Admin findByUsername(String username);
    List<Admin> findChauffeurByIdNotNull();
}
