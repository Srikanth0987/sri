package com.studiobinder.service;

import java.util.List;

import com.studiobinder.pojo.RegistrationPojo;
public interface IRegistrationService {
	public void SaveUserdata(RegistrationPojo Registration);
	public void DeleteUserData(Integer id);
	public void getUserById(Integer id);
	public List<RegistrationPojo> getRegistration(RegistrationPojo registrationPojo);
	
	
}
