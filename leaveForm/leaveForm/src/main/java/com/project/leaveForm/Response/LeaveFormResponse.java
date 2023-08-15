package com.project.leaveForm.Response;

import lombok.Data;

@Data
public class LeaveFormResponse {

	private int id;
	private int empId;
	private String empName;
	private String startDate;
	private String endDate;
	private String leaveType;
	private String reason;

}
