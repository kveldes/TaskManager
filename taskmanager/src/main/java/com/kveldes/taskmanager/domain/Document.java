package com.kveldes.taskmanager.domain;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long docId;

	private String originalFileName; // π.χ. manual.pdf

	private Long fileSize; // Μέγεθος σε bytes

	@CreationTimestamp
	@Column(updatable = false)
	private Instant uploadDate;

	private String fileName; // Το όνομα αποθήκευσης (π.χ. UUID_manual.pdf)

	private String filePath; // Το φυσικό μονοπάτι στο δίσκο

	private String fileType; // π.χ. application/pdf

	// Σύνδεση με Project (Προαιρετική - Nullable)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id")
	private Project project;

	// Σύνδεση με SubProject (Προαιρετική - Nullable)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sub_project_id")
	private SubProject subProject;

	// Σύνδεση με Task (Προαιρετική - Nullable)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "task_id")
	private Task task;

	// Σύνδεση με User (Ο χρήστης που το ανέβασε)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	public Document() {
	}

	public Document(String originalFileName, Long fileSize, String fileName, String filePath, String fileType,
			User user) {
		this.originalFileName = originalFileName;
		this.fileSize = fileSize;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileType = fileType;
		this.user = user;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public Instant getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Instant uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public SubProject getSubProject() {
		return subProject;
	}

	public void setSubProject(SubProject subProject) {
		this.subProject = subProject;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getDocId() {
		return docId;
	}

}
