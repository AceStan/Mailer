package com.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring.xml")
@EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class})
public class RunApp {

	public static void main(String[] args){
		
		SpringApplication.run(RunApp.class, args);
	}
}
