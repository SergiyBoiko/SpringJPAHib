package com.ghub.sergiy.boiko.configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.Properties;

@Configuration
@ImportResource(locations = "application.properties")
public class HibernateConfig {

    @Bean
    public DataSource dataSource(@Value("${spring.datasource.driver-class}") String driverClass,
                                 @Value("${spring.datasource.url}") String url,
                                 @Value("${spring.datasource.username}") String username,
                                 @Value("${spring.datasource.password}")String password){

        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean localSessionFactoryBean(@Value("${spring.hibernate.entityPackage}") String entityPackage,
                                                           @Value("${spring.hibernate.dialect}") String dialect,
                                                           DataSource dataSource){

        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setAnnotatedPackages(entityPackage);

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", dialect);
        localSessionFactoryBean.setHibernateProperties(properties);

        return localSessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);

        return transactionManager;
    }

}
