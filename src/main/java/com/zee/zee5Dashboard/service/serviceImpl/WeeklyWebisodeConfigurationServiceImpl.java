package com.zee.zee5Dashboard.service.serviceImpl;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.zee.zee5Dashboard.entity.WeeklyWebisode;
import com.zee.zee5Dashboard.entity.WeeklyWebisodeConfiguration;
import com.zee.zee5Dashboard.repository.WeeklyWebisodeConfigurationRepository;
import com.zee.zee5Dashboard.service.WeeklyWebisodeConfigurationService;
@Service



public class WeeklyWebisodeConfigurationServiceImpl implements WeeklyWebisodeConfigurationService{

@Autowired
private WeeklyWebisodeConfigurationRepository weeklyWebisodeConfigurationRepository;

@Override
public List<WeeklyWebisodeConfiguration> getAllWebisodesConfiguration() {
// TODO Auto-generated method stub
return weeklyWebisodeConfigurationRepository.findAll();
}

public WeeklyWebisodeConfiguration saveUser(WeeklyWebisodeConfiguration weeklyWebisodeConfiguration) {
// TODO Auto-generated method stub
return weeklyWebisodeConfigurationRepository.save(weeklyWebisodeConfiguration);
}



}