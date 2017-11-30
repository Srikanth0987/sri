package com.first.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	
	@RequestMapping("LoginSuccess")
	public String LoginSuccess()
	{
		
		return "Success";
		
	}
	@RequestMapping("Failure")
	public String Failure()
	{
		return "Failure";
		
	}

}
