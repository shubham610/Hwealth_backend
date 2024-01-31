package com.hwealth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwealth.dao.UserDao;
import com.hwealth.exception.UserException;
import com.hwealth.model.User;



@Service
public class UserService {

	@Autowired
	UserDao dao;

	public User addUser(User c) {
		Optional<User> findByName = dao.checkUserName(c.getUserName());
		Optional<User> findByPhone = dao.checkUserPhoneNo(c.getUserPhoneNo());
		if (findByName.isPresent())
			throw new UserException("UserName already Used");
		else if(findByPhone.isPresent())
			throw new UserException("UserPhoneNo already Used");
		else
			return dao.save(c);
			
	}

	public User updateUser(User c) {
		Optional<User> findById = dao.findById(c.getUserId());
		if (!findById.isPresent())
			throw new UserException("User not present");
		else
			return dao.save(c);
	}

	public User removeUser(long id) {
		Optional<User> findById = dao.findById(id);
		if (findById.isPresent()) {
			User User = findById.get();
			dao.delete(User);
			return User;
		} else
			throw new UserException("User not present");

	}

	public User searchUser(long id) {
		Optional<User> findById = dao.findById(id);
		if (findById.isPresent())
			return findById.get();
		else
			throw new UserException("User not present");
	}
	
	public User login(String userName,String userPassword) {
		Optional<User> findByName = dao.LoginUser(userPassword, userName);
		if (findByName.isPresent())
			return findByName.get();
		else
			throw new UserException("User not present");
	}
	

	public List<User> getAllUser() {
		if (dao.findAll().size() == 0)
			throw new UserException("User list is empty");
		else
			return dao.findAll();
	}
	
	

}
