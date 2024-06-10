package org.myworkspace.MultipleDBconnection.Author;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(basePackages = {"org.myworkspace.MultipleDBconnection.Author"},
                        entityManagerFactoryRef = "getAuthorEntityManager",
                        transactionManagerRef = "authorTxnManager")
public class AuthorDbConfig {

    @Value("${author.datasource.ddl}")
    private String authorDDL;

    // step 1 : setting config props prefix
    @Bean
    @ConfigurationProperties(
            prefix = "author.datasource"
    )
    public DataSource getDatasourceForAuthor(){
        return DataSourceBuilder.create().build();
    }


    // step 2 : set up local entity manager
    @Bean
    public LocalContainerEntityManagerFactoryBean getAuthorEntityManager(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(getDatasourceForAuthor());
        em.setPackagesToScan("org.myworkspace.MultipleDBconnection.Author");


        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");


        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(hibernateJpaVendorAdapter);
        em.setJpaPropertyMap(properties);
        return em;
    }

    // step 3 : set up dedicated transaction manager
    @Bean
    public PlatformTransactionManager authorTxnManager(){
        JpaTransactionManager txnManager = new JpaTransactionManager();
        txnManager.setEntityManagerFactory(getAuthorEntityManager().getObject());
        return txnManager;
    }
}
