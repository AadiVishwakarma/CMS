package com.zee.zee5Dashboard.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zee.zee5Dashboard.entity.BeforeTvDashboard;

public interface BeforeTvDashboardService {

	List<BeforeTvDashboard> getAllShows();
	Page<BeforeTvDashboard> getAllShowsByPage(int page, int size);
	BeforeTvDashboard saveShow(BeforeTvDashboard show);
	BeforeTvDashboard getShowById(Long id);
	BeforeTvDashboard updateShow(BeforeTvDashboard show);
	void deleteShowById(Long id);
//	public List<BeforeTvDashboard> findByKeyword(String keyword);
}
