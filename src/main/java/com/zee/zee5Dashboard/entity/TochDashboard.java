package com.zee.zee5Dashboard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "tochdashboard")
public class TochDashboard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="Id")
	private Long id;
	
	
	@Column(name ="ShowName")
	private String showName;
	
	@Column(name ="Channel")
	private String channel;
	
	@Column(name ="FTP_Folder")
	private String ftpFolder;
	
	@Column(name ="Language")
	private String language;
	
	@Column(name ="Web_Request")
	private String webRequest;
	
	@Column(name ="Best_Scene_Request")
	private String bestSceneRequest;
	
	@Column(name ="Performance_Request")
	private String performanceRequest;
}
