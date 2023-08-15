package com.project.leaveForm.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class LeaveFormEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int empId;
	private String empName;
	private String startDate;
	private String endDate;
	private String leaveType;
	private String reason;

}
