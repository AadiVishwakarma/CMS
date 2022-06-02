package com.zee.zee5Dashboard.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;



import lombok.Data;



@Table(name="weekly_webisode_configuration")
@Entity
@Data



public class WeeklyWebisodeConfiguration {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
Long id;


@Transient
Integer Position;

@NotBlank
String ChannelName;

@NotBlank
String InoutAssetTitle;

@NotBlank
String LanguageCode;

@NotBlank
Integer AssetCount;

@NotBlank
String ProcessingDay;

@NotBlank
String ProcessingStartTime;

@NotBlank
Integer LookupDays;

String Processed;










}