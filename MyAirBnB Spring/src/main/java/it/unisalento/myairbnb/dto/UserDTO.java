package it.unisalento.myairbnb.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import it.unisalento.myairbnb.validators.UserDTONameConstraint;

public class UserDTO {

	int id;
	@NotEmpty
	@UserDTONameConstraint(name="pippo")
	String name;
	@NotEmpty
	String surname;
	@NotEmpty
	@Email
	String email;
	int age;
	Date dataNascita;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	
}
