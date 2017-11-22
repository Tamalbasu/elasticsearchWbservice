package com.springEs.EsWebserviceDemo.repository;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.springEs.EsWebserviceDemo.model.Users;

import java.util.List;

public interface UsersRepository extends ElasticsearchRepository<Users, Long> {
    List<Users> findByName(String text);

    List<Users> findBySalary(Long salary);
}
