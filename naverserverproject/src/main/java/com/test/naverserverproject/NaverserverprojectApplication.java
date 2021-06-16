package com.test.naverserverproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan 
@MapperScan(basePackageClasses = MemberDAO.class)
public class NaverserverprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaverserverprojectApplication.class, args);
	}

}
