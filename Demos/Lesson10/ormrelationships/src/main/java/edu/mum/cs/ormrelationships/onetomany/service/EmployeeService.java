package edu.mum.cs.ormrelationships.onetomany.service;

import edu.mum.cs.ormrelationships.onetomany.domain.Employee;

import java.util.List;


public interface EmployeeService {

	public List<Employee> getAll();

	public Employee save(Employee employee);

	public Employee get(Long id);

	public List<Employee> findByLastName(String lastName);

	public List<Employee> findEmployeesByLastName(String lastName);

}
