package com.kveldes.taskmanager.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long roleId;

	private String name;

	@Column(columnDefinition = "TEXT")
	private String description;

	public Role() {
	}

	public Role(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	// -=============================================================================================================-//
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subproject")
	private SubProject subproject;

	// Getter and setter
	public SubProject getSubProject() {
		return subproject;
	}

	public void setSubProject(SubProject subproject) {
		this.subproject = subproject;
	}

	// -=============================================================================================================-//

	public Long getRoleId() {
		return roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
