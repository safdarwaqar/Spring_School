package com.school.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExamMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamMicroserviceApplication.class, args);
		System.out.println("Exam Application Started...");
	}

}
