package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import exception.CustomerNotFoundException;
import model.Customer;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	private static List<Customer> list = new ArrayList<Customer>();

	static {
		list.add(new Customer(1l, "Satya"));
		list.add(new Customer(2l, "Mouni"));
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public List<Customer> getAllCustomers() {
		return list;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Customer getCustomer(@PathVariable("id") Long id) {
		for (Customer c : list) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		throw new CustomerNotFoundException();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public void addCustomer(@RequestBody Customer customer) {
		list.add(customer);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable("id") Long id) {
		Customer customer = null;
		for (Customer c : list) {
			if (c.getId().equals(id)) {
				customer = c;
			}
		}
		if (customer == null) {
			throw new CustomerNotFoundException();
		} else {
			list.remove(customer);
		}
	}

}
