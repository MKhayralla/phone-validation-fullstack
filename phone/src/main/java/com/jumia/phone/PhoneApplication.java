package com.jumia.phone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PhoneApplication {
	// Enable CORS Policy for all origins
	// it's better to use a separate configuration class for this bean
	// Only did this for simplicty 
	@Bean
	public WebMvcConfigurer corsConfig() {
		return new WebMvcConfigurer(){
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")
				.allowedOrigins("*") ;
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(PhoneApplication.class, args);
	}

}
