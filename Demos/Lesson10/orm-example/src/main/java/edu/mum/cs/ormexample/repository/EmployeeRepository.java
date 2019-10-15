package edu.mum.cs.ormexample.repository;

import edu.mum.cs.ormexample.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.address.zipCode = :zipCode")
    public List<Employee> someName(String zipCode);

}
