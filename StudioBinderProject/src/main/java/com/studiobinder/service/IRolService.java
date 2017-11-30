package com.studiobinder.service;

import java.util.List;
import com.studiobinder.pojo.RolePojo;
public interface IRolService {
	public void SaveRoledata(RolePojo rolepojo);
	public void DeleteRoleData(Integer id);
	public void getRoleById(Integer id);
	public List<RolePojo> getRole(RolePojo relpojo);
		
}
