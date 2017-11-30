package com.first.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.pojo.AuditPojo;

@Repository
public interface AuditDAO extends JpaRepository<AuditPojo, Integer>
{
	

}
