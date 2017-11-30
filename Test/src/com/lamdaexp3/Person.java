package com.lamdaexp3;

public class Person {
	
	private Integer id;
	private String location;
	private String name;
	private QualEnum qual;
		
	public Person(Integer id, String location, String name, QualEnum qual) {
		super();
		this.id = id;
		this.location = location;
		this.name = name;
		this.qual = qual;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public QualEnum getQual() {
		return qual;
	}
	public void setQual(QualEnum qual) {
		this.qual = qual;
	}
	

}
