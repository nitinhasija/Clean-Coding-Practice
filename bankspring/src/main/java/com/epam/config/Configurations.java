package com.epam.config;

import com.epam.util.ConstantUtils;
import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * The Class Configurations.
 *
 * @author Nitin_Hasija
 */
@Configuration
@ComponentScan("com.epam")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@EnableJpaRepositories("com.epam.repository")
public class Configurations {

  /** The environment. */
  @Autowired
  public Environment environment;

  /**
   * View resolver.
   *
   * @return the internal resource view resolver
   */
  @Bean
  public InternalResourceViewResolver viewRosolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setSuffix(ConstantUtils.SUFFIX);
    return viewResolver;
  }

  /**
   * Transaction manager.
   *
   * @param factory the factory
   * @return the jpa transaction manager
   */
  @Bean
  public JpaTransactionManager transactionManager(EntityManagerFactory factory) {
    JpaTransactionManager manager = new JpaTransactionManager();
    manager.setEntityManagerFactory(factory);
    return manager;
  }

  /**
   * Entity manager factory.
   *
   * @param datasource the datasource
   * @return the entity manager factory
   */
  @Bean
  public EntityManagerFactory entityManagerFactory(DataSource datasource) {
    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setDataSource(datasource);

    AbstractJpaVendorAdapter vender = new HibernateJpaVendorAdapter();
    vender.setDatabase(Database.MYSQL);

    factory.setJpaVendorAdapter(vender);
    factory.setJpaProperties(properties());
    factory.setPackagesToScan("com.epam.entities");
    factory.afterPropertiesSet();
    return factory.getObject();
  }

  /**
   * Properties.
   *
   * @return the properties
   */
  public Properties properties() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.hbm2ddl.auto",
        environment.getProperty("hibernate.hbm2ddl.auto"));
    properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));

    return properties;
  }

  /**
   * Datasource.
   *
   * @return the data source
   */
  @Bean
  public DataSource datasource() {
    DriverManagerDataSource datasource = new DriverManagerDataSource();
    datasource.setDriverClassName(environment.getProperty("db.driver"));
    datasource.setUrl(environment.getProperty("db.url"));
    datasource.setUsername(environment.getProperty("db.username"));
    datasource.setPassword(environment.getProperty("db.password"));
    return datasource;
  }
}
