package com.zee.zee5Dashboard.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5Dashboard.entity.UserManagement;
import com.zee.zee5Dashboard.repository.UserManagementRepository;
import com.zee.zee5Dashboard.service.UserManagementService;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	@Autowired
	private UserManagementRepository userManagementRepository;

	@Override
	public List<UserManagement> getAllUsers() {
		// TODO Auto-generated method stub
		return userManagementRepository.findAll();
	}

	@Override
	public UserManagement saveUser(UserManagement userManagement) {
		// TODO Auto-generated method stub
		return userManagementRepository.save(userManagement);
	}

	@Override
	public UserManagement getUserById(long id) {
		// TODO Auto-generated method stub
		Optional<UserManagement> optional = userManagementRepository.findById(id);
		UserManagement user = null;
		
		if(optional.isPresent())
		{
			user = optional.get();
		}else
		{
			throw new RuntimeException("User not exists with this ID :"+id);
		}
		return user;
	}

	@Override
	public UserManagement userUpdate(UserManagement userManagement) {
		// TODO Auto-generated method stub
		return userManagementRepository.save(userManagement);
	}

	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		this.userManagementRepository.deleteById(id);
	}

	@Override
	public UserManagement manageLevel(UserManagement userManagement) {
		// TODO Auto-generated method stub
		return userManagementRepository.save(userManagement);
	}
}
