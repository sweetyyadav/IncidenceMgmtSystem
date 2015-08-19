package org.uno.IncidenceMgmtSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uno.IncidenceMgmtSystem.model.Complaint;
import org.uno.IncidenceMgmtSystem.model.ComplaintForm;
import org.uno.IncidenceMgmtSystem.model.ComplaintType;
import org.uno.IncidenceMgmtSystem.model.TenantDetails;
import org.uno.IncidenceMgmtSystem.repository.ComplaintRepository;
import org.uno.IncidenceMgmtSystem.repository.ComplaintTypeRepository;

@Service("complaintService")
public class ComplaintServiceImpl implements ComplaintService{

	@Autowired
	private ComplaintTypeRepository complaintTypeRepository;
	
	@Autowired
	private ComplaintRepository complaintRepository;


	/**
	 * This is invoked when a user tries to save a complaint.
	 * This interacts with the user Repositoy which uses JPA to interact with the database.
	 * @param form
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public Integer saveComplaint(ComplaintForm form) throws Exception {
		
		Complaint complaint = new Complaint();
		complaint.setAvialabilityTime(form.getDateTime());
		complaint.setComplaintDescription(form.getComplaintDescription());
		ComplaintType type = new ComplaintType();
		type.setComplaintTypeId(form.getComplaintTypeId());
		complaint.setComplaintType(type);
		complaint.setTenantDetailsId(form.getTenantDetailsId());
		complaint.setUserId(form.getUserId());
		complaint.setPhoneNo(form.getPhoneNo());
		
		Complaint complaints=complaintRepository.save(complaint);
		return complaints.getComplaintId();
	}

	/**
	 * Finds the list of complaints type
	 * @return
	 * @throws Exception
	 */
	public List<ComplaintType> findComplaintTypeList() throws Exception {
		return complaintTypeRepository.findComplaintTypeList();
	}

	/**
	 * Finds TENANT details
	 * @param userId
	 * @return ß
	 * @throws Exception
	 */
	public TenantDetails findTenantDetails(Integer userId) throws Exception {
		return complaintTypeRepository.findTenantDetails(userId);
	}

	/**
	 * Find the list of complaints
	 * @param userId
	 * @return Tenant Details
	 * @throws Exception
	 */
	public List<Complaint> findComplaintList(Integer userId) throws Exception {
		
		return complaintRepository.findComplaintList(userId);
	}

	/**
	 * Find a complaint when a complaint id is available
	 * @param complaintId
	 * @return Complaintform
	 * @throws Exception
	 */
	public ComplaintForm findeComplaint(Integer complaintId) throws Exception {
		
		Complaint complaint = complaintRepository.findeComplaint(complaintId);
		
		ComplaintForm  form = new ComplaintForm();
		form.setComplaintDescription(complaint.getComplaintDescription());
		form.setComplaintTypeId(complaint.getComplaintType().getComplaintTypeId());
		form.setDateTime(complaint.getAvialabilityTime());
		form.setPhoneNo(complaint.getPhoneNo());
		form.setTenantDetailsId(complaint.getTenantDetailsId());
		form.setId(complaint.getComplaintId());
		return form;
	}


	/**
	 * Updates the complaint
	 * @param form
	 * @throws Exception
	 */
	public void updateComplaint(ComplaintForm form) throws Exception {
		
		Complaint complaint = new Complaint();
		complaint.setComplaintId(form.getId());
		complaint.setAvialabilityTime(form.getDateTime());
		complaint.setComplaintDescription(form.getComplaintDescription());
		ComplaintType type = new ComplaintType();
		type.setComplaintTypeId(form.getComplaintTypeId());
		complaint.setComplaintType(type);
		complaint.setTenantDetailsId(form.getTenantDetailsId());
		complaint.setUserId(form.getUserId());
		complaint.setPhoneNo(form.getPhoneNo());
		
		complaintRepository.save(complaint);
	}

}
