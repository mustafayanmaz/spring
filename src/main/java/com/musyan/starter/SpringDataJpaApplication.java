package com.musyan.starter;

import com.musyan.configuration.GlobalProperties;
import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.musyan")
@SpringBootApplication
@ComponentScan(basePackages = "com.musyan")
@EnableJpaRepositories(basePackages = "com.musyan")
@EnableConfigurationProperties(value = GlobalProperties.class)

//@PropertySource(value = "classpath:app.properties")

public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}
