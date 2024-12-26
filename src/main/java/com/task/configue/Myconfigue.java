package com.task.configue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Myconfigue {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();

}
}