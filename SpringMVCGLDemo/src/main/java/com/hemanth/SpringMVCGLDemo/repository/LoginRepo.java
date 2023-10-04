package com.hemanth.SpringMVCGLDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hemanth.SpringMVCGLDemo.entity.Login;
@Repository
public interface LoginRepo extends JpaRepository<Login, Integer> {
	@Query(value="select * from Login l where l.user_name=:userName and l.password=:pwd",nativeQuery = true)
	Login fingByUserNameAndPassword(@Param("userName")String userName,@Param("pwd")String password);

}
