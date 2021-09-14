package org.demo.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="first-service", url = "http://localhost:8080")
public interface FirstClient {
	
	@GetMapping("/first")
	public String getFirstMessage();
}
