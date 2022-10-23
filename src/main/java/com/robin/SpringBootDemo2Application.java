package com.robin;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

@SpringBootApplication
public class SpringBootDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo2Application.class, args);
	}
	
	// Bean拦截器
	@Bean
	public MultipartConfigElement multipartConfigElement() {  
	    MultipartConfigFactory factory = new MultipartConfigFactory();  
	    //单个文件最大
	    factory.setMaxFileSize(DataSize.ofMegabytes(10)); // 10MB, 10 * 1024KB  
	    // 设置总上传数据总大小
	    factory.setMaxRequestSize(DataSize.ofMegabytes(1000));  // 1000MB, 1000 * 1024KB
	    return factory.createMultipartConfig();  
	}
}
