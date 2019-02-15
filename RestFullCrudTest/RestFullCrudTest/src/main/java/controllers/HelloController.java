package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hellouser")
public class HelloController {

	@RequestMapping("")
	@ResponseBody
	public String hello() {
		return "Welcome to Restful test";
	}
	
	@RequestMapping(value="",method=RequestMethod.POST)
	@ResponseBody
	public String greeting(@RequestBody String name) {
		return "Welcome to Restful test - "+name;
	}
}
