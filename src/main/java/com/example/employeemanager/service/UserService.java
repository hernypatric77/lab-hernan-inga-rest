package com.example.employeemanager.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import com.example.employeemanager.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanager.exception.UserNotFoundException;
import com.example.employeemanager.repo.UserRepo;

@Service("userService")
@Transactional
public class UserService {

	private final UserRepo userRepo;

	@Autowired
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	public User addUser(User user) {
		user.setCreated(LocalDateTime.now());
		String userAux = user.getFirtName().substring(0,user.getFirtName().length()-1).concat(user.getLastName());
		try {
			User userB = findUserByUserName(userAux);
		}catch (UserNotFoundException e){
			userAux = user.getFirtName().substring(0,user.getFirtName().length()-2).concat(user.getLastName());
		}
		user.setUserName(userAux);
		return userRepo.save(user);
	}
	
	public List<User> findAllUser(){
		return userRepo.findAll();
	}
	
	public User updateUser(User user) {
		user.setUpdated(LocalDateTime.now());
		return userRepo.save(user);
	}
	
	public User findEmployeeById(Long id) {
		return userRepo.findUserById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
	}

	public User findUserByUserName(String userName) {
		return userRepo.findUserByUserName(userName).orElseThrow(() -> new UserNotFoundException("User by code " + userName + " was not found"));
	}
	
	public void deleteUser(Long id) {
		 userRepo.deleteUserById(id);
	}

}
