package com.first.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.first.pojo.Student;

@Repository
public interface StudentDAO extends  JpaRepository<Student, Integer> {

	List<Student> findByName(String name);
	
	
    @Query("from Student where name=?1 and id=?2")
	public List<Student> getData(String name,Integer id);
	
	
}
