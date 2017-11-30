package com.studiobinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.studiobinder.Dao.RegistrationDao;
import com.studiobinder.pojo.RegistrationPojo;
@Service
public class RegistrationService implements IRegistrationService{

	@Autowired
	private RegistrationDao registrationDao;

	@Override
		public void SaveUserdata(RegistrationPojo Registration) {
		
		registrationDao.save(Registration);
	}
	
	@Override
	public void getUserById(Integer id) {
		registrationDao.findOne(id);
			}

	@Override
	public void DeleteUserData(Integer id) {
		registrationDao.delete(id);
		
	}

	@Override
	public List<RegistrationPojo> getRegistration(RegistrationPojo registrationPojo) {
		
		return registrationDao.findAll();
	}

	
	}
