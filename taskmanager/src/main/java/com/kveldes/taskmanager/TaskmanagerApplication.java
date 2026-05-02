package com.kveldes.taskmanager;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.h2.server.web.JakartaWebServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.kveldes.taskmanager.domain.Project;
import com.kveldes.taskmanager.domain.ProjectRepository;
import com.kveldes.taskmanager.domain.StatusOfProject;


@SpringBootApplication
public class TaskmanagerApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(TaskmanagerApplication.class);

	private final ProjectRepository repository;
	

	public TaskmanagerApplication(ProjectRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
		logger.info("Application started");
	}

	// For H2
	@Bean
	public ServletRegistrationBean<JakartaWebServlet> h2ConsoleServlet() {
		ServletRegistrationBean<JakartaWebServlet> bean = new ServletRegistrationBean<>(new JakartaWebServlet(),
				"/h2-console/*");
		bean.addInitParameter("webAllowOthers", "true");
		return bean;
	}

	@Override
	public void run(String... args) throws Exception {
		repository.save(new Project("Initial Project", "My Initial Project", LocalDate.of(2026, 5, 2),
				LocalDate.of(2026, 5, 31), StatusOfProject.ACTIVE, Instant.now()));
		repository.save(new Project("1st Project", "My First Project", LocalDate.of(2026, 5, 10),
				LocalDate.of(2026, 6, 30), StatusOfProject.ACTIVE, Instant.now()));
		repository.save(new Project("Priority One Project", "My 1st Priority Project", LocalDate.of(2026, 5, 10),
				LocalDate.of(2026, 7, 30), StatusOfProject.ACTIVE, Instant.now()));

		// Fetch all projects and log to console
		for (Project project : repository.findAll()) {
			logger.info("name: {}, status: {}", project.getName(), project.getStatus());
		}
	}

}
