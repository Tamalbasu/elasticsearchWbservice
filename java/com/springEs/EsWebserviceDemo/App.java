package com.springEs.EsWebserviceDemo;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

import com.springEs.EsWebserviceDemo.load.Loaders;
import com.springEs.EsWebserviceDemo.resource.ApplicantRepository;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
        System.out.println( "Hello World!" );
    }
    
    @Bean
	public CommandLineRunner init(final Loaders myService) {
 
		return new CommandLineRunner() {
			public void run(String... strings) throws Exception {
				myService.createPersons();
			}
		};
 
	}
    
 
    
    
    
    
}
