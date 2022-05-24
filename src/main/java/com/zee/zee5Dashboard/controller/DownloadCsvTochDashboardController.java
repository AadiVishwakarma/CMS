package com.zee.zee5Dashboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zee.zee5Dashboard.entity.TochDashboard;
import com.zee.zee5Dashboard.service.TochDashboardCsvExportService;
import com.zee.zee5Dashboard.service.TochDashboardService;


@Controller
public class DownloadCsvTochDashboardController {

	@Autowired
	private TochDashboardCsvExportService csvService;
	
	@Autowired
	private TochDashboardService tochdashboardService; 
	
	
	@RequestMapping("/zee5dashboard/toch-dashboard")
	public String index()
	{
		return "TochDashboard";
	}
	
	@RequestMapping("/zee5dashboard/toch-dashboard/download/toch_export.csv")
	public void downloadCsvFile(HttpServletResponse response) throws IOException
	{
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; file=toch_export.csv");
		csvService.downloadCsvFile(response.getWriter(), createDataTest());
	}
	
	private List<TochDashboard> createDataTest()
	{
		List<TochDashboard> allShows = tochdashboardService.getAllShows();
		return allShows;
	}
}
