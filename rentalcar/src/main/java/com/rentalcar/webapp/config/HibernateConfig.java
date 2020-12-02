package com.rentalcar.webapp.config;

import java.util.Properties;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement // attivata modalità gestione se qualcosa va male si fa il rollback delle operazioni in db
@ComponentScan({"com.rentalcar.webapp.config"})  // dove deve andare a cercare hibernate le altre configurazioni
@PropertySource("classpath:application.properties")
public class HibernateConfig {

	@Autowired //code injection
	private Environment env; // per accedere alle specifiche dell'application properties
	
	@Autowired //code injection da jdbc config
	private DataSource dataSource;
	
	@Bean  //quello che creerà l'entity manager principale
	LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		
		
		factory.setJpaVendorAdapter(this.jpaVendorAdapter());
		factory.setDataSource(dataSource);
		factory.setPackagesToScan("com.rentalcar.webapp.entities"); //dove hibernate andrà a scansionare le entità create
		factory.setJpaProperties(this.hibernateProperties());
		factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
		factory.setValidationMode(ValidationMode.NONE);
		return factory;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter()
	{
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(false);
		hibernateJpaVendorAdapter.setDatabasePlatform(env.getRequiredProperty("hibernate.dialect"));
		return hibernateJpaVendorAdapter;
	}
	
	private Properties hibernateProperties()
	{
		Properties jpaProperties = new Properties();
		jpaProperties.put("javax.persistence.schema-generation.database.action", "create");
		jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
		jpaProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return jpaProperties;
	}
	
	@Bean
	public JpaTransactionManager transactionManager()
	{
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

}
