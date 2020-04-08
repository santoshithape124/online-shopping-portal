package net.ite.shoppingportalbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.ite.shoppingportalbackend.dao.CategoryDAO;
import net.ite.shoppingportalbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	public static List<Category> categories = new ArrayList<>();

	static {

		Category category = new Category();

		
		//adding first Category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is Description for Television");
		category.setImageURL("CAT_1.png");

		categories.add(category);

		//adding second Category
		category = new Category();

		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is Description for Mobile");
		category.setImageURL("CAT_2.png");

		categories.add(category);

		//adding third Category
		category = new Category();

		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is Description for Laptop");
		category.setImageURL("CAT_3.png");

		categories.add(category);
		
		//adding fourth Category
		category = new Category();

		category.setId(4);
		category.setName("Electronics");
		category.setDescription("This is Description for Electronics");
		category.setImageURL("CAT_4.png");

		categories.add(category);
	}

	@Override
	public Category get(int id) {
		// enhanced for loop
		
		for(Category category : categories) {
			
			if(category.getId() == id) return category;
		}
		 
		return null;
	}

}
