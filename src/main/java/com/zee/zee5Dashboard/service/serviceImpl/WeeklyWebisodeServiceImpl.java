package com.zee.zee5Dashboard.service.serviceImpl;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5Dashboard.entity.WeeklyWebisode;
import com.zee.zee5Dashboard.repository.WeeklyWebisodeRepository;
import com.zee.zee5Dashboard.service.WeeklyWebisodeService;



@Service
public class WeeklyWebisodeServiceImpl implements WeeklyWebisodeService{

@Autowired
private WeeklyWebisodeRepository weeklyWebisodeRepository;

@Override
public List<WeeklyWebisode> getAllWebisodes() {
// TODO Auto-generated method stub
return weeklyWebisodeRepository.findAll();
}


public WeeklyWebisode saveUser(WeeklyWebisode weeklyWebisode) {
// TODO Auto-generated method stub
return weeklyWebisodeRepository.save(weeklyWebisode);
}




// @Override
// public WeeklyWebisodeService saveUser(WeeklyWebisodeService weeklyWebisodeService) {
// // TODO Auto-generated method stub
// return null;
// }




}