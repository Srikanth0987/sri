package com.first.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.first.Dao.UserDAO;
import com.first.pojo.UserDetailsPojo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		
		/*UserDetailsPojo pojo = new UserDetailsPojo();
		pojo.setAccountNonExpired(true);
		pojo.setAccountNonLocked(true);
		pojo.setCredentialsNonExpired(true);
		pojo.setEnabled(true);
		pojo.setPassword("sri");
		pojo.setUsername("sri1");

		GrantedAuthorityImpl a1 = new GrantedAuthorityImpl();
		a1.setAuthority("admin");

		GrantedAuthorityImpl a2 = new GrantedAuthorityImpl();
		a2.setAuthority("user");

		Collection<GrantedAuthorityImpl> c1 = new ArrayList<>();

		c1.add(a1);
		c1.add(a2);
		
		
		
		

*/
		List <UserDetailsPojo> list=dao.getUserByName(arg0);
		if(list==null || list.size()==0){		
		throw new UsernameNotFoundException("No user available");
		}
		
		UserDetailsPojo user=list.get(0);
		
		return user;
	}

}
