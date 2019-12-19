package edu.mum.cs.ormrelationships.onetoone.service;

import edu.mum.cs.ormrelationships.onetoone.domain.Product;

import java.util.List;



public interface ProductService {
	
	public List<Product> getAll();

	public List<Product> getAllProducts();

	public Product save(Product product);

	public Product find(Long id);
	
}
