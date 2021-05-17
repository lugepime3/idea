package com.idea.entities.services;

import java.util.List;

import com.idea.entities.Department;

public interface IDepartmentService {
	Department createDepartment(Department department);

	Department updateDepartment(Department department, Integer departmentId);

	void deleteDepartment(Integer departmentId);

	List<Department> getAllDepartments();

	Department getDepartment(Integer departmentId);

}
