package com.test.naverserverproject;

import java.io.File;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		  File file = new File("./"); 
		  String  path = "file:///"+file.getAbsolutePath();
		  path = path.split("naverserverproject")[0];
		 
		registry.addResourceHandler("/images/**")
		.addResourceLocations(path+"img/");
	}
}

