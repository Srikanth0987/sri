package com.first.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.first.pojo.UserDetailsPojo;

@Repository
public interface UserDAO extends JpaRepository<UserDetailsPojo, Integer> {

	@Query("from UserDetailsPojo u where u.username=?1")
	public List<UserDetailsPojo> getUserByName(String username);

}
