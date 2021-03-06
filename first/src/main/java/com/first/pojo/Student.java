package com.first.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import jdk.nashorn.internal.runtime.regexp.RegExp;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue
	private Integer id;

	//@NotBlank
	//@Pattern(regexp = "^[A-Z][A-Z a-z 0-9]{2,20}@[A-Z a-z]{2,8}\\.[A-Z a-z]{2,8}$")
	private String name;

	private Integer age;
	
	private String qual;

	// @Length(min=10,max=10)

	private Long phone;
	public String getQual() {
		return qual;
	}

	public void setQual(String qual) {
		this.qual = qual;
	}

	private Integer pin;

	public Student() {

	}

	public Student(String name, Integer age, String qual, Long phone) {
		super();
		this.name = name;


		this.age = age;
		this.qual = qual;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	
	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

}
