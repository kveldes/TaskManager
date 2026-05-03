package com.kveldes.taskmanager.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SubProjectAssignment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "sub_project_id")
	private SubProject subProject;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public SubProjectAssignment() {
	}

	public SubProjectAssignment(SubProject subProject, Role role, User user) {
		this.subProject = subProject;
		this.role = role;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public SubProject getSubProject() {
		return subProject;
	}

	public void setSubProject(SubProject subProject) {
		this.subProject = subProject;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
