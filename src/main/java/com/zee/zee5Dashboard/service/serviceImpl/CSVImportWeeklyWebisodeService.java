package com.zee.zee5Dashboard.service.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.zee.zee5Dashboard.entity.WeeklyWebisode;
import com.zee.zee5Dashboard.repository.WeeklyWebisodeRepository;
import com.zee.zee5Dashboard.utils.CSVHelper;
import com.zee.zee5Dashboard.utils.CSVHelperWeeklyWebisode;

@Service
public class CSVImportWeeklyWebisodeService {

	@Autowired
	WeeklyWebisodeRepository weeklywebisodeRepository;
	
	public void save(MultipartFile file) {
	    try {
	      List<WeeklyWebisode> tochs = CSVHelperWeeklyWebisode.csvToTutorials(file.getInputStream());
	      weeklywebisodeRepository.saveAll(tochs);
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
	  }
	
	public ByteArrayInputStream load() {
	    List<WeeklyWebisode> tochs = weeklywebisodeRepository.findAll();

	    ByteArrayInputStream in = CSVHelperWeeklyWebisode.tutorialsToCSV(tochs);
	    return in;
	  }
	
	  public List<WeeklyWebisode> getAllShows() {
	    return weeklywebisodeRepository.findAll();
	  }
}
