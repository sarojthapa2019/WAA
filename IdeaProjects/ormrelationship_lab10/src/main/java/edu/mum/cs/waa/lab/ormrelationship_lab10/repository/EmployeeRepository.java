package edu.mum.cs.waa.lab.ormrelationship_lab10.repository;

import edu.mum.cs.waa.lab.ormrelationship_lab10.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select e from Employee e where e.address.phoneNumber = :phoneNumber")
    Optional<Employee> locateOneEmployeeByHisNumber(String phoneNumber);
//    Optional<Employee> getAllByAddress_PhoneNumber(String number);
}
