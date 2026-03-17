package com.gal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gal.model.Department;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@Component
public class DepartmentDaoImpl implements DepartmentDao {
	
	@Autowired
	EntityManagerFactory emf;

	@Override
	public Department find(int deptid) {
		EntityManager em = emf.createEntityManager();
		Department dep = em.find(Department.class, deptid);
		return dep;
	}
}
