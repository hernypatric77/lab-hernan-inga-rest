package com.example.employeemanager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemanager.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	void deleteUserById(Long id);
	
	Optional<User> findUserById(Long id);
	Optional<User> findUserByUserName(String userName);

}
