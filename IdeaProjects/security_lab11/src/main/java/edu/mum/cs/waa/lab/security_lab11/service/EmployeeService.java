package edu.mum.cs.waa.lab.security_lab11.service;



import edu.mum.cs.waa.lab.security_lab11.domain.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);
    public Employee getEmployeeById(long id);
    public void deleteEmployee(Employee employee);
    public Optional<Employee> getEmployeeByNumber(String number);
    public List<Employee> getAll();

}
