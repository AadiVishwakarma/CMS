package com.zee.zee5Dashboard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Table(name = "beforetvdashboard")
@Entity
@Data  // to use lombok
public class BeforeTvDashboard {
	
	
	
	@Id
    @Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Transient
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
  
 // String Toch;
  
//  public BeforeTvDashboard()
//  {
//	   
//  }
  
 
//   public BeforeTvDashboard(String id, String ShowID, String ShowName, Integer ShowStartTime, Integer ShowEndTime, Integer STATUS, String SeasonID, String DayApplicable)
//   {
//	   this.id= id;
//	   this.ShowID = ShowID;
//	   this.ShowName = ShowName;
//	   this.ShowStartTime = ShowStartTime;
//	   this.ShowEndTime = ShowEndTime;
//	   this.STATUS = STATUS;
//	   this.SeasonID = SeasonID;
//	   this.DayApplicable = DayApplicable;
//   }
   
   @Override
	public String toString()
	{
		return "BeforeTvDashboard [id="+ id +", ShowName = "+ ShowName +", ShowStartTime = "+ ShowStartTime +", ShowEndTime = "+ ShowEndTime +", STATUS = "+ STATUS +", SeasonID = "+ SeasonID +", DayApplicable = "+ DayApplicable +" ]";
	}
  
   public boolean sameAs(BeforeTvDashboard otherShow) {
	    return this.ShowID.equals(otherShow.ShowID)
	      && this.ShowName.equals(otherShow.ShowName)
	      && this.ShowStartTime.equals(otherShow.ShowStartTime)
	      && this.ShowEndTime.equals(otherShow.ShowEndTime)
	      && this.STATUS.equals(otherShow.STATUS)
	      && this.SeasonID.equals(otherShow.SeasonID);
	  }
}
