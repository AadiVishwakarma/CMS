package com.zee.zee5Dashboard.service.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zee.zee5Dashboard.entity.TochDashboard;
import com.zee.zee5Dashboard.repository.TochDashboardRepository;
import com.zee.zee5Dashboard.utils.CSVHelper;

@Service
public class CSVImportTochDashboardService {

	@Autowired
	TochDashboardRepository tochdashboardRepository;
	
	public void save(MultipartFile file) {
	    try {
	      List<TochDashboard> tochs = CSVHelper.csvToTutorials(file.getInputStream());
	      tochdashboardRepository.saveAll(tochs);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }
	
	public ByteArrayInputStream load() {
	    List<TochDashboard> tochs = tochdashboardRepository.findAll();

	    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tochs);
	    return in;
	  }
	
	  public List<TochDashboard> getAllShows() {
	    return tochdashboardRepository.findAll();
	  }
	  
	  
}
