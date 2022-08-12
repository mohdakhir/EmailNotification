package com.coedify.sep.backend;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan(basePackages = "com.coedify.sep.backend")


@SpringBootApplication
@EnableAutoConfiguration
public class SepBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SepBackendApplication.class, args);
	}

	

}
