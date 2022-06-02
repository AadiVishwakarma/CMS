package com.zee.zee5Dashboard.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import com.zee.zee5Dashboard.entity.WeeklyWebisodeConfiguration;



@Repository



public interface WeeklyWebisodeConfigurationRepository extends JpaRepository<WeeklyWebisodeConfiguration, Long> {



}