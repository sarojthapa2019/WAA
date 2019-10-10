package com.packt.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import com.packt.webstore.exception.ProductNotFoundException;

@Repository
public class InMemoryProductRepository implements ProductRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Product> getAllProducts() {
		Map<String, Object> params = new HashMap<>();
		List<Product> result = jdbcTemplate.query("SELECT * from products", params, new ProductMapper());
		return result;
	}

	private static final class ProductMapper implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product product = new Product();
			product.setProductId(rs.getString("ID"));
			product.setName(rs.getString("NAME"));
			product.setDescription(rs.getString("DESCRIPTION"));
			product.setUnitPrice(rs.getBigDecimal("UNIT_PRICE"));
			product.setManufacturer(rs.getString("MANUFACTURER"));
			product.setCategory(rs.getString("CATEGORY"));
			product.setCondition(rs.getString("CONDITION"));
			product.setUnitsInStock(rs.getLong("UNITS_IN_STOCK"));
			product.setUnitsInOrder(rs.getLong("UNITS_IN_ORDER"));
			product.setDiscontinued(rs.getBoolean("DISCONTINUED"));
			return product;
		}

	}

	@Override
	public void updateStock(String productId, long noOfUnits) {
		String SQL = "UPDATE PRODUCTS SET UNITS_IN_STOCK = :noOfUnits WHERE ID = :id";
		Map<String, Object> params = new HashMap<>();
		params.put("noOfUnits", noOfUnits);
		params.put("id", productId);
		jdbcTemplate.update(SQL, params);
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		Map<String, Object> params = new HashMap<>();
		params.put("category", category);
		List<Product> result = jdbcTemplate.query("SELECT * FROM PRODUCTS WHERE CATEGORY = :category", params,
				new ProductMapper());
		return result;
	}

	@Override
	public List<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		List<Product> result = jdbcTemplate.query(
				"SELECT * FROM PRODUCTS WHERE CATEGORY in (:categories) AND MANUFACTURER IN (:brands)", filterParams,
				new ProductMapper());
		return result;
	}

	@Override
	public Product getProductById(String productId) {
		Map<String, Object> params = new HashMap<>();
		params.put("productId", productId);
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM PRODUCTS WHERE ID = :productId", params, new ProductMapper());
		}catch(DataAccessException e) {
			throw new ProductNotFoundException(productId);
		}
		
	}

	@Override
	public void addProduct(Product product) {
		String SQL = "INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, UNIT_PRICE, MANUFACTURER,CATEGORY,CONDITION, UNITS_IN_STOCK, UNITS_IN_ORDER, DISCONTINUED)"
				+ " VALUES(:id, :name, :description, :price, :manufacturer, :category, :condition, :inStock, :inOrder, :discontinued)";
		Map<String, Object> params = new HashMap<>();
		params.put("id", product.getProductId());
		params.put("name", product.getName());
		params.put("description", product.getDescription());
		params.put("price", product.getUnitPrice());
		params.put("manufacturer", product.getManufacturer());
		params.put("category", product.getCategory());
		params.put("condition", product.getCondition());
		params.put("inStock", product.getUnitsInStock());
		params.put("inOrder", product.getUnitsInOrder());
		params.put("discontinued", product.isDiscontinued());
		jdbcTemplate.update(SQL, params);
	}

}
