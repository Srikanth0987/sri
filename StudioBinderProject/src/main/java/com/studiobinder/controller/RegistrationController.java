package com.studiobinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.studiobinder.pojo.RegistrationPojo;
import com.studiobinder.service.IRegistrationService;

@RestController
@RequestMapping("registration")
public class RegistrationController {

	@Autowired
	private IRegistrationService registrationService;

	@RequestMapping(method = RequestMethod.POST)
	public void getData(@RequestBody RegistrationPojo registrationPojo) {
		registrationService.SaveUserdata(registrationPojo);
	}

	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void DeleteData(@PathVariable int id) {
		System.out.println("====================");
		registrationService.DeleteUserData(id);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<RegistrationPojo> getall(RegistrationPojo registrationPojo) {
		return registrationService.getRegistration(registrationPojo);

	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	public void getUserByid(@PathVariable int id) {
		registrationService.getUserById(id);
	}
	

}
