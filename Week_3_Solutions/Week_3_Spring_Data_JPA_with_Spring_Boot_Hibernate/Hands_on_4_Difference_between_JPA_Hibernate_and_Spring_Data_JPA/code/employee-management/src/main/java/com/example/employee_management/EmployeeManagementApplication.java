package com.example.employee_management;

import com.example.employee_management.hibernate.HibernateEmployeeDAO;
import com.example.employee_management.jpa.EmployeeService;
import com.example.employee_management.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// Spring Data JPA
		Employee emp1 = new Employee("SpringJPA", "Data Team");
		employeeService.addEmployee(emp1);

		// Hibernate
		Employee emp2 = new Employee("HibernateUser", "Backend");
		HibernateEmployeeDAO dao = new HibernateEmployeeDAO();
		Integer id = dao.addEmployee(emp2);

		System.out.println("Spring Data JPA Added Employee");
		System.out.println(emp1);

		System.out.println("Hibernate Added Employee with ID: " + id);
		System.out.println(emp2);

	}

}
