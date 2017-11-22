package com.springEs.EsWebserviceDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Entity
@Document(indexName = "users", type = "users", shards = 1)
public class Users {

    private String name;
    @Id
    @javax.persistence.Id
    @GeneratedValue
    private Long id;
    private String teamName;
    private String index;
    private String refresh;
    private Long salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    

  

	public Users(String name, Long id, String teamName, String index,
			String refresh, Long salary) {
		super();
		this.name = name;
		this.id = id;
		this.teamName = teamName;
		this.index = index;
		this.refresh = refresh;
		this.salary = salary;
	}

	public Users() {

    }

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getRefresh() {
		return refresh;
	}

	public void setRefresh(String refresh) {
		this.refresh = refresh;
	}
}
