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



@Table(name="weekly_webisode_summary")
@Entity
@Data



public class WeeklyWebisode {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Long id;

@Transient
Integer position;

@NotBlank
String ChannelName;

@NotBlank
String ShowName;

@NotBlank
String StartDay;

@NotNull
String StartDate;

@NotNull
String StartTime;

@NotBlank
String Language;

@NotNull
Integer WebisodeCount;

@NotNull
String ModifiedDate;


String VSTStatus;


String VSTUrl;

public WeeklyWebisode()
{
	
}

public WeeklyWebisode(long id, String ChannelName, String ShowName, String StartDay, String StartDate, String StartTime, String Language, 
   Integer WebisodeCount, String ModifiedDate, String VSTStatus, String VSTUrl )
{
	this.id = id;
	this.ChannelName = ChannelName;
	this.ShowName = ShowName;
	this.StartDay = StartDay;
	this.StartDate = StartDate;
	this.StartTime = StartTime;
	this.Language = Language;
	this.WebisodeCount = WebisodeCount;
	this.ModifiedDate = ModifiedDate;
	this.VSTStatus = VSTStatus;
	this.VSTUrl = VSTUrl;
}


}