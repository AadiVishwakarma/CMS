package com.zee.zee5Dashboard.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Table(name = "beforetvfilter")
@Entity
@Data 
public class BeforeTVFilter {
	
	@Id
//  @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@NotBlank
	String ShowName;
	@NotBlank
	String EpisodeId;
	@NotBlank
	String IndexNo;
	@NotBlank
	String ReleaseDate;
	@NotBlank
	String Language;
	@NotNull
	Integer StartTime;
	@NotNull
	Integer EndTime;
	@NotBlank
	String TvShowID;
//	@NotBlank
//	String Action;
	@NotBlank
	String SVODRemarks;
	@NotBlank
	String SVODStatus;
	@NotBlank
	String AVODRemarks;
	@NotBlank
	String AVODStatus;
	@NotBlank
	String Source;
	@NotBlank
	String AddedOn;
	@NotBlank
	String PremiumOnZee5;
	@NotBlank
	String FreeOnZee5;
	@Transient
	Integer position;
}
