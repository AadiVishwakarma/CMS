package com.zee.zee5Dashboard.service.serviceImpl;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zee.zee5Dashboard.entity.BeforeTVFilter;
import com.zee.zee5Dashboard.entity.BeforeTvDashboard;
import com.zee.zee5Dashboard.service.BeforeTvFilterCsvExportService;

@Service
public class BeforeTvFilterCsvExportServiceImpl implements BeforeTvFilterCsvExportService{

	@Override
	public void downloadCsvFile(PrintWriter printWriter, List<BeforeTVFilter> beforetvfilter) {
		// TODO Auto-generated method stub
		printWriter.write("id, ShowName, EpisodeId, IndexNo,ReleaseDate,Language,StartTime,EndTime, TvShowId,SVODRemarks,SVODStatus,AVODRemarks, AVODStatus, Source, AddedOn, PremiumOnZee5, FreeOnZee5\n");
		for(BeforeTVFilter dashboard1: beforetvfilter )
			printWriter.write(dashboard1.getId()+","+dashboard1.getShowName()+","+dashboard1.getEpisodeId()+","+dashboard1.getIndexNo()+","+dashboard1.getReleaseDate()+","+dashboard1.getLanguage()+","+dashboard1.getStartTime()+dashboard1.getEndTime()+","+dashboard1.getTvShowID()+","+dashboard1.getSVODRemarks()+","
		+dashboard1.getSVODStatus()+","+dashboard1.getAVODRemarks()+","+dashboard1.getAVODStatus()+","+dashboard1.getSource()+","+dashboard1.getAddedOn()+","+dashboard1.getPremiumOnZee5()+","+dashboard1.getFreeOnZee5()+"\n");
	}

}
