package com.springrestful.dao;

import java.util.List;

import com.springrestful.model.Person;

public interface PersonDao {
	public void addPerson(Person person);
	 
    public void editPerson(Person person, int personId);
 
    public void deletePerson(int personId);
 
    public Person find(int personId);
 
    public List<Person> findAll();
}
