package com.musyan.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EntityScan(basePackages = {"com.musyan"})
@EnableJpaRepositories(basePackages = {"com.musyan"})
@ComponentScan(basePackages = {"com.musyan"})
@EnableScheduling
@SpringBootApplication

public class ExceptionManagamentStarter {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionManagamentStarter.class, args);
	}

}
