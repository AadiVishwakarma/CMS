package com.zee.zee5Dashboard.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5Dashboard.entity.BeforeTVFilter;
import com.zee.zee5Dashboard.repository.BeforeTvFilterRepository;
import com.zee.zee5Dashboard.service.BeforeTvFilterService;

@Service
public class BeforeTvFilterServiceImpl implements BeforeTvFilterService{

	@Autowired
	private BeforeTvFilterRepository beforetvfilterRepository;
	
	@Override
	public List<BeforeTVFilter> getAllShows() {
		// TODO Auto-generated method stub
		return beforetvfilterRepository.findAll();
	}

	@Override
	public BeforeTVFilter getShowById(Long id) {
		// TODO Auto-generated method stub
		return beforetvfilterRepository.findById(id).get();
	}

	@Override
	public BeforeTVFilter updateShow(BeforeTVFilter existingShow) {
		// TODO Auto-generated method stub
		return beforetvfilterRepository.save(existingShow);	
	}
	
	@Override
	public void deleteShowById(Long id) {
		beforetvfilterRepository.deleteById(id);
	}

}
