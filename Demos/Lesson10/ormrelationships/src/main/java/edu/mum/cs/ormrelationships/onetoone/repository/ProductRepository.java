package edu.mum.cs.ormrelationships.onetoone.repository;

import java.util.List;

import edu.mum.cs.ormrelationships.onetoone.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	@Query(value = "select p from Product p left join fetch p.hotLine")
	List<Product> getAllProducts();
}
