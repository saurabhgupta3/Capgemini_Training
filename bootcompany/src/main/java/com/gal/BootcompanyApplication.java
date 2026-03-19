package com.gal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.gal.dao.DepartmentDao;
import com.gal.model.Department;

@SpringBootApplication
public class BootcompanyApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BootcompanyApplication.class);
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BootcompanyApplication.class, args);
		log.info("application started successfully");
//		try {
//			for(int i=1; i<=10; i++) {
//				if(i == 6) {
//					
//				}
//			}
//		}
		DepartmentDao dao = context.getBean(DepartmentDao.class);
		Department dep = dao.find(10);
		System.out.println(dep);
		
	}

}
