package com.zee.zee5Dashboard.service;

import java.util.List;

import com.zee.zee5Dashboard.entity.BeforeTVFilter;

public interface BeforeTvFilterService {

	List<BeforeTVFilter> getAllShows();
	BeforeTVFilter getShowById(Long id);
	BeforeTVFilter updateShow(BeforeTVFilter existingShow);
}
