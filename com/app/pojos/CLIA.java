package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="clia")
public class CLIA 
{
	private Integer cId;
	private String fName,mName,lName;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dob;
	private String gender;
	private String mStatus;
	private String phNumber;
	private String email,position;
	private String adharId,pancardId;
	private String qualDetails;
	private Byte photo;
	private Integer noOfAgents;
	
	
	public CLIA() 
	{
	System.out.println("In CLIA ctor");
	}
	

	public CLIA(Integer cid, String fName, String mName, String lName, Date dob, String gender, String mStatus,
			String phNumber, String email, String position, String adharId, String pancardId, String qualDetails,
			Byte photo, Integer noOfAgents) 
	{
		super();
		cId = cid;
		this.fName = fName;
		this.mName = mName;
		this.lName = lName;
		this.dob = dob;
		this.gender = gender;
		this.mStatus = mStatus;
		this.phNumber = phNumber;
		this.email = email;
		this.position = position;
		this.adharId = adharId;
		this.pancardId = pancardId;
		this.qualDetails = qualDetails;
		this.photo = photo;
		this.noOfAgents = noOfAgents;
	}
		
	@Id
	@Column(name="cId")
	public Integer getId() {
		return cId;
	}

	public void setId(Integer cid) {
		cId = cid;
	}

	@Column(name="fName",length=20)
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	@Column(name="mName",length=20)
	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	@Column(name="lName",length=20)
	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="birth_date")
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name="gender",length=20)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name="mStatus",length=20)
	public String getmStatus() {
		return mStatus;
	}

	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}

	@Column(name="phNumber",length=20)
	public String getPhNumber() {
		return phNumber;
	}

	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}
		
	@Column(name="email",length=20,unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="position",length=20)
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Column(name="adharId",length=20)
	public String getAdharId() {
		return adharId;
	}

	public void setAdharId(String adharId) {
		this.adharId = adharId;
	}

	@Column(name="pancardId",length=20)
	public String getPancardId() {
		return pancardId;
	}

	public void setPancardId(String pancardId) {
		this.pancardId = pancardId;
	}

	@Column(name="qualDetails",length=20)
	public String getQualDetails() {
		return qualDetails;
	}

	public void setQualDetails(String qualDetails) {
		this.qualDetails = qualDetails;
	}

	@Column(name="photo",length=20)
	public Byte getPhoto() {
		return photo;
	}

	public void setPhoto(Byte photo) {
		this.photo = photo;
	}

	@Column(name="noOfAgents",length=20)
	public Integer getNoOfAgents() {
		return noOfAgents;
	}

	public void setNoOfAgents(Integer noOfAgents) {
		this.noOfAgents = noOfAgents;
	}


	@Override
	public String toString()
	{
		return "CLIA [cId=" + cId + ", fName=" + fName + ", mName=" + mName + ", lName=" + lName + ", dob=" + dob
				+ ", gender=" + gender + ", mStatus=" + mStatus + ", phNumber=" + phNumber + ", email=" + email
				+ ", position=" + position + ", adharId=" + adharId + ", pancardId=" + pancardId + ", qualDetails="
				+ qualDetails + ", photo=" + photo + ", noOfAgents=" + noOfAgents + "]";
	}

	
	
	
}
