package com.zee.zee5Dashboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zee.zee5Dashboard.entity.BeforeTVFilter;
import com.zee.zee5Dashboard.entity.BeforeTvDashboard;
import com.zee.zee5Dashboard.service.BeforeTvFilterCsvExportService;
import com.zee.zee5Dashboard.service.BeforeTvFilterService;

@Controller
public class DownloadCsvBeforeTvFilterController {

	@Autowired
	private BeforeTvFilterCsvExportService csvService;
	
	@Autowired
	private  BeforeTvFilterService beforetvfilterService;
	
	@RequestMapping("/zee5dashboard/beforetv-filter")
	public String index()
	{
		return "BeforeTVFilter";
	}
	
	
	@RequestMapping("/zee5dashboard/beforetv-filter/download/beforetvFilter.csv")
	public void downloadCsvFile(HttpServletResponse response) throws IOException
	{
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; file=beforetvFilter.csv");
		csvService.downloadCsvFile(response.getWriter(), createDataTest());
	}
	
	private List<BeforeTVFilter> createDataTest()
	{
		List<BeforeTVFilter> allShows = beforetvfilterService.getAllShows();
		return allShows;
	}
}
