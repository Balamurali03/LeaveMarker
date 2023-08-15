package com.project.leaveForm.Service;

import java.util.List;

import com.project.leaveForm.Response.LeaveFormResponse;

public interface LeaveFormService {

	
	String grantLeave(LeaveFormResponse leaveForm);
	List<LeaveFormResponse> getAllLeaveListById(int empId);
	List<LeaveFormResponse> getAllLeaveList();
	
}
