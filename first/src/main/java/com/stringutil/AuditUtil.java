package com.stringutil;

import java.beans.PropertyDescriptor;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.first.pojo.AuditPojo;
import com.first.pojo.Student;
import com.first.service.IAuditService;
@Component
public class AuditUtil {
	
	@Autowired
	private IAuditService service;
	
	public void Audit(Object oldobj,Object newobj)
	{
		
	String user=SecurityContextHolder.getContext().getAuthentication().getName();
		
	BeanWrapper	oldbw=PropertyAccessorFactory.forBeanPropertyAccess(oldobj);
	BeanWrapper newbw= PropertyAccessorFactory.forBeanPropertyAccess(newobj);
	PropertyDescriptor[] pds= oldbw.getPropertyDescriptors();
	
	for (PropertyDescriptor propertyDescriptor : pds) 
	
	{
	String propertyname=propertyDescriptor.getName();
	
	String oldname=oldbw.getPropertyValue(propertyname).toString();
	String newname=newbw.getPropertyValue(propertyname).toString();
	
	if(!newname.equals(oldname))
	{
		AuditPojo pojo=new AuditPojo();
		pojo.setPropertyName(propertyname);
		pojo.setClassName(Student.class.getName());
		pojo.setOldName(oldname);
		pojo.setNewValue(newname);
		pojo.setOperation("update");
		pojo.setUser(user);	
		service.SaveAudit(pojo);
							
	}
		
	}

		
		
		
	}
	
	
	

}
