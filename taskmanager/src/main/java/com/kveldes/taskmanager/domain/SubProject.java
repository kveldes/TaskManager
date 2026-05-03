package com.kveldes.taskmanager.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class SubProject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long subProjectId;

	private String name;

	@Column(columnDefinition = "TEXT")
	private String text;

	@Enumerated(EnumType.STRING)
	private StatusOfSubProject status;

	@Enumerated(EnumType.STRING)
	private SubProjectPriority priority;

	public SubProject() {
	}

	public SubProject(String name, String text, StatusOfSubProject status, SubProjectPriority priority) {
		super();
		this.name = name;
		this.text = text;
		this.status = status;
		this.priority = priority;

	}

	// -=============================================================================================================-//
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project")
	private Project project;

	// Getter and setter
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	// -=============================================================================================================-//

	// -=============================================================================================================-//
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "subproject")
	private List<Task> tasks;

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	// -=============================================================================================================-//
	
	public Long getSubProjectId() {
		return subProjectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public StatusOfSubProject getStatus() {
		return status;
	}

	public void setStatus(StatusOfSubProject status) {
		this.status = status;
	}

	public SubProjectPriority getPriority() {
		return priority;
	}

	public void setPriority(SubProjectPriority priority) {
		this.priority = priority;
	}

}
