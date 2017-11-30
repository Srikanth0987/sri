package com.studiobinder.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.studiobinder.pojo.RolePojo;

@Repository
public interface RoleDao extends JpaRepository<RolePojo, Integer> {
	

	
}