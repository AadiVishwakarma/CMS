package com.zee.zee5Dashboard.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zee.zee5Dashboard.entity.BeforeTvDashboard;
import com.zee.zee5Dashboard.repository.BeforeTvDashboardRepository;
import com.zee.zee5Dashboard.service.BeforeTvDashboardService;

@Service
public class BeforeTvDashboardServiceImpl implements BeforeTvDashboardService {

	@Autowired
	private BeforeTvDashboardRepository beforetvdashboardRepository;
	
	
	@Override
	public List<BeforeTvDashboard> getAllShows() {
		// TODO Auto-generated method stub
		return beforetvdashboardRepository.findAll();
	}

	@Override
	public Page<BeforeTvDashboard> getAllShowsByPage(int page, int size) {
		// TODO Auto-generated method stub
		return beforetvdashboardRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public BeforeTvDashboard saveShow(BeforeTvDashboard show) {
		// TODO Auto-generated method stub
		return beforetvdashboardRepository.save(show);
	}

	@Override
	public BeforeTvDashboard getShowById(Long id) {
		// TODO Auto-generated method stub
		return beforetvdashboardRepository.findById(id).get();
	}

	@Override
	public BeforeTvDashboard updateShow(BeforeTvDashboard show) {
		// TODO Auto-generated method stub
		return beforetvdashboardRepository.save(show);
	}

	@Override
	public void deleteShowById(Long id) {
		// TODO Auto-generated method stub
		beforetvdashboardRepository.deleteById(id);
	}

	@Override
	public List<BeforeTvDashboard> getByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return beforetvdashboardRepository.findByKeyword(keyword);
	}

}
