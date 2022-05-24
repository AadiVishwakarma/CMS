package com.zee.zee5Dashboard.service;

import java.util.List;

import com.zee.zee5Dashboard.entity.UserManagement;


public interface UserManagementService {

	List<UserManagement> getAllUsers();
	UserManagement saveUser(UserManagement userManagement);
	UserManagement getUserById(long id);
	
	UserManagement userUpdate(UserManagement userManagement);
	
	void deleteUserById(long id);
	UserManagement manageLevel(UserManagement userManagement);
}
