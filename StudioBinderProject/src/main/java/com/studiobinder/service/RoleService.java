package com.studiobinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.studiobinder.Dao.RoleDao;
import com.studiobinder.pojo.RolePojo;

@Service
public class RoleService implements IRolService{
	
	@Autowired
	private RoleDao roledao;
	
	@Override

	public void DeleteRoleData(Integer id) {
		roledao.delete(id);
		
			}

	@Override
	public void getRoleById(Integer id) {
		roledao.findOne(id);
	
	}
	
	@Override
	public List<RolePojo> getRole(RolePojo relpojo) {
		return roledao.findAll();
	}

	@Override
	public void SaveRoledata(RolePojo rolepojo) {
		roledao.save(rolepojo);
		
	}


	
}
