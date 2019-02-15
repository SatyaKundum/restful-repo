package com.rest.crudtest.RestFullCrudTest;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import model.Customer;


public class RestFullCrudTestApplicationTests extends Assert{

	RestTemplate template = new RestTemplate();
	
	private static final String BASE_URI = "http://localhost:9020/customers";
	
	@Test
	public void test_get_all_customers_getForObject() {
	 List list = template.getForObject(BASE_URI, List.class);
	 assertNotNull(list);
	}
	
	@Test
	public void test_get_all_customers_getForEntiry() {
	 ResponseEntity<List> response =  template.getForEntity(BASE_URI, List.class);
	 assertEquals(response.getStatusCode().value(), 200);
	}
	
	@Test(expected=HttpClientErrorException.class)
	public void test_delete_customer_exception() {
		ResponseEntity<String> response = template.exchange("http://localhost:9020/customers/100", HttpMethod.DELETE, null, String.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
	}
	
	@Test(expected=HttpClientErrorException.class)
	public void test_delete_customer_success() {
		template.delete("http://localhost:9020/customers/3");
		ResponseEntity<Customer> response = template.getForEntity("http://localhost:9020/customers/3", Customer.class);
		assertTrue(response.getStatusCode().is2xxSuccessful());
	}
	
	

}

