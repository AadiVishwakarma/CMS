package com.zee.zee5Dashboard.service.serviceImpl;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zee.zee5Dashboard.entity.BeforeTvDashboard;
import com.zee.zee5Dashboard.service.BeforeTvDashboardCsvExportService;

@Service
public class BeforeTvDashboardCsvExportServiceImpl implements BeforeTvDashboardCsvExportService {

	@Override
	public void downloadCsvFile(PrintWriter printWriter, List<BeforeTvDashboard> beforetvdashboard) {
		// TODO Auto-generated method stub
		
		printWriter.write("id, showID, showName,ShowStartTime,SHowEndTime,STATUS,SeasonId,Days_Applicable\n");
		for(BeforeTvDashboard dashboard1: beforetvdashboard )
			printWriter.write(dashboard1.getId()+","+dashboard1.getShowID()+","+dashboard1.getShowName()+","+dashboard1.getShowStartTime()+","+dashboard1.getShowEndTime()+","+dashboard1.getSTATUS()+","+dashboard1.getSTATUS()+dashboard1.getSeasonID()+","+dashboard1.getDayApplicable()+"\n");
		
	}

}
