package com.jordan.domain;

public class User {

	private String name;
	private int age;
	private String pol_code;
	private int id;
	public String getPol_code() {
		return pol_code;
	}
	public void setPol_code(String pol_code) {
		this.pol_code = pol_code;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
