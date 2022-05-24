package com.zee.zee5Dashboard.service;

import java.util.List;

import com.zee.zee5Dashboard.entity.TochDashboard;


public interface TochDashboardService {

	List<TochDashboard> getAllShows();
	TochDashboard saveShow(TochDashboard tochdashboard);
	TochDashboard getShowById(long id);
	
	TochDashboard showUpdate(TochDashboard tochdashboard);
	
	void deleteShowById(long id);
}
