package com.customAnnotaion;

@DbTest("student")
public class Studentpojo {
	
	private Integer id;
	private String name;
	private Integer age;
	private Integer qual;
	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getQual() {
		return qual;
	}
	public void setQual(Integer qual) {
		this.qual = qual;
	}
	
	
	

}
