package org.uno.IncidenceMgmtSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tenant_details")
public class TenantDetails {

	
	@Id
	@GeneratedValue
	@Column(name="tenant_details_id")
	private Integer tenantDetailsId;
	
	@Column(name="tenant_name")
	private String tenantName;
	
	@Column(name="apartment_no")
	private Integer apartmentNo;
	
	@Column(name="user_id")
	private Integer userId;

	public Integer getTenantDetailsId() {
		return tenantDetailsId;
	}

	public void setTenantDetailsId(Integer tenantDetailsId) {
		this.tenantDetailsId = tenantDetailsId;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public Integer getApartmentNo() {
		return apartmentNo;
	}

	public void setApartmentNo(Integer apartmentNo) {
		this.apartmentNo = apartmentNo;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
