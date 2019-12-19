package edu.mum.cs.ormrelationships.onetoone.service;

import java.util.List;

import edu.mum.cs.ormrelationships.onetoone.domain.Product;
import edu.mum.cs.ormrelationships.onetoone.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> getAll() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product find(Long id) {
		return productRepository.findById(id).get();
	}

}
