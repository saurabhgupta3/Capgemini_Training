package com.gal.service;

import com.gal.model.Department;

public interface DepartmentService {
	Department getDepartmentById(int depid);
	Department addDepartment(Department dep);
	Department updateDepartment(Department dep);
}
