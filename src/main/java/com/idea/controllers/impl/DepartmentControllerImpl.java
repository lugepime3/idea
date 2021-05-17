package com.idea.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idea.controllers.IDepartmentController;
import com.idea.entities.Department;
import com.idea.entities.services.IDepartmentService;


@RestController
@RequestMapping(value = "/department")
public class DepartmentControllerImpl  implements IDepartmentController{

	@Autowired
	@Qualifier("DepartmentService")
	IDepartmentService departmentService; 
	
	
	@GetMapping("/get/{id}")
	@Override
	public ResponseEntity<String> getDepartment(@PathVariable("id") Integer id) {
		Department department;

		try {
			department = departmentService.getDepartment(id);
			if (department == null) {
				return new ResponseEntity<>("Not Found ", HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<>("OK : "+department, HttpStatus.OK);
			}

		} catch (Exception e) {
			return new ResponseEntity<>("BAD Request ", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/all")
	@Override
	public List<Department> getAllDepartments() {
		return  departmentService.getAllDepartments();
	}

	@PostMapping("/add")
	@Override
	public ResponseEntity<String> addDepartment(@RequestBody  Department department) {
		Department d;
		try {
			d = departmentService.createDepartment(department);
			if (d.getDepartmentId() != null && d.getDepartmentId() > 0) {
				return new ResponseEntity<>("OK ", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("BAD Request ", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("BAD Request ", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/edit/{id}")
	@Override
	public ResponseEntity<String> updDepartment(@RequestBody Department department, @PathVariable  Integer id) {
		Department d;
		try {
			d = departmentService.updateDepartment(department, id);
			if (d.getDepartmentId() == id && d.getDepartmentId() > 0) {
				return new ResponseEntity<>("OK ", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("BAD Request ", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("BAD Request ", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	@Override
	public ResponseEntity<String> delDepartment(@PathVariable Integer id) {
		try {
			departmentService.deleteDepartment(id);
			return new ResponseEntity<>("OK ", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("BAD Request ", HttpStatus.BAD_REQUEST);  
		}
	}

}
