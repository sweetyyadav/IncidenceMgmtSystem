package org.uno.IncidenceMgmtSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name="complaint")
public class Complaint {

	@Id
	@GeneratedValue
	@Column(name="complaint_id")
	private Integer complaintId;
	
	@JoinColumn(name="complaint_type_id",referencedColumnName="complaint_type_id")
	@ManyToOne
	private ComplaintType  complaintType;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="tenant_details_id")
	private Integer tenantDetailsId;
	
	@Column(name="complaint_description")
	private String complaintDescription;
	
	@Column(name="phone_no")
	private Integer phoneNo;
	
	@Column(name="avialability_time")
	private String avialabilityTime;

	public Integer getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(Integer complaintId) {
		this.complaintId = complaintId;
	}
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTenantDetailsId() {
		return tenantDetailsId;
	}

	public void setTenantDetailsId(Integer tenantDetailsId) {
		this.tenantDetailsId = tenantDetailsId;
	}

	public String getComplaintDescription() {
		return complaintDescription;
	}

	public void setComplaintDescription(String complaintDescription) {
		this.complaintDescription = complaintDescription;
	}

	public Integer getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAvialabilityTime() {
		return avialabilityTime;
	}

	public void setAvialabilityTime(String avialabilityTime) {
		this.avialabilityTime = avialabilityTime;
	}

	public ComplaintType getComplaintType() {
		return complaintType;
	}
	public void setComplaintType(ComplaintType complaintType) {
		this.complaintType = complaintType;
	}
	
	
}
