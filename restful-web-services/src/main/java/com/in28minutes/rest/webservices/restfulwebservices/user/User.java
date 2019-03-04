package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDateTime;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All details about the user. ")
public class User {

	private Integer id;

	@Size( message = "El nombre debe tener un mínimo de 2 caracteres y un máximo de 100", min = 2, max = 100)
	@ApiModelProperty(notes="El nombre debe tener un mínimo de 2 caracteres y un máximo de 100")
	private String name;

	@Past
	@ApiModelProperty(notes="Birthday date debe ser una fecha en el pasado")
	private LocalDateTime  birthDate;
	
	
	public User(Integer id, String name, LocalDateTime birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
	}
	
	

}
