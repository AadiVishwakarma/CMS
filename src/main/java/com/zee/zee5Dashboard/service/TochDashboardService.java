package com.zee.zee5Dashboard.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zee.zee5Dashboard.entity.TochDashboard;


public interface TochDashboardService {

	List<TochDashboard> getAllShows();
	TochDashboard saveShow(TochDashboard tochdashboard);
	TochDashboard getShowById(long id);
	
	TochDashboard showUpdate(TochDashboard tochdashboard);
	
	void deleteShowById(long id);
	Page<TochDashboard> getAllShowsByPage(int page, int size);
}
