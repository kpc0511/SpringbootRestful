package com.springrestful.model;

import io.swagger.annotations.ApiModelProperty;

public class Person {
	@ApiModelProperty(notes = "The database generated person ID")
	private int personId;
	@ApiModelProperty(notes = "The person firstname")
	private String firstName;
	@ApiModelProperty(notes = "The person lastname")
	private String lastName;
	@ApiModelProperty(notes = "The person age")
	private int age;

	public Person() {

	}

	public Person(int personId, String firstName, String lastName, int age) {
		super();
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person Id:- " + getPersonId() + " First Name:- "
				+ getFirstName() + " Last Name:- " + getLastName() + " Age:- "
				+ getAge());
		return builder.toString();
	}
}
