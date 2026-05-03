package com.kveldes.taskmanager.domain;

import java.time.LocalDate;

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

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long taskId;

	private String name;

	@Column(columnDefinition = "TEXT")
	private String text;

	@Enumerated(EnumType.STRING)
	private TaskStatus status;

	private LocalDate dueDate;

	@Enumerated(EnumType.STRING)
	private TaskPriority priority;

	public Task() {
	}

	public Task(String name, String text, TaskStatus status, LocalDate due_date, TaskPriority priority) {
		super();
		this.name = name;
		this.text = text;
		this.status = status;
		this.dueDate = due_date;
		this.priority = priority;
	}

    //-=============================================================================================================-//
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
	public Long getTaskId() {
		return taskId;
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

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate due_date) {
		this.dueDate = due_date;
	}

	public TaskPriority getPriority() {
		return priority;
	}

	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}

}
