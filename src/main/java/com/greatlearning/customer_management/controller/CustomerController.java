package com.greatlearning.customer_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Component;

import com.greatlearning.customer_management.entity.Customer;
import com.greatlearning.customer_management.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired /* spring managed */
	private CustomerService customerService;

	@RequestMapping("/list")

	public String findAll(Model model) {
		List<Customer> customerList = customerService.findAll();
		model.addAttribute("customer", customerList);
		return "Customer";
	}

	@RequestMapping("/save")
	public String save(@RequestParam("first_name") String first_name, @RequestParam("last_name") String last_name,
			@RequestParam("customer_Email") String customer_Email, int customer_id)

	{
		Customer b = null;
		if (customer_id != -1) {
			b = customerService.findById(customer_id);
			b.setFirst_name(first_name);
			b.setLast_name(last_name);
			b.setCustomer_Email(customer_Email);

		} else
			b = new Customer(first_name, last_name, customer_Email);

		customerService.save(b);
		return "redirect:list";
	}

	@RequestMapping("/addCustomer")
	public String addStudent(@RequestParam("id") Integer id, Model model) {

		if (id != -1) {
			Customer b = customerService.findById(id);
			model.addAttribute("customer", b);
		} else {
			Customer b = new Customer();
			b.setCustomer_id(-1);
			model.addAttribute("customer", b);
		}

		return "addcustomer";
	}

	@RequestMapping("/deleteCustomer")
	public String delete(@RequestParam("id") Integer id) {
		Customer b = null;
		if (id != -1) {
			b = customerService.findById(id);
			customerService.delete(b);
		}

		return "redirect:list";
	}

}
