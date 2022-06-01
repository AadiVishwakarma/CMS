package com.zee.zee5Dashboard.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

import com.zee.zee5Dashboard.entity.WeeklyWebisode;

public class CSVHelperWeeklyWebisode {

	public static String TYPE = "text/csv";
		
//		this.ChannelName = ChannelName;
//		this.ShowName = ShowName;
//		this.StartDay = StartDay;
//		this.StartDate = StartDate;
//		this.StartTime = StartTime;
//		this.Language = Language;
//		this.WebisodeCount = WebisodeCount;
//		this.ModifiedDate = ModifiedDate;
//		this.VSTStatus = VSTStatus;
//		this.VSTUrl = VSTUrl;
	 
	  static String[] HEADERs = { "id", "ChannelName","ShowName", "StartDay", "StartDate","StartTime", "Language" , "WebisodeCount" , "ModifiedDate" ,"VSTStatus", "VSTUrl"};
	  

	  public static boolean hasCSVFormat(MultipartFile file) {
	 System.out.println(file.getContentType());
	    if (TYPE.equals(file.getContentType())
	    		|| file.getContentType().equals("application/vnd.ms-excel")) {
	      return true;
	    }

	    return false;
	  }

	  public static List<WeeklyWebisode> csvToTutorials(InputStream is) {
	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        CSVParser csvParser = new CSVParser(fileReader,
	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

	      List<WeeklyWebisode> developerTutorialList = new ArrayList<>();

	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

	      for (CSVRecord csvRecord : csvRecords) {
	    	  WeeklyWebisode developerTutorial = new WeeklyWebisode(	    			  
	    			  	Long.parseLong(csvRecord.get("id")),
	    			  	csvRecord.get("ChannelName"),
	    			  	csvRecord.get("ShowName"),
	    			  	csvRecord.get("StartDay"),
	    			  	csvRecord.get("StartDate"),
	    			  	csvRecord.get("StartTime"),
	    			  	csvRecord.get("Language"),
	    			  	Integer.parseInt(csvRecord.get("WebisodeCount")),
	    			  	csvRecord.get("ModifiedDate"),
	    			  	csvRecord.get("VSTStatus"),
	    			  	csvRecord.get("VSTUrl")	
		        		
	            );

	    	  developerTutorialList.add(developerTutorial);
	      }

	      return developerTutorialList;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	  }

	  public static ByteArrayInputStream tutorialsToCSV(List<WeeklyWebisode> developerTutorialList) {
	    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

	    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
	        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
	      for (WeeklyWebisode developerTutorial : developerTutorialList) {
	        List<String> data = Arrays.asList(

	              String.valueOf(developerTutorial.getId()),
	              developerTutorial.getChannelName(),
	              developerTutorial.getShowName(),
	              developerTutorial.getStartDay(),
	              developerTutorial.getStartDate(),
	              developerTutorial.getStartTime(),
	              developerTutorial.getLanguage(),
	              String.valueOf(developerTutorial.getWebisodeCount()),
	              developerTutorial.getModifiedDate(),
	              developerTutorial.getVSTStatus(),
	              developerTutorial.getVSTUrl()
	             
	            );

	        csvPrinter.printRecord(data);
	      }

	      csvPrinter.flush();
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
	    }
	  }
}
