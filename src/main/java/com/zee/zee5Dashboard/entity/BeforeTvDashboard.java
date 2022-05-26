package com.zee.zee5Dashboard.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Table(name = "beforetvdashboard")
@Entity
@Data  // to use lombok
public class BeforeTvDashboard {

	@Id
//  @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	Integer position;

  @NotBlank
	String ShowID;
  
  @NotBlank
	String ShowName;

  @NotNull
  Integer ShowStartTime;

  @NotNull
  Integer ShowEndTime;

  @NotBlank
  String DayApplicable;

  @NotNull
  Integer STATUS;

  @NotBlank
  String SeasonID;
  
  String Toch;
}
