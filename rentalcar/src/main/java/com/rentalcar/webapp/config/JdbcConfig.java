package com.rentalcar.webapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.core.env.Environment;
@Configuration
@EnableTransactionManagement // attivata modalità gestione se qualcosa va male si fa il rollback delle operazioni in db
@ComponentScan({"com.rentalcar.webapp.config"})  // dove deve andare a cercare hibernate le altre configurazioni
@PropertySource("classpath:application.properties")
public class JdbcConfig {
	@Autowired
	private Environment environment;
	
	@Bean  //perc creare il jdbc
	public JdbcTemplate jdbcTemplate(DataSource dataSource)
	{
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public NamedParameterJdbcTemplate getJdbcTemplate(DataSource dataSource)
	{
		return new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Bean(name = "dataSource")
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
	    return dataSource;
	}
}
