package edu.mum.cs.ormrelationships.onetoone.repository;

import edu.mum.cs.ormrelationships.onetoone.domain.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PhoneRepository extends CrudRepository<Phone, Long> {

}
