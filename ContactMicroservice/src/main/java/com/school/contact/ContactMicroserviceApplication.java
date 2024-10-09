package com.school.contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ContactMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactMicroserviceApplication.class, args);
		System.out.println("Contact Application Started...");
	}

}
