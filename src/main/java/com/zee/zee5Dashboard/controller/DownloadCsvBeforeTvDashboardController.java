package com.zee.zee5Dashboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zee.zee5Dashboard.entity.BeforeTvDashboard;
import com.zee.zee5Dashboard.service.BeforeTvDashboardCsvExportService;
import com.zee.zee5Dashboard.service.BeforeTvDashboardService;

@Controller
public class DownloadCsvBeforeTvDashboardController {

	@Autowired
	private BeforeTvDashboardCsvExportService csvService;
	
	@Autowired
	private BeforeTvDashboardService beforetvdashboardservice;
	
	
	@RequestMapping("/zee5dashboard/beforetv-dash")
	public String index()
	{
		return "BeforeTvDashboard";
	}
	
	
	
	@RequestMapping("/zee5dashboard/beforetv-dash/download/beforetvDashboard.csv")
	public void downloadCsvFile(HttpServletResponse response) throws IOException
	{
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; file=beforetvDashboard.csv");
		csvService.downloadCsvFile(response.getWriter(), createDataTest());
	}
	
	private List<BeforeTvDashboard> createDataTest()
	{
		List<BeforeTvDashboard> allShows = beforetvdashboardservice.getAllShows();
		return allShows;
	}
	
	
}
