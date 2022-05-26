package com.zee.zee5Dashboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zee.zee5Dashboard.entity.BeforeTvDashboard;

@Repository
public interface BeforeTvDashboardRepository extends JpaRepository<BeforeTvDashboard, Long> {

//	@Query(value = "select * from beforetvdashboard s where s.ShowID like %:keyword% or s.ShowName like %:keyword%", nativeQuery = true)
//	 List<BeforeTvDashboard> findByKeyword(@Param("keyword") String keyword);
	
//	@Query(value="select * from beforetvdashboard where show_name like %:keyword% or id like %:keyword%", nativeQuery = true)
//	List<BeforeTvDashboard> findByKeyword(@Param("keyword") String keyword);
}
