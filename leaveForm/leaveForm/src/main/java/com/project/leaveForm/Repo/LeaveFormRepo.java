package com.project.leaveForm.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.leaveForm.Entity.LeaveFormEntity;

public interface LeaveFormRepo extends JpaRepository <LeaveFormEntity,Integer>{

	@Query(value = "SELECT * FROM leave_form_entity  WHERE emp_id = :empId", nativeQuery = true)
	public List<LeaveFormEntity> findAllByEmpId(int empId);
}
