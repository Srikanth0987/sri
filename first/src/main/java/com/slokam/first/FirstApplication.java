package com.slokam.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.stringutil.StringUtil;

@SpringBootApplication
@EnableJpaRepositories({"com.first.Dao"})
@ComponentScan({"com.first.controller","com.first.service","com.stringutil"})
@EntityScan("com.first.pojo")
@EnableResourceServer
public class FirstApplication {
	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}
		
	/*@Bean
	public StringUtil ut1()
	{
		return new StringUtil();
		
		}*/
}
