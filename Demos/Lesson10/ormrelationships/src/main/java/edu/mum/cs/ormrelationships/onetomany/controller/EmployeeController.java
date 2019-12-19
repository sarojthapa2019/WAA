package edu.mum.cs.ormrelationships.onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import edu.mum.cs.ormrelationships.onetomany.domain.Employee;
import edu.mum.cs.ormrelationships.onetomany.domain.Phone;
import edu.mum.cs.ormrelationships.onetomany.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/OneToManyUniJoinColumn", method = RequestMethod.GET)
	public ModelAndView doOneToManyUniJoinColumn() {

		List<Phone> phones = new ArrayList<Phone>();

		Phone phone = new Phone();
		phone.setAreaCode(222);
		phone.setPrefix(333);
		phone.setNumber(5432);
		phones.add(phone);

		phone = new Phone();
		phone.setAreaCode(111);
		phone.setPrefix(444);
		phone.setNumber(2345);
		phones.add(phone);

		Employee employee = new Employee();
		employee.setFirstName("Bill");
		employee.setLastName("Pay");
		employee.setSalary(235000);

		employee.setPhones(phones);

		employee = employeeService.save(employee);
		
		employee = new Employee();
		employee.setFirstName("Bill2");
		employee.setLastName("Pay");
		employee.setSalary(235000);
		employeeService.save(employee);
		
		employeeService.findEmployeesByLastName("Pay").stream().forEach(System.out::println);

		ModelAndView mav = new ModelAndView();
		mav.addObject(employee);
		mav.setViewName("onetomany/EmployeeDetails");
		return mav;
	}

}
