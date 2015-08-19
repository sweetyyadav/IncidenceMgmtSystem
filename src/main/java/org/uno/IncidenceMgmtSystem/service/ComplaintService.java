package org.uno.IncidenceMgmtSystem.service;

import java.util.List;

import org.uno.IncidenceMgmtSystem.model.Complaint;
import org.uno.IncidenceMgmtSystem.model.ComplaintForm;
import org.uno.IncidenceMgmtSystem.model.ComplaintType;
import org.uno.IncidenceMgmtSystem.model.TenantDetails;

public interface ComplaintService {

	public Integer saveComplaint(ComplaintForm form) throws Exception;
	public List<ComplaintType> findComplaintTypeList() throws Exception; 
	public TenantDetails findTenantDetails(Integer userId) throws Exception;
	List<Complaint> findComplaintList(Integer userId) throws Exception; 
	ComplaintForm findeComplaint(Integer complaintId) throws Exception;
	public void updateComplaint(ComplaintForm form) throws Exception;
}
