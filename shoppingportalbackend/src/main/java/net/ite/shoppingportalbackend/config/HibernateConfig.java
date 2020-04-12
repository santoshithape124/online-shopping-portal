package net.ite.shoppingportalbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"net.ite.shoppingportalbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
   
	//change the below based on DBMS you choose
	private final static String DATABASE_URL ="jdbc:h2:tcp://localhost/~/onlineshoppingportal";
	private final static String DATABASE_DRIVER ="org.h2.Driver";
	private final static String DATABASE_DIALECT ="org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME ="sa";
	private final static String DATABASE_PASSSWORD ="";
	
	//datasource bean will be available
	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		//providing the database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSSWORD);
		
		
		return dataSource;
	}
	
	// SessionFactory bean will be available
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder= new LocalSessionFactoryBuilder(dataSource);
		
		builder.addProperties(getHibernateProperites());
		builder.scanPackages("net.ite.shoppingportalbackend.dto");
		
		return builder.buildSessionFactory();
	}


	// All the Hibernate properties will be returned in this method
	private Properties getHibernateProperites() {
		
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
			
		return properties;
	}
	
	// TransactionManager bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
      return transactionManager;				
	}
	
}

  