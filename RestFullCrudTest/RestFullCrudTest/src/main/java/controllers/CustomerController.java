package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Customer;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	private static List<Customer> list = new ArrayList<Customer>();
	
	static {
		list.add(new Customer(1l, "Satya"));
		list.add(new Customer(2l, "Mouni"));
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public List<Customer> getAllCustomers(){
		return list;
	}

}
