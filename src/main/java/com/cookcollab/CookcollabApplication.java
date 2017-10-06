package com.cookcollab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class CookcollabApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookcollabApplication.class, args);
	}
}
