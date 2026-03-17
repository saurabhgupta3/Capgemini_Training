package com.gal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gal.dao.DepartmentDao;
import com.gal.model.Department;

@Service 
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentDao departmentDao;
	

	public DepartmentServiceImpl(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}


	@Override
	public Department find(int depid) {
		return departmentDao.find(depid);
	}
	
}
