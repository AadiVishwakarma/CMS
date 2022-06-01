package com.zee.zee5Dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zee.zee5Dashboard.entity.BeforeTvDashboard;
import com.zee.zee5Dashboard.entity.TochDashboard;
import com.zee.zee5Dashboard.service.serviceImpl.CSVImportBeforeTvDashboardService;
import com.zee.zee5Dashboard.utils.CSVHelper;
import com.zee.zee5Dashboard.utils.ResponseMessage;

@CrossOrigin("http://localhost:9005")
@Controller
@RequestMapping("/zee5dashboard/beforetv-dash")
public class BeforeTvDashboardFileUploadController {

	@Autowired
	CSVImportBeforeTvDashboardService fileService;
	
	@PostMapping("/upload-csv-file")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		    String message = "";

		    if (CSVHelper.hasCSVFormat(file)) {
		      try {
		        fileService.save(file);

		        message = "Uploaded the file successfully: " + file.getOriginalFilename();
		        
		        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
		                .path("/zee5dashboard/toch-dashboard/download/")
		                .path(file.getOriginalFilename())
		                .toUriString();

		        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message,fileDownloadUri));
		      } catch (Exception e) {
		        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
		        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message,""));
		      }
		    }

		    message = "Please upload a csv file!";
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message,""));
		  }

		  @GetMapping("/tutorials")
		  public ResponseEntity<List<BeforeTvDashboard>> getAllTutorials() {
		    try {
		      List<BeforeTvDashboard> tutorials = fileService.getAllShows();

		      if (tutorials.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(tutorials, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
}
