package com.anuz.dummyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class DummyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DummyApiApplication.class, args);
	}
}
