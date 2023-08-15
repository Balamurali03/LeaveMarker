package com.project.leaveForm.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.leaveForm.Entity.EmployeeEntity;
import com.project.leaveForm.Repo.EmployeeRepo;
import com.project.leaveForm.Response.EmployeeResponse;
import com.project.leaveForm.Service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	 @Autowired
	 private EmployeeRepo employeeRepo;
	 
	@Override
	public String saveEmployeeData(EmployeeResponse employee) {
		
		EmployeeEntity employeeDataCheck=employeeRepo.findById(employee.getEmpId()).get();
		if(employeeDataCheck == null) {
			EmployeeEntity employeeData= new EmployeeEntity();
			employeeData.setId(employee.getId());
			employeeData.setEmpId(employee.getEmpId());
			employeeData.setEmpName(employee.getEmpName());
			employeeData.setAge(employee.getAge());
			employeeData.setMailId(employee.getMailId());
			employeeRepo.save(employeeData);
			return "Employee Details Stored Sucessfully";
		} else {
			return null;
			
		}
	}

	@Override
	public String updateEmployeeData(EmployeeResponse employee) {
		
        EmployeeEntity employeeData=employeeRepo.findById(employee.getEmpId()).get();
		if(employeeData !=null) {
			
			employeeData.setId(employee.getId());
			employeeData.setEmpId(employee.getEmpId());
			employeeData.setEmpName(employee.getEmpName());
			employeeData.setAge(employee.getAge());
			employeeData.setMailId(employee.getMailId());
			employeeRepo.save(employeeData);
			return "Employee Details Updated Sucessfully";
		} else {
			return null;
			
		}
	}

	@Override
	public String deleteEmployeeData(int empId) {
		EmployeeEntity employeeData=employeeRepo.findById(empId).get();
		if(employeeData !=null) {
			employeeRepo.delete(employeeData);
			return "Employee Details Deleted Sucessfully";
		} else {
			
			return null;
			
		}
	}

	@Override
	public EmployeeResponse getEmployeeData(int empId) {
		EmployeeEntity employeeData=employeeRepo.findById(empId).get();
		if(employeeData !=null) {
			EmployeeResponse employeeResponse= new EmployeeResponse();
			employeeResponse.setId(employeeData.getId());
			employeeResponse.setEmpId(employeeData.getEmpId());
			employeeResponse.setEmpName(employeeData.getEmpName());
			employeeResponse.setAge(employeeData.getAge());
			employeeResponse.setMailId(employeeData.getMailId());
			return employeeResponse;
		} else {
			
			return null;
		}
	}

	@Override
	public List<EmployeeResponse> getAllEmployeeData() {
		
		List<EmployeeResponse> employeeResponseList= new ArrayList<EmployeeResponse>();
		List<EmployeeEntity> employeeList= employeeRepo.findAll();
		if(employeeList.size()>0) {
			for (EmployeeEntity employee : employeeList) {
				
				EmployeeResponse employeeResponse= new EmployeeResponse();
				employeeResponse.setId(employee.getId());
				employeeResponse.setEmpId(employee.getEmpId());
				employeeResponse.setEmpName(employee.getEmpName());
				employeeResponse.setAge(employee.getAge());
				employeeResponse.setMailId(employee.getMailId());
				
				employeeResponseList.add(employeeResponse);
			}
			return employeeResponseList;
		} else {
			
			return null;
		}
	}

	
}
