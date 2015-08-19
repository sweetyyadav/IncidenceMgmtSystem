package org.uno.IncidenceMgmtSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(name="complaint_type")
public class ComplaintType {

	@Id
	@GeneratedValue
	@Column(name="complaint_type_id")
	private Integer complaintTypeId;
	
	@Column(name="complaint_type_name")
	private String complaintTypeName;

	public Integer getComplaintTypeId() {
		return complaintTypeId;
	}

	public void setComplaintTypeId(Integer complaintTypeId) {
		this.complaintTypeId = complaintTypeId;
	}

	public String getComplaintTypeName() {
		return complaintTypeName;
	}

	public void setComplaintTypeName(String complaintTypeName) {
		this.complaintTypeName = complaintTypeName;
	}
	
	
	
}
