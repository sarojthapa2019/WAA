package edu.mum.cs.waa.lab.security_lab11.repository;


import edu.mum.cs.waa.lab.security_lab11.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select e from Employee e where e.address.phoneNumber = :phoneNumber")
    Optional<Employee> locateOneEmployeeByHisNumber(String phoneNumber);
//    Optional<Employee> getAllByAddress_PhoneNumber(String number);
}
