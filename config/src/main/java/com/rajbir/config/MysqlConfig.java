//package com.rajbir.config;
//
//import com.jolbox.bonecp.BoneCPDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.Database;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//import javax.sql.DataSource;
//
///**
// * Created by Sony on 02-09-2017.
// */
//
//@Configuration
////@ComponentScan(value = {"com.rajbir.core", "com.rajbir.config", "com.rajbir.web"})
//@EnableJpaRepositories("com.rajbir.core.repository")
//@PropertySource("classpath:boneCp.properties")
//public class BoneCpConfig {
//
//    private static final String[] PACKAGES_TO_SCAN = {"com.rajbir.core.domain"};
//
//    @Autowired
//    Environment env;
//
//
//    @Value("${bonecp.url}")
//    private String jdbcUrl;
//
//    @Value("${bonecp.username}")
//    private String jdbcUsername;
//
//    @Value("${bonecp.password}")
//    private String jdbcPassword;
//
//    @Value("${bonecp.driverClass}")
//    private String driverClass;
//
//    @Value("${bonecp.idleMaxAgeInMinutes}")
//    private Integer idleMaxAgeInMinutes;
//
//    @Value("${bonecp.idleConnectionTestPeriodInMinutes}")
//    private Integer idleConnectionTestPeriodInMinutes;
//
//    @Value("${bonecp.maxConnectionsPerPartition}")
//    private Integer maxConnectionsPerPartition;
//
//    @Value("${bonecp.minConnectionsPerPartition}")
//    private Integer minConnectionsPerPartition;
//
//    @Value("${bonecp.partitionCount}")
//    private Integer partitionCount;
//
//    @Value("${bonecp.acquireIncrement}")
//    private Integer acquireIncrement;
//
//    @Value("${bonecp.statementsCacheSize}")
//    private Integer statementsCacheSize;
//
//    @Bean(destroyMethod = "close")
//    public DataSource dataSource() {
//        BoneCPDataSource dataSource = new BoneCPDataSource();
//        dataSource.setDriverClass(driverClass);
//        dataSource.setJdbcUrl(jdbcUrl);
//        dataSource.setUsername(jdbcUsername);
//        dataSource.setPassword(jdbcPassword);
//        dataSource.setIdleConnectionTestPeriodInMinutes(idleConnectionTestPeriodInMinutes);
//        dataSource.setIdleMaxAgeInMinutes(idleMaxAgeInMinutes);
//        dataSource.setMaxConnectionsPerPartition(maxConnectionsPerPartition);
//        dataSource.setMinConnectionsPerPartition(minConnectionsPerPartition);
//        dataSource.setPartitionCount(partitionCount);
//        dataSource.setAcquireIncrement(acquireIncrement);
//        dataSource.setStatementsCacheSize(statementsCacheSize);
//        return dataSource;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setDatabase(Database.MYSQL);
//        if (env.getProperty("spring.profiles.active").equals("local")) {
//            vendorAdapter.setGenerateDdl(true);
//        } else {
//            vendorAdapter.setGenerateDdl(true);
//        }
//        vendorAdapter.setShowSql(true);
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan(PACKAGES_TO_SCAN);
//        factory.setDataSource(dataSource());
//        return factory;
//    }
//
//}

package com.rajbir.config;

import com.jolbox.bonecp.BoneCPDataSource;
import com.rajbir.config.enums.Constants;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 * Created by Sony on 02-09-2017.
 */

@Configuration
@EnableJpaRepositories("com.rajbir.core.repository")
@EnableTransactionManagement
@PropertySource("classpath:boneCp.properties")
public class MysqlConfig {

    private static Logger logger = LoggerFactory.getLogger(MysqlConfig.class);

    private static final String[] PACKAGES_TO_SCAN = {"com.rajbir.core.domain"};

    @Autowired
    Environment env;


    @Value("${bonecp.url}")
    private String jdbcUrl;

    @Value("${bonecp.username}")
    private String jdbcUsername;

    @Value("${bonecp.password}")
    private String jdbcPassword;

    @Value("${bonecp.driverClass}")
    private String driverClass;

    @Value("${bonecp.idleMaxAgeInMinutes}")
    private Integer idleMaxAgeInMinutes;

    @Value("${bonecp.idleConnectionTestPeriodInMinutes}")
    private Integer idleConnectionTestPeriodInMinutes;

    @Value("${bonecp.maxConnectionsPerPartition}")
    private Integer maxConnectionsPerPartition;

    @Value("${bonecp.minConnectionsPerPartition}")
    private Integer minConnectionsPerPartition;

    @Value("${bonecp.partitionCount}")
    private Integer partitionCount;

    @Value("${bonecp.acquireIncrement}")
    private Integer acquireIncrement;

    @Value("${bonecp.statementsCacheSize}")
    private Integer statementsCacheSize;

    @Bean
    @Profile("live")
    public BasicDataSource dataSource() throws URISyntaxException {
        URI dbUri = new URI(System.getenv(Constants.CLEARDB_DATABASE_URL));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }

    @Bean(destroyMethod = "close")
    @Profile("local")
    public DataSource localDataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        dataSource.setIdleConnectionTestPeriodInMinutes(idleConnectionTestPeriodInMinutes);
        dataSource.setIdleMaxAgeInMinutes(idleMaxAgeInMinutes);
        dataSource.setMaxConnectionsPerPartition(maxConnectionsPerPartition);
        dataSource.setMinConnectionsPerPartition(minConnectionsPerPartition);
        dataSource.setPartitionCount(partitionCount);
        dataSource.setAcquireIncrement(acquireIncrement);
        dataSource.setStatementsCacheSize(statementsCacheSize);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws URISyntaxException {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.MYSQL);

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        //NOTE
        //causes hibernate to create new tables from POJOs with @Table/@Entity annotation
//        vendorAdapter.setGenerateDdl(true);
        //if this is set false and you try to run sql query/jpa method on some new entity without manual migration (adding the new table to DB by hand) you'll get SQLGrammer Exception could not extract ResultSet; SQL [n/a]

        if (env.getProperty("spring.profiles.active").equals("local")) {
            vendorAdapter.setGenerateDdl(true);
            entityManager.setDataSource(localDataSource());
        } else {
            vendorAdapter.setGenerateDdl(true);
            entityManager.setDataSource(dataSource());
        }
        vendorAdapter.setShowSql(true);

        entityManager.setJpaVendorAdapter(vendorAdapter);
        entityManager.setPackagesToScan(PACKAGES_TO_SCAN);
        entityManager.setJpaProperties(additionalJPAProperties());
        return entityManager;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties additionalJPAProperties() {
        Properties properties = new Properties();
        //never use "anything other than validate in production" see https://stackoverflow.com/questions/438146/hibernate-hbm2ddl-auto-possible-values-and-what-they-do?lq=1
//        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty("hibernate.hbm2ddl.auto", "validate");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }

}

//    configuration of the BasicDataSource to connect to ClearDB in Spring:
//
//@Configuration
//public class MainConfig {
//
//    @Bean
//    public BasicDataSource dataSource() throws URISyntaxException {
//        URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
//
//        String username = dbUri.getUserInfo().split(":")[0];
//        String password = dbUri.getUserInfo().split(":")[1];
//        String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
//
//        BasicDataSource basicDataSource = new BasicDataSource();
//        basicDataSource.setUrl(dbUrl);
//        basicDataSource.setUsername(username);
//        basicDataSource.setPassword(password);
//
//        return basicDataSource;
//    }
//}
