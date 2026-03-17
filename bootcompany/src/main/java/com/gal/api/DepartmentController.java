package com.gal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gal.service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	DepartmentService depService;
	
	@RequestMapping("/department")
	@ResponseBody //returned string is not view temlate(not jsp or html)
	//it is the actual body
	public String getDepartment() {
		return depService.find(10).toString();
	}
}
