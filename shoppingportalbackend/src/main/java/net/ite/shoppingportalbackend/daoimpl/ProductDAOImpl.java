 package net.ite.shoppingportalbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.ite.shoppingportalbackend.dao.ProductDAO;
import net.ite.shoppingportalbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 *SINGLE 
	 */
	
	@Override
	public Product get(int productId) {
		try {
			return sessionFactory
					.getCurrentSession()
					   .get(Product.class,Integer.valueOf(productId));
					
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/*
	 *LIST 
	 */
	
	@Override
	public List<Product> list() {
		return sessionFactory
				.getCurrentSession()
				  .createQuery("FROM Product",Product.class)
						  .getResultList();
		
	}

	
	/*
	 *ADD 
	 */
	
	@Override
	public boolean add(Product product) {
		try {
			sessionFactory
			  .getCurrentSession()
			     .persist(product);
			return true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/*
	 *UPDATE 
	 */
	
	@Override
	public boolean update(Product product) {
		try {
			sessionFactory
			   .getCurrentSession()
			      .update(product);
			return true;
		}
		catch (Exception ex) {
		  ex.printStackTrace();
		}
		return false;
	}

	/*
	 *DELETE 
	 */
	
	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
            //call the update method
			return this.update(product);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

		
	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active";
		
		return sessionFactory.getCurrentSession()
				  .createQuery(selectActiveProducts, Product.class)
				     .setParameter("active", true)
				        .getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory
				.getCurrentSession()
				  .createQuery(selectActiveProductByCategory, Product.class)
				    .setParameter("active", true)
				      .setParameter("categoryId",categoryId)
				        .getResultList();
		
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory
				.getCurrentSession()
				  .createQuery("FROM Product WHERE active = :active ORDER By id", Product.class)
				    .setParameter("active", true)
				       .setFirstResult(0)
				          .setMaxResults(count)
				             .getResultList();
	}

}
