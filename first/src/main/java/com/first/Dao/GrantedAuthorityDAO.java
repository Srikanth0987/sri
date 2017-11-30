package com.first.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.first.pojo.GrantedAuthorityImpl;
import com.first.pojo.UserDetailsPojo;

@Repository
public interface GrantedAuthorityDAO extends JpaRepository<GrantedAuthorityImpl, Integer>
{


}
