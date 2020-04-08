package net.ite.shoppingportalbackend.dao;

import java.util.List;

import net.ite.shoppingportalbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
	
	
}
