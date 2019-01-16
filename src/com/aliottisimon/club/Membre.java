package com.aliottisimon.club;

import java.io.Serializable;

public class Membre implements Serializable{

	private String name;
	private String firstname;
	private int age;
	private String licence;
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLicence() {
		return licence;
	}
	public void setLicence(String licence) {
		this.licence = licence;
	}
	@Override
	public String toString() {
		return "Membre [name=" + name + ", firstname=" + firstname + ", age=" + age + ", licence=" + licence + "]";
	}
	
	
	
}
