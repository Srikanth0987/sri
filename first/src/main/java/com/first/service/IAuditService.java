package com.first.service;

import org.springframework.stereotype.Service;

import com.first.pojo.AuditPojo;

public interface IAuditService {
	
	public void SaveAudit(AuditPojo pojo);

}
