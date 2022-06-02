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

import com.zee.zee5Dashboard.entity.BeforeTvDashboard;


public class CSVHelperBeforeTvDashboard {

	public static String TYPE = "text/csv";
	 
	  static String[] HEADERs = { "id","position","ShowId", "ShowName", "ShowStartTime","ShowEndTime","DayApplicable","STATUS","SeasonID"};

	  public static boolean hasCSVFormat(MultipartFile file) {
	 System.out.println(file.getContentType());
	    if (TYPE.equals(file.getContentType())
	    		|| file.getContentType().equals("application/vnd.ms-excel")) {
	      return true;
	    }

	    return false;
	  }

	  public static List<BeforeTvDashboard> csvToTutorials(InputStream is) {
	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        CSVParser csvParser = new CSVParser(fileReader,
	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

	      List<BeforeTvDashboard> developerTutorialList = new ArrayList<>();

	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

	      
	      
	      for (CSVRecord csvRecord : csvRecords) {
	    	  BeforeTvDashboard developerTutorial = new BeforeTvDashboard(
//	    			  	Long.parseLong(csvRecord.get("id")),
//	    			  	csvRecord.get("ShowID"),
//		        		csvRecord.get("ShowName"),
//		        		Integer.parseInt(csvRecord.get("ShowStartTime")),
//		        		Integer.parseInt(csvRecord.get("ShowEndTime")),
//		        		Integer.parseInt(csvRecord.get("STATUS")),
//		        		csvRecord.get("SeasonID"),
//		        		csvRecord.get("DayApplicable")
	    			  
		        		Long.parseLong(csvRecord.get("id")),
		        		Integer.parseInt(csvRecord.get("position")),
		        		csvRecord.get("ShowID"),
		        		csvRecord.get("ShowName"),
		        		Integer.parseInt(csvRecord.get("ShowStartTime")),
		        		Integer.parseInt(csvRecord.get("ShowEndTime")),
		        		csvRecord.get("DayApplicable"),
		        		Integer.parseInt(csvRecord.get("STATUS")),
		        		csvRecord.get("SeasonID")
		        		
		        		
		        		
	            );

	    	  developerTutorialList.add(developerTutorial);
	      }

	      return developerTutorialList;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	  }

	  public static ByteArrayInputStream tutorialsToCSV(List<BeforeTvDashboard> developerTutorialList) {
	    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

	    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
	        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
	      for (BeforeTvDashboard developerTutorial : developerTutorialList) {
	        List<String> data = Arrays.asList(
	              String.valueOf(developerTutorial.getId()),
	              developerTutorial.getShowID(),
	              developerTutorial.getShowName(),
	              String.valueOf(developerTutorial.getShowStartTime()),
	              String.valueOf(developerTutorial.getShowEndTime()),
	              String.valueOf(developerTutorial.getSTATUS()),
	              developerTutorial.getSeasonID(),
	              developerTutorial.getDayApplicable()
	              
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
