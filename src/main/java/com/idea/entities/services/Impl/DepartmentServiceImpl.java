package com.idea.entities.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.idea.entities.Department;
import com.idea.entities.services.IDepartmentService;
import com.idea.repositories.IDepartmentRepository;

@Service
@Qualifier("DepartmentService")
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	@Qualifier("DepartmentRepository")
	IDepartmentRepository departmentRepository;

	@Override
	public Department createDepartment(Department department) {
		if (!departmentRepository.existsById(department.getDepartmentId())) {
			department = departmentRepository.save(department);
		}
		return department;
	}

	@Override
	public Department updateDepartment(Department department, Integer departmentId) {
		if (departmentRepository.existsById(departmentId)) {
			department.setDepartmentId(departmentId);
			departmentRepository.save(department);
		}
		return department;
	}

	@Override
	public void deleteDepartment(Integer departmentId) {
		if (departmentRepository.existsById(departmentId)) {
			departmentRepository.deleteById(departmentId);
		}

	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartment(Integer departmentId) {
		Department departmentFounded = null;
		Optional<Department> r = departmentRepository.findById(departmentId);
		if (r.isPresent()) {
			departmentFounded = r.get();
		}
		return departmentFounded;
	}

}
