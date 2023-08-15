package com.project.leaveForm.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.leaveForm.Entity.LeaveFormEntity;
import com.project.leaveForm.Repo.LeaveFormRepo;
import com.project.leaveForm.Response.LeaveFormResponse;
import com.project.leaveForm.Service.LeaveFormService;

@Service
public class LeaveFormServiceImpl implements LeaveFormService {

	@Autowired
	private LeaveFormRepo leaveFormRepo;

	@Override
	public String grantLeave(LeaveFormResponse leaveForm) {

		LeaveFormEntity form = new LeaveFormEntity();

		form.setId(leaveForm.getId());
		form.setEmpId(leaveForm.getEmpId());
		form.setEmpName(leaveForm.getEmpName());
		form.setStartDate(leaveForm.getStartDate());
		form.setEndDate(leaveForm.getEndDate());
		form.setLeaveType(leaveForm.getLeaveType());
		form.setReason(leaveForm.getReason());

		leaveFormRepo.save(form);
		return "Leave Applied Sucessfully";
	}

	@Override
	public List<LeaveFormResponse> getAllLeaveListById(int empId) {
		List<LeaveFormResponse> leaveResponseListById = new ArrayList<LeaveFormResponse>();

		List<LeaveFormEntity> leaveFormListById = leaveFormRepo.findAllByEmpId(empId);
		if (leaveFormListById.size() > 0) {
			for (LeaveFormEntity leaveForm : leaveFormListById) {

				LeaveFormResponse form = new LeaveFormResponse();

				form.setId(leaveForm.getId());
				form.setEmpId(leaveForm.getEmpId());
				form.setEmpName(leaveForm.getEmpName());
				form.setStartDate(leaveForm.getStartDate());
				form.setEndDate(leaveForm.getEndDate());
				form.setLeaveType(leaveForm.getLeaveType());
				form.setReason(leaveForm.getReason());

				leaveResponseListById.add(form);

			}
			return leaveResponseListById;
		} else {

			return null;
		}
	}

	@Override
	public List<LeaveFormResponse> getAllLeaveList() {
		List<LeaveFormResponse> leaveResponseList = new ArrayList<LeaveFormResponse>();

		List<LeaveFormEntity> leaveFormList = leaveFormRepo.findAll();
		if (leaveFormList.size() > 0) {
			for (LeaveFormEntity leaveForm : leaveFormList) {

				LeaveFormResponse form = new LeaveFormResponse();

				form.setId(leaveForm.getId());
				form.setEmpId(leaveForm.getEmpId());
				form.setEmpName(leaveForm.getEmpName());
				form.setStartDate(leaveForm.getStartDate());
				form.setEndDate(leaveForm.getEndDate());
				form.setLeaveType(leaveForm.getLeaveType());
				form.setReason(leaveForm.getReason());

				leaveResponseList.add(form);

			}
			return leaveResponseList;
		} else {

			return null;
		}
	}

}
