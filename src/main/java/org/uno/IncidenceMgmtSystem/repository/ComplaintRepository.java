package org.uno.IncidenceMgmtSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.uno.IncidenceMgmtSystem.model.Complaint;

/**
 *
 */
@Repository("complaintRepository")
public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{
	
	@Query("SELECT c FROM Complaint c INNER JOIN FETCH c.complaintType WHERE c.userId=:userId")
	List<Complaint> findComplaintList(@Param("userId") Integer userId);
	
	@Query("SELECT c FROM Complaint c INNER JOIN FETCH c.complaintType WHERE c.complaintId=:complaintId ")
	Complaint findeComplaint(@Param("complaintId") Integer complaintId);

}
