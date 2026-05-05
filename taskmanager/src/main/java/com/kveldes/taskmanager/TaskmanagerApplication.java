package com.kveldes.taskmanager;

import java.time.Instant;
import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kveldes.taskmanager.domain.Project;
import com.kveldes.taskmanager.domain.ProjectRepository;
import com.kveldes.taskmanager.domain.Role;
import com.kveldes.taskmanager.domain.RoleRepository;
import com.kveldes.taskmanager.domain.StatusOfProject;
import com.kveldes.taskmanager.domain.StatusOfSubProject;
import com.kveldes.taskmanager.domain.SubProject;
import com.kveldes.taskmanager.domain.SubProjectPriority;
import com.kveldes.taskmanager.domain.SubProjectRepository;
import com.kveldes.taskmanager.domain.Task;
import com.kveldes.taskmanager.domain.TaskPriority;
import com.kveldes.taskmanager.domain.TaskRepository;
import com.kveldes.taskmanager.domain.TaskStatus;
import com.kveldes.taskmanager.domain.User;
import com.kveldes.taskmanager.domain.UserRepository;

@SpringBootApplication
public class TaskmanagerApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(TaskmanagerApplication.class);

	private final ProjectRepository projectRepository;
	private final SubProjectRepository subProjectRepository;
	private final RoleRepository roleRepository;
	private final UserRepository userRepository;
	private final TaskRepository taskRepository;

	public TaskmanagerApplication(ProjectRepository projectRepository, SubProjectRepository subProjectRepository,
			RoleRepository roleRepository, UserRepository userRepository, TaskRepository taskRepository) {
		this.projectRepository = projectRepository;
		this.subProjectRepository = subProjectRepository;
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
		this.taskRepository = taskRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
		logger.info("Application started");
	}

	// Dummy data
	@Override
	public void run(String... args) throws Exception {
		// 1. Δημιουργία Project
		Project p1 = new Project("Initial Project", "Description", LocalDate.now(), LocalDate.now().plusMonths(1),
				StatusOfProject.ACTIVE, Instant.now());
		projectRepository.save(p1);

		// 2. Δημιουργία Roles
		Role adminRole = new Role("ADMIN", "System Administrator");
		Role devRole = new Role("DEVELOPER", "Software Developer");
		roleRepository.save(adminRole);
		roleRepository.save(devRole);

		// 3. Δημιουργία Users
		User user1 = new User("Konstantinos", "Velntes", "k123456@example.com", "password123", true);
		userRepository.save(user1);

		// 4. Δημιουργία SubProject (Σύνδεση με Project)
		SubProject sp1 = new SubProject("Backend API", "Development of REST services", StatusOfSubProject.ACTIVE,
				SubProjectPriority.HIGH);
		sp1.setProject(p1); // Σύνδεση με το Project p1
		subProjectRepository.save(sp1);

		// 5. Δημιουργία Task (Σύνδεση με SubProject)
		Task t1 = new Task("Database Setup", "Configure MySQL and JPA", TaskStatus.ToDo, LocalDate.now().plusDays(5),
				TaskPriority.HIGH);
		t1.setSubProject(sp1); // Σύνδεση με το SubProject sp1
		taskRepository.save(t1);

		logger.info("Dummy data for all entities initialized successfully!");
	}

/////////////////////////
}
