package com.project.leaveForm.Service;

import java.util.List;

import com.project.leaveForm.Response.EmployeeResponse;

public interface EmployeeService {

	 String saveEmployeeData(EmployeeResponse employee);
	 String updateEmployeeData(EmployeeResponse employee);
	 String deleteEmployeeData(int empId);
	 EmployeeResponse getEmployeeData(int empId);
	 List<EmployeeResponse>  getAllEmployeeData();
	
}
