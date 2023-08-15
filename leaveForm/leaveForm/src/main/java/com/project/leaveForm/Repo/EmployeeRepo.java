package com.project.leaveForm.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.leaveForm.Entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository <EmployeeEntity,Integer>{

}
