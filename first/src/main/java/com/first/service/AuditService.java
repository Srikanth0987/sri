package com.first.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.Dao.AuditDAO;
import com.first.pojo.AuditPojo;
import com.stringutil.AuditUtil;
@Service
public class AuditService implements IAuditService
{
	
	@Autowired
	private AuditDAO auditdao;

	@Override
	public void SaveAudit(AuditPojo pojo) {
		
		auditdao.save(pojo);
		
	}
		
	
	
}
