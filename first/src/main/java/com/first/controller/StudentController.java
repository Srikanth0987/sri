package com.first.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.first.exception.DefalutNameException;
import com.first.pojo.Address;
import com.first.pojo.AuditPojo;
import com.first.pojo.Student;
import com.first.service.IAuditService;
import com.first.service.IStudentService;
import com.first.service.StudentService;


import static java.lang.String.format;
import static java.util.Arrays.asList;


@RestController
@RequestMapping("student")
@Primary
public class StudentController {

	Logger logger = Logger.getLogger(StudentController.class);

	@Autowired
	private IAuditService auditservice;
	@Autowired
	private IStudentService studentService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity getStudentById(@PathVariable() Integer id) {
		Student studentid = studentService.getStudentById(id);

		ResponseEntity response = null;

		if (studentid != null) {
			
			logger.trace("trace Student getStudentById started...");

			logger.debug("debug Student getStudentById started... ");

			logger.info("info Student getStudentById started... ");

			logger.warn("warn Student getStudentById started...");

			logger.fatal("fatal Student getStudentById started...");

			logger.error("erro Student getStudentById started..");

			response = new ResponseEntity(studentid, HttpStatus.OK);
		} else {
			response = new ResponseEntity(studentid, HttpStatus.NOT_FOUND);

			logger.debug("Student getStudentById ended... ");
		}
		return response;

	}
	
	
	//@Secured("admin")
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public Address getAllStudents(Address address) throws IOException {
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		resourceDetails.setUsername("srikanth");
		resourceDetails.setPassword("srikanth");
		resourceDetails.setAccessTokenUri(format("http://localhost:%d/auth/oauth/token", 8989));
		resourceDetails.setClientId("service-account-1");
		resourceDetails.setClientSecret("service-account-1-secret");
		resourceDetails.setGrantType("password");
		resourceDetails.setScope(asList("resource-server-read"));
		DefaultOAuth2ClientContext clientContext = new DefaultOAuth2ClientContext();
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails, clientContext);
		restTemplate.setMessageConverters(asList(new MappingJackson2HttpMessageConverter()));
		final Address greeting = restTemplate.getForObject(format("http://localhost:%d/address?id=1", 8081),
				Address.class);
		System.out.println(greeting);	
						
		/*
		 * if(true)
		 * 
		 * throw new IOException();
		 */
		//logger.debug("Student get all method strating");
		//return studentService.getAllStudents();
		
		return greeting;
		}

	@RequestMapping(value="/save",method = RequestMethod.POST)
	// (save)
	public ResponseEntity getsavedata(@RequestBody @Valid Student student, BindingResult result)
			 {

		ResponseEntity responseEntity = null;
						
		List<ObjectError> errorlist = result.getAllErrors();

		List<String> studentlist = new ArrayList<>();

		for (ObjectError objectError : errorlist) {

			studentlist.add(objectError.getDefaultMessage());

		}
			if (result.hasErrors()) {
			logger.debug("Student getsave data method is not available ");

			responseEntity = new ResponseEntity(studentlist, HttpStatus.BAD_REQUEST);// 400
																// bad
																						// request
			return responseEntity;
		}
			studentService.getsavedata(student);
			
		responseEntity = new ResponseEntity(HttpStatus.OK);// 200 success

		logger.debug("Student getsave data method is available ");
		return responseEntity;
		
		

		/*responseEntity = new ResponseEntity(HttpStatus.CONFLICT);// 409 conflict

		return responseEntity;*/

	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deletedata(@RequestBody Student student)

	{
		logger.debug("Student delte data method is available ");

		studentService.deletedata(student);

	}

	@RequestMapping("updatedata")
	public void updatedata(@RequestBody Student student) {
		logger.debug("Student updatedata method is available ");

		studentService.updatedata(student);
	}

	@RequestMapping("getStudents")
	public void getStudents(@RequestBody List<Student> students) {
		logger.debug("Student getStudents method is available ");
		studentService.getStudents(students);
	}

	@RequestMapping(value = "/getdata1/{name}/{id}")
	public List<Student> getdata1(@PathVariable String name, @PathVariable Integer id) {
		return studentService.getdata(name, id);
	}

	@RequestMapping(value = "/records/{PageNo}/{PageSize}")
	public List<Student> getAllByPage(@PathVariable Integer PageNo, @PathVariable Integer PageSize) 
	{
		return studentService.pagerequest(PageNo, PageSize);
	}
		
	}

