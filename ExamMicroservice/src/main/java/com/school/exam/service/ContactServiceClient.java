package com.school.exam.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("CONTACT-MICROSERVICE")
public interface ContactServiceClient {
	
	@GetMapping("/contact/tst")
	String testContact();

}
