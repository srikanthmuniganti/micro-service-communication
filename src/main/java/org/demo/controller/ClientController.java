package org.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class ClientController {

	
	/*
	 * @Autowired private RestTemplate restTemplate;
	 * 
	 * @Autowired private WebClient.Builder webClient;
	 */
	
	@Autowired
	private FirstClient firstClient;
	
	
	@Autowired
	private SecondClient secondClient;
	
	@Autowired
	Environment env;
	
	
	@GetMapping("/get-messages")
	public String getMessages()
	{
		
		//using RestTemplate creating bean in MainClass
		/*
		 * String first=restTemplate.getForObject("http://localhost:8080/first", String.class);
		 *String second=restTemplate.getForObject("http://localhost:8081/second", String.class);
		 *
		 */
		
		
		//using WebClient creating bean in MainClass
		
		/*String first=webClient.build()
							  .get()
							  .uri("http://localhost:8080/first")
							  .retrieve()
							  .bodyToMono(String.class)
							  .block();
		
		
		String second=webClient.build()
							   .get()
							   .uri("http://localhost:8081/second")
							   .retrieve()
							   .bodyToMono(String.class)
							   .block();
		
		*/
		
		

		return  firstClient.getFirstMessage()+"    "+secondClient.getSecondMessage()+env.getProperty("local.server.port");

	}
	
	/*
	 * Data from the other microservices can be retrieved in 3 ways they are
	 * 1. By creating and autowiring RestTemplate bean in the project
	 * 2. By creating and autowiring WebClient bean in the project
	 * this webClient is available in spring reactive web dependency
	 * 3.using openFeign interface
	 * 
	 */
	
	
}
