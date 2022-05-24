package com.zee.zee5Dashboard.service.serviceImpl;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zee.zee5Dashboard.entity.TochDashboard;
import com.zee.zee5Dashboard.service.TochDashboardCsvExportService;

@Service
public class TochDashboardCsvExportServiceImpl implements TochDashboardCsvExportService {

	@Override
	public void downloadCsvFile(PrintWriter printWriter, List<TochDashboard> tochdashboard) {
		// TODO Auto-generated method stub
		
		printWriter.write("id ,showName, channel,ftpFolder,language,webRequest,bestSceneRequest,performanceRequest\n");
		for(TochDashboard dashboard1: tochdashboard )
			printWriter.write(dashboard1.getId()+","+dashboard1.getShowName()+","+dashboard1.getChannel()+","+dashboard1.getFtpFolder()+","+dashboard1.getLanguage()+","+dashboard1.getWebRequest()+","+dashboard1.getBestSceneRequest()+","+dashboard1.getPerformanceRequest()+"\n");
	}

}
