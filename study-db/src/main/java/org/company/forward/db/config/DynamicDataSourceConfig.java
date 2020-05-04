package org.company.forward.db.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置多数据源
 *
 * @author wangjian
 * @version V1.0.0
 */
@Configuration
public class DynamicDataSourceConfig {

    private static Logger logger = LoggerFactory.getLogger(DynamicDataSourceConfig.class);

    @Autowired
    private Environment env;

    @Bean(name = "masterDataSource")
    @Primary
    public DataSource masterDataSource() {
        String basepath = "spring.datasource.hikari.master.";
        HikariConfig datasource = new HikariConfig();
        datasource.setDriverClassName(env.getProperty(basepath + "driverClassName"));
        datasource.setJdbcUrl(env.getProperty(basepath + "url"));
        datasource.setUsername(env.getProperty(basepath + "username"));
        datasource.setPassword(env.getProperty(basepath + "password"));
//        datasource.setConnectionTestQuery(env.getProperty(basepath + "validationQuery"));
//        datasource.setMaxLifetime(env.getProperty(basepath + "maxLifetime",Long.class));
//        datasource.setMaximumPoolSize(env.getProperty(basepath + "maximumPoolSize",Integer.class));
//		datasource.setConnectionTimeout(env.getProperty(basepath + "maximumPoolSize",Long.class));
//        datasource.setIdleTimeout(env.getProperty(basepath + "idleTimeout",Long.class));
        datasource.addDataSourceProperty("cachePrepStmts", "true"); //是否自定义配置，为true时下面两个参数才生效
        datasource.addDataSourceProperty("prepStmtCacheSize", "250"); //连接池大小默认25，官方推荐250-500
        datasource.addDataSourceProperty("prepStmtCacheSqlLimit", "2048"); //单条语句最大长度默认256，官方推荐2048
        datasource.addDataSourceProperty("useServerPrepStmts", "true"); //新版本MySQL支持服务器端准备，开启能够得到显著性能提升
        datasource.addDataSourceProperty("useLocalSessionState", "true");
        datasource.addDataSourceProperty("useLocalTransactionState", "true");
        datasource.addDataSourceProperty("rewriteBatchedStatements", "true");
        datasource.addDataSourceProperty("cacheResultSetMetadata", "true");
        datasource.addDataSourceProperty("cacheServerConfiguration", "true");
        datasource.addDataSourceProperty("elideSetAutoCommits", "true");
        datasource.addDataSourceProperty("maintainTimeStats", "false");
        datasource.setAutoCommit(false);
        return new HikariDataSource(datasource);
    }

    @Bean(name = "salverDataSource")
    @Primary
    public DataSource salverDataSource() {
        String basepath = "spring.datasource.hikari.salver.";
        HikariConfig datasource = new HikariConfig();
        datasource.setDriverClassName(env.getProperty(basepath + "driverClassName"));
        datasource.setJdbcUrl(env.getProperty(basepath + "url"));
        datasource.setUsername(env.getProperty(basepath + "username"));
        datasource.setPassword(env.getProperty(basepath + "password"));
//        datasource.setConnectionTestQuery(env.getProperty(basepath + "validationQuery"));
//        datasource.setMaxLifetime(env.getProperty(basepath + "maxLifetime",Long.class));
//        datasource.setMaximumPoolSize(env.getProperty(basepath + "maximumPoolSize",Integer.class));
//		datasource.setConnectionTimeout(env.getProperty(basepath + "maximumPoolSize",Long.class));
//        datasource.setIdleTimeout(env.getProperty(basepath + "idleTimeout",Long.class));
        datasource.addDataSourceProperty("cachePrepStmts", "true"); //是否自定义配置，为true时下面两个参数才生效
        datasource.addDataSourceProperty("prepStmtCacheSize", "250"); //连接池大小默认25，官方推荐250-500
        datasource.addDataSourceProperty("prepStmtCacheSqlLimit", "2048"); //单条语句最大长度默认256，官方推荐2048
        datasource.addDataSourceProperty("useServerPrepStmts", "true"); //新版本MySQL支持服务器端准备，开启能够得到显著性能提升
        datasource.addDataSourceProperty("useLocalSessionState", "true");
        datasource.addDataSourceProperty("useLocalTransactionState", "true");
        datasource.addDataSourceProperty("rewriteBatchedStatements", "true");
        datasource.addDataSourceProperty("cacheResultSetMetadata", "true");
        datasource.addDataSourceProperty("cacheServerConfiguration", "true");
        datasource.addDataSourceProperty("elideSetAutoCommits", "true");
        datasource.addDataSourceProperty("maintainTimeStats", "false");
        datasource.setAutoCommit(false);
        return new HikariDataSource(datasource);
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier(value = "masterDataSource") DataSource masterDataSource, @Qualifier(value = "salverDataSource") DataSource salverDataSource) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>(5);
        targetDataSources.put(DataSourceNames.MASTER, masterDataSource);
        targetDataSources.put(DataSourceNames.SALVER, salverDataSource);
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.afterPropertiesSet();
        return dynamicDataSource;
    }

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier(value = "dataSource") DataSource dataSource) throws IOException {
        try {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            ResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource configuration = resourceLoader.getResource(env.getProperty("mybatis.configuration"));
            Resource[] mapperLocations = new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations"));
            sqlSessionFactoryBean.setConfigLocation(configuration);
            sqlSessionFactoryBean.setMapperLocations(mapperLocations);
            sqlSessionFactoryBean.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));
            return sqlSessionFactoryBean;
        } catch (Exception e) {
            logger.error("Could not confiure mapper.mapper session factory", e);
            return null;
        }
    }

    /**
     * 事务
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager(@Qualifier(value = "dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
