package juno.BuyMeBackEnd.config;

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

@Configuration //configuration is defined here
@ComponentScan(basePackages= {"juno.BuyMeBackEnd.DTO"}) //informs the place where entity classes are defined  
@EnableTransactionManagement //name defines itself
public class HibernateConfig {
	
	//Constants reqd. to connect to a DB
	
	private final static String DB_URL = "jdbc:h2:tcp://localhost/~/preptoShopperDB";
	private final static String DB_DRIVER = "org.h2.Driver";
	private final static String DB_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DB_USERNAME = "sa";
	private final static String DB_PWD = "";
	
	
	//3 Beans - datasource,SessionFactory,HibernateTransactionManager
	
	//Datasource bean  - which holds db creds
	@Bean
	public DataSource getDataSource() {
		//basicdatasource is from dbcp2
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(DB_URL);
		dataSource.setDriverClassName(DB_DRIVER);
		dataSource.setUsername(DB_USERNAME);
		dataSource.setPassword(DB_PWD);
		return dataSource;
	}
	 
	//session factory bean uses the Datasrc bean 
	// to create a session obj
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		//Be sure that hibernate5 version builder is used ..check the import lib
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("juno.BuyMeBackEnd.DTO");
		return builder.buildSessionFactory();
	}
	
	//Hibernate properties are defined here
	public Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect",DB_DIALECT);
		properties.put("hibernate.show_sql",true);
		//properties.put("hibernate.format_sql",true);
		return properties;
		
	}
	
	@Bean
	public HibernateTransactionManager geHibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);
		return hibernateTransactionManager;
	}
	
	
}




 