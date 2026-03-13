package com.gal;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.gal.algo.Calc;
import com.gal.algo.MyCalc;

@Configuration
public class BeansConfig {
	//will create beans and provide to spring context, then onwards context will manage them
	@Bean
	@Scope("prototype")//every time create a new object
	//@Scope("request") every time request comes create a new object
	//@Scope("sessoin") every time a session created create a new object
	//@Scope("appication") every time new application create a new object
	StringBuilder getStringBuilder() {
		return new StringBuilder("bean from configuration stringbuilder");
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
//	@Bean
//	DataSource mysqlDataSource() {
//		MysqlDataSource ds = new MysqlDataSource();
//		ds.setUrl("jdbc:mysql://localhost:3306/company_db");
//		ds.setUser("root");
//		ds.setPassword("${DB_PASSWORD}");
//		return ds;
//	}
}
