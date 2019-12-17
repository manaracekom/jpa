package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();

		// save a couple of customers
		repository.save(new Employee("1", "Alice", "Smith", "F", 5000000));
		repository.save(new Employee("2", "Bob", "Smith", "M", 10000000));

		// fetch all customers
		System.out.println("Employee found with findAll():");
		System.out.println("-------------------------------");
		for (Employee employee : repository.findAll()) {
			System.out.println(employee);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Employee found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));
		System.out.println(repository.findByFirstNameCustom("Alice"));
		System.out.println(repository.findByFirstNameNative("Alice"));

		System.out.println();

		System.out.println("Employees found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Employee employee : repository.findByLastName("Smith")) {
			System.out.println(employee);
		}
	}
}
