package com.zee.zee5Dashboard.service.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zee.zee5Dashboard.entity.BeforeTvDashboard;
import com.zee.zee5Dashboard.repository.BeforeTvDashboardRepository;
import com.zee.zee5Dashboard.utils.CSVHelper;
import com.zee.zee5Dashboard.utils.CSVHelperBeforeTvDashboard;

@Service
public class CSVImportBeforeTvDashboardService {

	@Autowired
	BeforeTvDashboardRepository beforetvdashboardRepository;
	
	public void save(MultipartFile file) {
	    try {
	      List<BeforeTvDashboard> tochs = CSVHelperBeforeTvDashboard.csvToTutorials(file.getInputStream());
	      beforetvdashboardRepository.saveAll(tochs);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }
	
	public ByteArrayInputStream load() {
	    List<BeforeTvDashboard> tochs = beforetvdashboardRepository.findAll();

	    ByteArrayInputStream in = CSVHelperBeforeTvDashboard.tutorialsToCSV(tochs);
	    return in;
	  }
	
	  public List<BeforeTvDashboard> getAllShows() {
	    return beforetvdashboardRepository.findAll();
	  }
}
