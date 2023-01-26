package com.example.employeemanager.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@Data
@ToString
@Table(name="lab_users", schema = "hinga")
@Entity
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long id;
	
	@Column(name = "firstname")
	private String firtName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "username")
	private String userName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "postnumber")
	private Integer postNumber;

	private LocalDateTime created;

	private LocalDateTime updated;

	
	public User() {}

	

}
