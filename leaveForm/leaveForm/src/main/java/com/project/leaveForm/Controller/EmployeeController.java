package com.project.leaveForm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.leaveForm.Response.EmployeeResponse;
import com.project.leaveForm.ServiceImpl.EmployeeServiceImpl;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@PostMapping("/save-employee-detail")
	public ResponseEntity<String> saveEmployeeData (@RequestBody EmployeeResponse employee) {
		
		String value = employeeServiceImpl.saveEmployeeData(employee);
		if(value!=null) {
			return ResponseEntity.ok().body(value);
		}
		
		return ResponseEntity.badRequest().body("Employee Details Already Present For That ID");
	}
	
	@PatchMapping("/update-employee-detail")
	public ResponseEntity<String> updateEmployeeData (@RequestBody EmployeeResponse employee) {
		
		String value = employeeServiceImpl.updateEmployeeData(employee);
		if(value!=null) {
			return ResponseEntity.ok().body(value);
		}
		
		return ResponseEntity.badRequest().body( "No Employee Detail Present In That Id");
	}
	
	@DeleteMapping("/delete-employee-detail/{empId}")
	public ResponseEntity<String> deleteEmployeeData (@PathVariable int empId) {
		
		String value = employeeServiceImpl.deleteEmployeeData(empId);
		if(value!=null) {
			return ResponseEntity.ok().body(value);
		}
		
		return ResponseEntity.badRequest().body("No Employee Detail Present In That Id");
	}
	
	@GetMapping("/get-employee-detail/{empId}")
	public ResponseEntity<?> getEmployeeData (@PathVariable int empId) {
		
		EmployeeResponse value = employeeServiceImpl.getEmployeeData(empId);
		if(value!=null) {
			return ResponseEntity.ok().body(value);
		}
		
		return ResponseEntity.badRequest().body("No Employee Detail Present In That Id");
	}
	
	@GetMapping("/get-all-employee-detail")
	public ResponseEntity<?> getAllEmployeeData () {
		
		List<EmployeeResponse> value = employeeServiceImpl.getAllEmployeeData();
		if(value!=null) {
			return ResponseEntity.ok().body(value);
		}
		
		return ResponseEntity.badRequest().body("No Data Present");
	}

}
