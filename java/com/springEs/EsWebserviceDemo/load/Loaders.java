package com.springEs.EsWebserviceDemo.load;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.springEs.EsWebserviceDemo.model.Users;
import com.springEs.EsWebserviceDemo.repository.UsersRepository;
import com.springEs.EsWebserviceDemo.resource.ApplicantRepository;

@Component
public class Loaders {

    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    UsersRepository usersRepository;
    
    @Autowired
    ApplicantRepository applicantRepository;

    @PostConstruct
    @Transactional
    public void loadAll(){

        operations.putMapping(Users.class);
        System.out.println("Loading Data");
        usersRepository.save(getData());
        System.out.printf("Loading Completed");

    }

    private Users getData() {
       /* List<Users> userses = new ArrayList<>();
        userses.add(new Users("Ajay",123L, "Accounting","x","x", 12000L));
        userses.add(new Users("Jaga",1234L, "Finance", "x","x",22000L));
        userses.add(new Users("Thiru",1235L, "Accounting","x","x", 12000L));*/
        return new Users("Thiru",1235L, "Accounting","x","x", 12000L);
    }
    
    
    public  void createPersons() {
  		if (applicantRepository.findAll().size() == 0) {
   
  			applicantRepository.save(new Users("Ajay",123L, "Accounting","x","x", 12000L));
  			applicantRepository.save(new Users("Ajay",123L, "Accounting","x","x", 12000L));
  			applicantRepository.save(new Users("Ajay",123L, "Accounting","x","x", 12000L));
  		}
  	}
}
