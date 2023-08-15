package com.project.leaveForm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.leaveForm.Response.LeaveFormResponse;
import com.project.leaveForm.ServiceImpl.LeaveFormServiceImpl;

@RestController
public class LeaveFormController {
	
	@Autowired
	private LeaveFormServiceImpl leaveFormServiceImpl;
	
	@PostMapping("/apply-for-leave")
	public ResponseEntity<String> applyForLeave(@RequestBody LeaveFormResponse leaveForm) {
		
		String value =leaveFormServiceImpl.grantLeave(leaveForm);
		
		if(value !=null) {
			
			return ResponseEntity.ok().body(value);
		}
		return ResponseEntity.badRequest().body("Not Granted");
	}
	
	@GetMapping("/get-list-of-leave/{empId}")
	public ResponseEntity<?> getListById(@PathVariable int empId) {
		
		List <LeaveFormResponse> listById =leaveFormServiceImpl.getAllLeaveListById(empId);
		if(listById !=null) {
			return ResponseEntity.ok().body(listById);
		}
		else {
			return ResponseEntity.ok().body("No Previous Record");
		}
		
	}
	
	@GetMapping("/get-all-list-of-leave")
	public ResponseEntity<?> getAllListById() {
		
		List <LeaveFormResponse> listById =leaveFormServiceImpl.getAllLeaveList();
		if(listById !=null) {
			return ResponseEntity.ok().body(listById);
		}
		else {
			return ResponseEntity.ok().body("No  Record To Show");
		}
		
	}

}
