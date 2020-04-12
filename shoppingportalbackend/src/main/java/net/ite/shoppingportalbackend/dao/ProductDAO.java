package net.ite.shoppingportalbackend.dao;

import java.util.List;

import net.ite.shoppingportalbackend.dto.Product;

public interface ProductDAO {

	Product get(int productId); 
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	//Bussiness methods
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	
}
