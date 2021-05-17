package com.idea.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.idea.entities.Department;

public interface IDepartmentController {

	ResponseEntity<String> getDepartment(Integer id);

	List<Department> getAllDepartments();

	ResponseEntity<String> addDepartment(Department department);

	ResponseEntity<String> updDepartment(Department department, Integer id);

	ResponseEntity<String> delDepartment(Integer id);

}
