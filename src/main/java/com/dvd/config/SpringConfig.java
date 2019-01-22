package com.dvd.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.dvd.validator.TransactionValidator;
import com.dvd.validator.UserValidator;
import com.mchange.v2.c3p0.ComboPooledDataSource;

//Declare class was used to configuration
@Configuration
@EnableWebMvc
// Enable manage in Transaction in spring
@EnableTransactionManagement
// Enable use annotation in package name start"com.dvd"
@ComponentScan(basePackages = "com.dvd")
// Declare environment contain properties
@PropertySource(value = "classpath:jdbc_hibernate.properties")
public class SpringConfig implements WebMvcConfigurer {

	// Inject view
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	//Inject BcryPassEncoding
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private Environment env;
	
	// add resources handlers resource
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	// Inject DataSource
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();

		try {
			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));

		dataSource.setInitialPoolSize(intPool("connection.pool.initialPoolSize"));
		dataSource.setMinPoolSize(intPool("connection.pool.minPoolSize"));
		dataSource.setMaxPoolSize(intPool("connection.pool.maxPoolSize"));
		dataSource.setMaxIdleTime(intPool("connection.pool.maxIdleTime"));

		return dataSource;
	}

	public int intPool(String name) {
		String pool = env.getProperty(name);
		return Integer.parseInt(pool);
	}

	// Autowrite DataSource
	@Autowired
	private DataSource dataSource;

	// Inject SessionFactory
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setPackagesToScan("com.dvd.entity");
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		return sessionFactoryBean;
	}

	private Properties hibernateProperties() {
		return new Properties() {
			private static final long serialVersionUID = 1L;
			{
				setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
				setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
			}
		};
	}

	//Autowrite SessionFactory
	@Autowired
	private SessionFactory sessionFactory;

	// Configuration Transaction Manager
	@Bean
	public HibernateTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		
		return commonsMultipartResolver;
	}
	
	//Create Bean Message
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.addBasenames("classpath:validator");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	
	//Inject UserValidator
	@Bean
	public UserValidator userValidator() {
		return new UserValidator();
	}

	// Inject TransactionValidator
	@Bean
	public TransactionValidator transactionValidator() {
		return new TransactionValidator();
	}

}
