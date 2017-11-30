package com.first.pojo;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "userDetails")
public class UserDetailsPojo implements UserDetails {
	
	private String username;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;

	@Id
	@GeneratedValue
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
		
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="userAuthority" ,
		joinColumns={@JoinColumn(name="uid")},
		inverseJoinColumns={@JoinColumn(name="authid")}
	)
	private Collection<GrantedAuthorityImpl> authorities;

	
	public Collection<GrantedAuthorityImpl> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(Collection<GrantedAuthorityImpl> authorities) {
		this.authorities = authorities;
	}

	private String password;

	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String getUsername() {

		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {

		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {

		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {

		return this.enabled;
	}

}
