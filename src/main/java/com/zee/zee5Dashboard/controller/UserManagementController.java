package com.zee.zee5Dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zee.zee5Dashboard.entity.UserManagement;
import com.zee.zee5Dashboard.service.UserManagementService;



@Controller
public class UserManagementController {

	@Autowired
	private UserManagementService userManagementService;
	
	@GetMapping("/zee5dashboard/admin/admin-user")
	public String users(Model model)
	{
		
		model.addAttribute("listUsers", userManagementService.getAllUsers());
		return "UserAdmin";
	}
	
	@GetMapping("/zee5dashboard/admin/addNewUser")
	public String addNewUser(Model model)
	{
		UserManagement userManagement = new UserManagement();
		model.addAttribute("userManagement",userManagement);
		return "AddAdmin";
	}
	
	@PostMapping("/zee5dashboard/admin/saveUser")
	public String saveShow(@ModelAttribute("dashboard") UserManagement userManagement)
	{
		userManagementService.saveUser(userManagement);
		return "redirect:/zee5dashboard/admin/admin-user";
	}
	
	
	@GetMapping("/zee5dashboard/admin/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		UserManagement user1 = userManagementService.getUserById(id);
		
		model.addAttribute("userManagement", user1);
		return "EditUser";
	}
	
	@PostMapping("/zee5dashboard/admin/{id}")
	public String userUpdate(@PathVariable(value="id") Long id,@ModelAttribute("userManagement") UserManagement userManagement,Model model)
	{
		
		UserManagement existingUser = userManagementService.getUserById(id);
		//System.out.println(userManagement.getLevel());
		existingUser.setId(id);
		existingUser.setName(userManagement.getName());
		existingUser.setEmail(userManagement.getEmail());
		existingUser.setLevel(userManagement.getLevel());
		
		userManagementService.userUpdate(existingUser);
		return "redirect:/zee5dashboard/admin/admin-user";
	}
	
	
	@GetMapping("/zee5dashboard/admin/deleteUser/{id}")
	public String userDelete(@PathVariable (value = "id") long id)
	{
		this.userManagementService.deleteUserById(id);
		return "redirect:/zee5dashboard/admin/admin-user";
	}
	
	
	@PostMapping("/manageLevel/{id}")
	public String manageLevel(@PathVariable(value="id") Long id,@ModelAttribute("level") String level,Model model)
	{
		UserManagement existingUser = userManagementService.getUserById(id);
		System.out.println(existingUser);
		System.out.println(level);
		existingUser.setLevel(level);
		
		userManagementService.userUpdate(existingUser);
		return "redirect:/zee5dashboard/admin/admin-user";
	}
}
