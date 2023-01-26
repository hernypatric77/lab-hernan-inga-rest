package com.example.employeemanager.resource;

import java.util.List;

import com.example.employeemanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanager.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserResource {

	private final UserService userService;
	
	@Autowired
	public UserResource(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> users = userService.findAllUser();
		return new ResponseEntity<> (users,HttpStatus.OK);
	}
	

	@GetMapping("/find/{id}")
	public ResponseEntity<User> getEmployeeById(@PathVariable("id") Long id){
		User user = userService.findEmployeeById(id);
		return new ResponseEntity<> (user,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User newUser = userService.addUser(user);
		return new ResponseEntity<User>(newUser,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> updateEmployee(@RequestBody User user){
		User updateemployee = userService.updateUser(user);
		return new ResponseEntity<User>(updateemployee,HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> deleteEDmployee(@PathVariable("id") Long id){
		userService.deleteUser(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
}
