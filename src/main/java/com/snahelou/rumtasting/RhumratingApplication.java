package com.snahelou.rumtasting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableOAuth2Sso
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.snahelou.rumtasting.configuration",
        "com.snahelou.rumtasting.controller",
        "com.snahelou.rumtasting.data.entity",
        "com.snahelou.rumtasting.data.repository",
        "com.snahelou.rumtasting.error",
        "com.snahelou.rumtasting.service",
})
@EntityScan(basePackages = "com.snahelou.rumtasting.data.entity")
@EnableJpaRepositories(basePackages = {"com.snahelou.rumtasting.data.repository"})
@EnableSwagger2
public class RhumratingApplication extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
                .csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/tasting/**").access("#oauth2.hasScope('read')")
				.antMatchers(HttpMethod.PUT, "/tasting/**").access("#oauth2.hasScope('write')")
				.antMatchers(HttpMethod.DELETE, "/tasting/**").access("#oauth2.hasScope('write')")
				.antMatchers(HttpMethod.POST, "/tasting/**").access("#oauth2.hasScope('write')");
	}

    @Value("${spring.datasource.url}")
    private String request;

	public static void main(String[] args) {
	    SpringApplication.run(RhumratingApplication.class, args);
	}
}
