/*
 * Copyright (c) 2020. Nelson Braillard.
 * All rights reserved.
 */

package braillarne.trainingcommunity.backend.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(List<Exercise> exercises) {
		this.exercises = exercises;
	}
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String email;
	private String password;
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	@JsonIgnoreProperties("user")
	private List<Exercise> exercises;

}
