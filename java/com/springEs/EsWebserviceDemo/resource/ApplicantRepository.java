package com.springEs.EsWebserviceDemo.resource;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springEs.EsWebserviceDemo.model.Users;

public interface ApplicantRepository extends JpaRepository<Users, Long> {

}