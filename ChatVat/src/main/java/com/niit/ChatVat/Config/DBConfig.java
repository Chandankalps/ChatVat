package com.niit.ChatVat.Config;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.ChatVat.Dao.BlogDAO;
import com.niit.ChatVat.Dao.BlogDaoImpl;
import com.niit.ChatVat.model.Blog.Blog;


@Configuration
@ComponentScan("com.niit.ChatVat")
@EnableTransactionManagement
public class DBConfig {

public DataSource getOracleDataSource()
{
System.out.println("Data Source Method");
DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
driverManagerDataSource.setUsername("SYSTEM");
driverManagerDataSource.setPassword("hr");

System.out.println("Data Source Created");
return driverManagerDataSource;
}
public Properties getHibernateProperties() {
Properties properties = new Properties();
properties.setProperty("hibernate.hbm2ddl.auto", "update");
properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
return properties;
}

@Autowired
@Bean
public SessionFactory getSessionFactory() {
LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(getOracleDataSource());
localSessionFactoryBuilder.addProperties(getHibernateProperties());
localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
System.out.println("SessionFactory Created");
return localSessionFactoryBuilder.buildSessionFactory();
}




@Bean
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
{
return new HibernateTransactionManager(sessionFactory);
}



@Bean
public BlogDAO getBlogDAO(SessionFactory sessionFactory)
{
return new BlogDaoImpl(sessionFactory);
}



}
