package com.hwealth.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hwealth.dao.UserDao;
import com.hwealth.exception.UserException;
import com.hwealth.model.User;
import com.hwealth.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200/")
public class UserController {

	@Autowired
	UserService service;
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUser() {
		try {
		return  new ResponseEntity<List<User>>( service.getAllUser(),HttpStatus.OK) ;
		}
		catch (UserException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/search/{id}")
	public ResponseEntity<User> searchUser(@PathVariable("id") long id) {
		try {
		return new ResponseEntity<User> (service.searchUser(id), HttpStatus.FOUND);
		}
		catch (UserException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/signup")
	public ResponseEntity<User> addUser(@RequestBody User User) {
		try {
		return  new ResponseEntity<User> (service.addUser(User),HttpStatus.CREATED);
		}
		catch (UserException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> userLogin(@RequestBody User User) {
		try {
			return  new ResponseEntity<User> (service.login(User.getUserName(),User.getUserPassword()),HttpStatus.OK);
			}
			catch (UserException e) {
				return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
			}
		
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<User> removeUser(@PathVariable("id") long id) {
		try {
			return  new ResponseEntity<User> (
		 service.removeUser(id), HttpStatus.OK);
		}
		catch (UserException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}

	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User User) {
		try {
			return  new ResponseEntity<User> (
		service.updateUser(User),HttpStatus.CREATED);
		}
		catch (UserException e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}
	

}
