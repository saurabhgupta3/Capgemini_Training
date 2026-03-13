package com.gal.algo;

import org.springframework.stereotype.Component;

@Component
public class FileFilter {
	public String getFilter() {
		return "*.java";
	}
}
