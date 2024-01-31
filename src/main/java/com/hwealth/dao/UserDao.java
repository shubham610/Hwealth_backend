package com.hwealth.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hwealth.model.User;

@Repository
public interface UserDao  extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM User u WHERE u.userName = :userName and u.userPassword = :userPassword")
	Optional<User> LoginUser(
	  @Param("userPassword") String userPassword, 
	  @Param("userName") String userName);

	@Query("SELECT u FROM User u WHERE u.userName = :userName")
	Optional<User> checkUserName(
	  @Param("userName") String userName);
	
	@Query("SELECT u FROM User u WHERE u.userPhoneNo= :userPhoneNo")
	Optional<User> checkUserPhoneNo(
	  @Param("userPhoneNo") long userPhoneNo);


	
}


