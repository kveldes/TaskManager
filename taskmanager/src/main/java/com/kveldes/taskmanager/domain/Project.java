package com.kveldes.taskmanager.domain;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long project_id;

	private String name;

	@Column(columnDefinition = "TEXT")
	private String description;

	private LocalDate startDate;

	private LocalDate endDate;

	@Enumerated(EnumType.STRING)
	private StatusOfProject status;

	// Timestamp
	@Column(name = "created_at", updatable = false)
	private Instant createdAt;

	// Constructors

	public Project() {
	}

	public Project(String name, String description, LocalDate startDate, LocalDate endDate, StatusOfProject status,
			Instant createdAt) {
		super();
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.createdAt = createdAt;
	}
	//-=============================================================================================================-//
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
	private List<SubProject> subprojects;

	public List<SubProject> getSubprojects() {
		return subprojects;
	}

	public void setSubprojects(List<SubProject> subprojects) {
		this.subprojects = subprojects;
	}
	//-=============================================================================================================-//
	
	// Getters & Setters
	public Long getProject_id() {
		return project_id;
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

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public StatusOfProject getStatus() {
		return status;
	}

	public void setStatus(StatusOfProject status) {
		this.status = status;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

}
