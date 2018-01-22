package com.personnal.rhumrating;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.personnal.rhumrating.configuration",
        "com.personnal.rhumrating.controller",
        "com.personnal.rhumrating.data.entity",
        "com.personnal.rhumrating.data.repository",
        "com.personnal.rhumrating.error",
        "com.personnal.rhumrating.service",
})
@EntityScan(basePackages = "com.personnal.rhumrating.data.entity")
@EnableJpaRepositories(basePackages = {"com.personnal.rhumrating.data.repository"})
@EnableSwagger2
public class RhumratingApplication {

    @Value("${spring.datasource.url}")
    private String request;

	public static void main(String[] args) {
	    SpringApplication.run(RhumratingApplication.class, args);
	}
}
