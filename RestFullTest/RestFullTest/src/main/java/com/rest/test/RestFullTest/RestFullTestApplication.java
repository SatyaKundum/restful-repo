package com.rest.test.RestFullTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableAutoConfiguration
@Controller
@SpringBootApplication
@RequestMapping("/hello")
public class RestFullTestApplication {
	
	@RequestMapping("")
	@ResponseBody
	public String hello() {
		return "Hello RESTFul World";
	}

	public static void main(String[] args) {
		SpringApplication.run(RestFullTestApplication.class, args);
	}

}

