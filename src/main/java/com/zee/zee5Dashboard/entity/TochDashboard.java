package com.zee.zee5Dashboard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter


@Entity
@Table(name = "tochdashboard")
public class TochDashboard {
	
	public TochDashboard(long id, String showName, String channel, String ftpFolder, String language, String webRequest,
			String bestSceneRequest, String performanceRequest) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.showName= showName;
		this.channel = channel;
		this.ftpFolder = ftpFolder;
		this.language = language;
		this.webRequest = webRequest;
		this.bestSceneRequest = bestSceneRequest;
		this.performanceRequest = performanceRequest;
		
	}

	public TochDashboard() {
		// TODO Auto-generated constructor stub
	}

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
	
	Integer position;
	
	@Override
	public String toString()
	{
		return "Toch-Dashboard [id="+ id +", showName = "+ showName +", channel = "+ channel +", ftpFolder = "+ ftpFolder +", language = "+ language +", webRequest = "+ webRequest +", showName = "+ bestSceneRequest +", performanceRequest = "+ performanceRequest +" ]";
	}
}
