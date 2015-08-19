package org.uno.IncidenceMgmtSystem.model;

/**
 *
 */
public class ComplaintForm {

	private Integer userId;
	private Integer complaintTypeId;
	private String DateTime;
	private String complaintDescription;
	private Integer phoneNo;
	private Integer tenantDetailsId;
	private Integer id;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getComplaintTypeId() {
		return complaintTypeId;
	}
	public void setComplaintTypeId(Integer complaintTypeId) {
		this.complaintTypeId = complaintTypeId;
	}
	public String getDateTime() {
		return DateTime;
	}
	public void setDateTime(String dateTime) {
		DateTime = dateTime;
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
	public Integer getTenantDetailsId() {
		return tenantDetailsId;
	}
	public void setTenantDetailsId(Integer tenantDetailsId) {
		this.tenantDetailsId = tenantDetailsId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
