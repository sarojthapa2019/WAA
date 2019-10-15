package edu.mum.cs.waa.lab.ormrelationship_lab10.service.serviceimpl;

import edu.mum.cs.waa.lab.ormrelationship_lab10.domain.Employee;
import edu.mum.cs.waa.lab.ormrelationship_lab10.repository.EmployeeRepository;
import edu.mum.cs.waa.lab.ormrelationship_lab10.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl( EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.getOne(id);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Optional<Employee> getEmployeeByNumber(String number) {
        return employeeRepository.locateOneEmployeeByHisNumber(number);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}
