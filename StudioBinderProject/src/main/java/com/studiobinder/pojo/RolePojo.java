package com.studiobinder.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Role_tbl")
public class RolePojo {
	
	@Id   
	@GeneratedValue
	private Integer id;
	private String role;
	private String code;
		
	/*@ManyToMany
	@JoinTable(name="ourtable",
				joinColumns={@JoinColumn(name="roleid")},
				inverseJoinColumns={@JoinColumn(name="regid")})
	
*/	/*private List<RegistrationPojo> registration;*/
	
	/*public List<RegistrationPojo> getRegistration() {
		return registration;
	}
	public void setRegistration(List<RegistrationPojo> registration) {
		this.registration = registration;
	}
	*/	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	

}
