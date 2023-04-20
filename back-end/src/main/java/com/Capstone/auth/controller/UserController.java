package com.Capstone.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.Capstone.auth.entity.User;
import com.Capstone.auth.entity.UserService;

@RequestMapping("/users")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	
	@Autowired UserService service;
	
	@GetMapping
	public ResponseEntity <List<User>> getUsers(){
		return new ResponseEntity <List<User>>( service.getAllUser(), HttpStatus.OK);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		return new ResponseEntity <User>(service.getUserById(id),HttpStatus.OK);
		
	}
	@GetMapping("/email/{e}")
	public ResponseEntity<User> getUserByEmail(@PathVariable String e){
		return new ResponseEntity <User>(service.getUserByEmail(e),HttpStatus.OK);
		
	}
	@PostMapping
	public ResponseEntity <User> createUser(@RequestBody User p){
		return new ResponseEntity <User>(service.createUser(p), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity <User> updateUser(@RequestBody User p){
		return new ResponseEntity <User>(service.updateUser(p),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity <String> deleteUser(@PathVariable Long id){
		return new ResponseEntity<String>(service.removeUser(id),HttpStatus.OK);
		
	}
}
