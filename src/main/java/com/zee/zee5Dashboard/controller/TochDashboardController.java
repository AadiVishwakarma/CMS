package com.zee.zee5Dashboard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zee.zee5Dashboard.entity.TochDashboard;
import com.zee.zee5Dashboard.service.TochDashboardService;

@Controller
public class TochDashboardController {

	@Autowired
	private TochDashboardService tochdashboardService;
	
	@GetMapping({"/zee5dashboard/toch-dashboard","/parts"})
	public String listShows(HttpServletRequest request, Model model) {
	int currPage = 1; // default page number
	int pageSize = 3; // default pageSize
	int numRecords = tochdashboardService.getAllShows().size();
	int numPages = numRecords / pageSize;
	if (numRecords % pageSize > 0) {
	numPages++;
	}

	if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
	currPage = Integer.parseInt(request.getParameter("page"));
	}

	Page<TochDashboard> allShows = tochdashboardService.getAllShowsByPage(currPage-1, pageSize);
	System.out.println(allShows.getSize());
	int position = (currPage-1)*pageSize + 1;
	for (TochDashboard show: allShows) {
	show.setPosition(position++);
	}
	model.addAttribute("numPages", numPages);
	model.addAttribute("pageSize", pageSize);
	model.addAttribute("listShows", allShows);
	model.addAttribute("currPage", currPage);
	model.addAttribute("numRecords", numRecords);
	return "TochDashboard";
	}
	
	
//	@GetMapping("/zee5dashboard/toch-dashboard")
//	public String tochDashboard(Model model)
//	{
////		List<Dashboard> allShows = dashboardService.getAllShows();
////		long id = 1;
////		for (Dashboard d1: allShows) {
////		d1.setId(id++);
////		}
////		model.addAttribute("listShows",allShows);
////		return "index";
//		
//		List<TochDashboard> listShow = tochdashboardService.getAllShows();
//		model.addAttribute("listShows", listShow);
//		return "TochDashboard";
//	}
	
	@GetMapping("/zee5dashboard/toch-dashboard/newShowForm")
	public String addNewShow(Model model)
	{
		TochDashboard dashboard = new TochDashboard();
		model.addAttribute("tochdashboard",dashboard);
		return "TochDashboard_newShow";
	}
	
	@PostMapping("/zee5dashboard/toch-dashboard/saveShow")
	public String saveShow(@ModelAttribute("tochdashboard") TochDashboard dashboard)
	{
		tochdashboardService.saveShow(dashboard);
		return "redirect:/zee5dashboard/toch-dashboard";
	}
	
	
	@GetMapping("/zee5dashboard/toch-dashboard/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		
		TochDashboard dashboard1 = tochdashboardService.getShowById(id);
		
		model.addAttribute("tochdashboard", dashboard1);
		return "TochDashboard_editShow";
	}
	
	@PostMapping("/zee5dashboard/toch-dashboard/{id}")
	public String showUpdate(@PathVariable(value="id") Long id,@ModelAttribute("tochdashboard") TochDashboard tochdashboard,Model model)
	{
		
		TochDashboard existingShow = tochdashboardService.getShowById(id);
		existingShow.setId(id);
		existingShow.setShowName(tochdashboard.getShowName());
		existingShow.setChannel(tochdashboard.getChannel());
		existingShow.setFtpFolder(tochdashboard.getFtpFolder());
		existingShow.setLanguage(tochdashboard.getLanguage());
		existingShow.setWebRequest(tochdashboard.getWebRequest());
		existingShow.setBestSceneRequest(tochdashboard.getBestSceneRequest());
		existingShow.setPerformanceRequest(tochdashboard.getPerformanceRequest());
		
		
		
		// save updated student object
		tochdashboardService.showUpdate(existingShow);
		//return "redirect:/";
		
		//model.addAttribute("dashboard",dashboardService.getShowById(id));
		return "redirect:/zee5dashboard/toch-dashboard";
	}
	
	
//	@PutMapping("/updateShow/{id}")
//	public String updateShow(@PathVariable Long id,
//			@ModelAttribute("dashboard") Dashboard dashboard) {
//		
//		// get student from database by id
//		Dashboard existingShow = dashboardService.getShowById(id);
//		existingShow.setId(id);
//		existingShow.setShowName(dashboard.getShowName());
//		existingShow.setChannel(dashboard.getChannel());
//		existingShow.setFtpFolder(dashboard.getFtpFolder());
//		existingShow.setLanguage(dashboard.getLanguage());
//		existingShow.setWebRequest(dashboard.getWebRequest());
//		existingShow.setBestSceneRequest(dashboard.getBestSceneRequest());
//		existingShow.setPerformanceRequest(dashboard.getPerformanceRequest());
//		
//		
//		
//		// save updated student object
//		this.dashboardService.updateShow(dashboard);
//		return "redirect:/";		
//	}
	
	
	@GetMapping("/zee5dashboard/toch-dashboard/deleteShow/{id}")
	public String showDelete(@PathVariable (value = "id") long id)
	{
		this.tochdashboardService.deleteShowById(id);
		return "redirect:/zee5dashboard/toch-dashboard";
	}
}
