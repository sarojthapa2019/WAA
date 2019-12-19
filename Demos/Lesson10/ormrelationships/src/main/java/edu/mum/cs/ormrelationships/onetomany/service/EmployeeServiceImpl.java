package edu.mum.cs.ormrelationships.onetomany.service;

import java.util.List;

import edu.mum.cs.ormrelationships.onetomany.domain.Employee;
import edu.mum.cs.ormrelationships.onetomany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAll() {
		return (List<Employee>) employeeRepository.findAll();
	}

	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee get(Long id) {
		 return employeeRepository.findById(id).get();
//		return employeeRepository.findByName(id);
	};

	@Override
	public List<Employee> findByLastName(String lastName) {
		return employeeRepository.findByLastName(lastName);
	}

	@Override
	public List<Employee> findEmployeesByLastName(String lastName) {		
		return employeeRepository.findEmployeesByLastName(lastName);
	};

}
