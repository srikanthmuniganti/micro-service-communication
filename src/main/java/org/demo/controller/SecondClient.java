package org.demo.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="second-service",url = "http://localhost:8081")
public interface SecondClient {

	@GetMapping("/second")
	public String getSecondMessage();	
	
}
