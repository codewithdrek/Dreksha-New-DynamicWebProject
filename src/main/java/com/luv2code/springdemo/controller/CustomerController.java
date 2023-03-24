package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.DAO.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject DAO
	@Autowired
	private CustomerDAO customerDAO;

	//@RequestMapping("/list")
	@GetMapping("/list")
	public String listCustomer(Model m) {
		
		// get customer fromDAO
		List<Customer> theList = customerDAO.getCustomers();
		
		//Add customer to the model
		  m.addAttribute("xyz",theList); //Note xyz must be linked with JSP Page 
		
		return "list-customers";
	}

}

//Please not  response.sendRedirect("/customer/list");/ customer this  will remove ur Project Name or we can say context root from url 
//hence not work please use below one for best practice
//<% response.sendRedirect("customer/list");%>

//please note Package name must be same in spring-mvc-crud.xml and ur pacakge which u have created 
