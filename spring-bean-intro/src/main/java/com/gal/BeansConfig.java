package com.gal;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.gal.algo.Calc;
import com.gal.algo.MyCalc;

@Configuration
public class BeansConfig {
	//will create beans and provide to spring context, then onwards context will manage them
	@Bean
	StringBuilder getStringBuilder() {
		return new StringBuilder("bean from configuration");
	}
	@Bean
	@Primary
	Calc getMyCalc() {
		return new MyCalc();
	}
	@Bean(name = "getCalc")
	Calc getMyCalc2() {
		return new MyCalc();
	}
	
}
