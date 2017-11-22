package com.springEs.EsWebserviceDemo.resource;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springEs.EsWebserviceDemo.model.Users;
import com.springEs.EsWebserviceDemo.repository.UsersRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest/search")
public class SearchResource {

	@Autowired
    private RuntimeService runtimeService;
    @Autowired
    UsersRepository usersRepository;
    
    @Autowired
    private ApplicantRepository applicantRepository;

    @GetMapping(value = "/name/{text}")
    public List<Users> searchName(@PathVariable final String text) {
        return usersRepository.findByName(text);
    }


    @GetMapping(value = "/salary/{salary}")
    public List<Users> searchSalary(@PathVariable final Long salary) {
        return usersRepository.findBySalary(salary);
    }


    @GetMapping(value = "/all")
    public List<Users> searchAll() {
        List<Users> usersList = new ArrayList<>();
        Iterable<Users> userses = usersRepository.findAll();
        userses.forEach(usersList::add);
        applicantRepository.save(new Users("Ajay",123L, "Accounting","x","x", 12000L));
        Map<String, Object> vars = Collections.<String, Object>singletonMap("applicant", new Users("Ajay",123L, "Accounting","x","x", 12000L));
        runtimeService.startProcessInstanceByKey("myProcess", vars);
        return usersList;
    }


}
