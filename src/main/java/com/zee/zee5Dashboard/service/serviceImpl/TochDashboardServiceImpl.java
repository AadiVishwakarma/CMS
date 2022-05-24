package com.zee.zee5Dashboard.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5Dashboard.entity.TochDashboard;
import com.zee.zee5Dashboard.repository.TochDashboardRepository;
import com.zee.zee5Dashboard.service.TochDashboardService;

@Service
public class TochDashboardServiceImpl implements TochDashboardService{
	
	@Autowired
	private TochDashboardRepository tochdashboardRepository;
	
	@Override
	public List<TochDashboard> getAllShows() {
		// TODO Auto-generated method stub
		return tochdashboardRepository.findAll();
	}

	@Override
	public TochDashboard saveShow(TochDashboard tochdashboard) {
		// TODO Auto-generated method stub
		return tochdashboardRepository.save(tochdashboard);
	}

	@Override
	public TochDashboard getShowById(long id) {
		// TODO Auto-generated method stub
		Optional<TochDashboard> optional = tochdashboardRepository.findById(id);
		TochDashboard tochdashboard = null;
		
		if(optional.isPresent())
		{
			tochdashboard = optional.get();
		}else
		{
			throw new RuntimeException("SHow does not exist with this ID :"+id);
		}
		return tochdashboard;
	}

	@Override
	public TochDashboard showUpdate(TochDashboard tochdashboard) {
		// TODO Auto-generated method stub
		return tochdashboardRepository.save(tochdashboard);
	}

	@Override
	public void deleteShowById(long id) {
		// TODO Auto-generated method stub
		this.tochdashboardRepository.deleteById(id);
	}

}
