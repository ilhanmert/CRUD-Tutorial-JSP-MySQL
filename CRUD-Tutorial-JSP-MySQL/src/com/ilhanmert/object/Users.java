package com.ilhanmert.object;

public class Users 
{
	protected int id;
	protected String name,surname,username,password,email;
	public Users()
	{	
	}
	public Users (int id, String name, String surname, String username, String password, String email)
	{
		this.id=id;
		this.name=name;
		this.surname=surname;
		this.username=username;
		this.password=password;
		this.email=email;
	}
	public Users (String name, String surname, String username, String password, String email)
	{
		this.name=name;
		this.surname=surname;
		this.username=username;
		this.password=password;
		this.email=email;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
