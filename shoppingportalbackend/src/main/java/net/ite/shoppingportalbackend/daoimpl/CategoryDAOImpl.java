package net.ite.shoppingportalbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.ite.shoppingportalbackend.dao.CategoryDAO;
import net.ite.shoppingportalbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active",true);
		
		
		return query.getResultList();
	}

	@Autowired
	private SessionFactory sessionFactory;

	// static List for items
	/*
	 * public static List<Category> categories = new ArrayList<>();
	 * 
	 * static {
	 * 
	 * Category category = new Category();
	 * 
	 * 
	 * //adding first Category category.setId(1); category.setName("Television");
	 * category.setDescription("This is Description for Television");
	 * category.setImageURL("CAT_1.png");
	 * 
	 * categories.add(category);
	 * 
	 * //adding second Category category = new Category();
	 * 
	 * category.setId(2); category.setName("Mobile");
	 * category.setDescription("This is Description for Mobile");
	 * category.setImageURL("CAT_2.png");
	 * 
	 * categories.add(category);
	 * 
	 * //adding third Category category = new Category();
	 * 
	 * category.setId(3); category.setName("Laptop");
	 * category.setDescription("This is Description for Laptop");
	 * category.setImageURL("CAT_3.png");
	 * 
	 * categories.add(category);
	 * 
	 * //adding fourth Category category = new Category();
	 * 
	 * category.setId(4); category.setName("Electronics");
	 * category.setDescription("This is Description for Electronics");
	 * category.setImageURL("CAT_4.png");
	 * 
	 * categories.add(category); }
	 */

	@Override
	public Category get(int id) {
		// enhanced for loop(for static data)

		/*
		 * for(Category category : categories) {
		 * 
		 * if(category.getId() == id) return category; }
		 */

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override

	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}

	}
    /*Updating the single Category
     * */
	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}

}
