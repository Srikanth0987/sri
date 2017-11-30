package com.studiobinder.StudioBinderProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages={"com.studiobinder.pojo"})
@EnableJpaRepositories(basePackages={"com.studiobinder.Dao"})
@ComponentScan(basePackages={"com.studiobinder.controller","com.studiobinder.service"})
public class StudioBinderProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudioBinderProjectApplication.class, args);
	}
}
