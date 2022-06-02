package com.zee.zee5Dashboard.service;



import java.util.List;



import com.zee.zee5Dashboard.entity.WeeklyWebisode;
import com.zee.zee5Dashboard.entity.WeeklyWebisodeConfiguration;



public interface WeeklyWebisodeConfigurationService {

List<WeeklyWebisodeConfiguration> getAllWebisodesConfiguration();

WeeklyWebisodeConfiguration saveUser(WeeklyWebisodeConfiguration weeklyWebisodeConfiguration);



}