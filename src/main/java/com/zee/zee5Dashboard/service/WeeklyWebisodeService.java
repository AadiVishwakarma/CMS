package com.zee.zee5Dashboard.service;

import java.util.List;
import com.zee.zee5Dashboard.entity.WeeklyWebisode;

public interface WeeklyWebisodeService {
	
	List<WeeklyWebisode> getAllWebisodes();
	WeeklyWebisode saveUser(WeeklyWebisode weeklyWebisode);
}