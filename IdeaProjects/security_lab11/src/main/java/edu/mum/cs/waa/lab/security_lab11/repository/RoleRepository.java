package edu.mum.cs.waa.lab.security_lab11.repository;

import edu.mum.cs.waa.lab.security_lab11.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findAll();
}
