package org.uno.IncidenceMgmtSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.uno.IncidenceMgmtSystem.model.ComplaintType;
import org.uno.IncidenceMgmtSystem.model.TenantDetails;

@Repository("complaintTypeRepository")
public interface ComplaintTypeRepository extends JpaRepository<ComplaintType, Integer>{
	
	@Query("FROM ComplaintType ")
	List<ComplaintType> findComplaintTypeList();
	
	@Query("select s from TenantDetails s where s.userId = :userId")
	public TenantDetails findTenantDetails(@Param("userId") Integer userId);
	

}
