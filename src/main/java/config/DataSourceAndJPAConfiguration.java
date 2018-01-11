package config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Arrays;


@Configuration
@EnableJpaRepositories(basePackages = "repositories",
        entityManagerFactoryRef = "localContainerEntityManagerFactory")
public class DataSourceAndJPAConfiguration {


    @Bean
    public DataSource createDataSource()
    {
        DriverManagerDataSource managerDataSource = new DriverManagerDataSource();
        managerDataSource.setUrl("jdbc:mysql://localhost:3306/shopping_db");
        managerDataSource.setUsername("shop_user");
        managerDataSource.setPassword("shop_password");
        managerDataSource.setDriverClassName("com.mysql.jdbc.Driver");

        return managerDataSource;
    }

    @Bean(name = "localContainerEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean createEntityManagerFactory
            (DataSource dataSource, JpaVendorAdapter jpaVendorAdapter)
    {
        LocalContainerEntityManagerFactoryBean lcemf =
                new LocalContainerEntityManagerFactoryBean();

        lcemf.setDataSource(dataSource);
        lcemf.setJpaVendorAdapter(jpaVendorAdapter);
        lcemf.setPackagesToScan("entities");

        System.out.println("Creating Entity Manager Factory Bean ...");

        return lcemf;
    }

    @Bean
    public JpaVendorAdapter createJPAVendorAdapter()
    {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();

        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");

        return hibernateJpaVendorAdapter;
    }

    @Bean(name = "transactionManager")
    public JpaTransactionManager createTransactionManager()
    {
        return new JpaTransactionManager();
    }



}
