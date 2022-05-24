package com.zee.zee5Dashboard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@ToString
@Entity
@Table(name = "UserManagement")
public class UserManagement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="Id")
	private Long id;
	
	@Column(name ="Name")
	private String name;
	
	@Column(name ="Email")
	private String email;
	
	@Column(name ="Level")
	private String level;

}
