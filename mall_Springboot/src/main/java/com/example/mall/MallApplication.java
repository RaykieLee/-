package com.example.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(excludeName = "com.example.mall")
@MapperScan("com.example.mall.mapper")
public class MallApplication {

	public static void main(String[] args) {
//		ApplicationContext applicationContext =
//				SpringApplication.run(MallApplication.class, args);
//
//		for (String name : applicationContext.getBeanDefinitionNames()) {
//			System.out.println(name);
//		}
		SpringApplication.run(MallApplication.class, args);
	}

}
