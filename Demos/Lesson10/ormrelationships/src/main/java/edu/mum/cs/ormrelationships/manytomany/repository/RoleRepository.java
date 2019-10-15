package edu.mum.cs.ormrelationships.manytomany.repository;

import edu.mum.cs.ormrelationships.manytomany.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

    List<Role> findAll();
	
}
