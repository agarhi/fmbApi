package com.fmb.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.fmb.api.db.repo")
@EntityScan("com.fmb.api.db.entity")   
public class FmbApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmbApiApplication.class, args);
	}

}
