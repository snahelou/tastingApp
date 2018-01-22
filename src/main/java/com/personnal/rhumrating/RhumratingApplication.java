package com.personnal.rhumrating;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableOAuth2Sso
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
public class RhumratingApplication extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/tasting/**").access("#oauth2.hasScope('read')")
				.antMatchers(HttpMethod.POST, "/tasting/**").access("#oauth2.hasScope('write')");
	}

    @Value("${spring.datasource.url}")
    private String request;

	public static void main(String[] args) {
	    SpringApplication.run(RhumratingApplication.class, args);
	}
}
