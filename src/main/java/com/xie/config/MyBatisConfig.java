package com.xie.config;


import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@EnableConfigurationProperties
@Configuration
@MapperScan("com.xie.dao")
public class MyBatisConfig {
    private static final Logger logger = LoggerFactory.getLogger(MyBatisConfig.class);

    @Autowired
    private JdbcConfig jdbcConfig;

    /**
     * mybatis 配置路径
     */
    private static String MYBATIS_CONFIG = "/config/mybatis-config.xml";
    /**
     * mybatis mapper resource 路径
     */
    private static String MAPPER_PATH = "/mapper/**.xml";

    @Autowired
    private DataSource dataSource;

    private String typeAliasPackage = "com.xie.model.bean";

    @Bean
    public DataSource dataSource() throws SQLException {
        return DataSourceBuilder.create(Thread.currentThread().getContextClassLoader())
                .driverClassName(jdbcConfig.getDriver())
                .url(jdbcConfig.getUrl())
                .username(jdbcConfig.getUsername())
                .password(jdbcConfig.getPassword()).build();
    }

    @Bean
    public DataSourceTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        /** 设置mybatis configuration 扫描路径 */
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(MYBATIS_CONFIG));
        /** 添加mapper 扫描路径 */
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + MAPPER_PATH;
        sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
        /** 设置datasource */
        sqlSessionFactoryBean.setDataSource(dataSource);
        /** 设置typeAlias 包扫描路径 */
        sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);
        return sqlSessionFactoryBean;
    }

    @ConfigurationProperties(prefix = "spring.datasource")
    @Component
    static class JdbcConfig {
        /**
         * 数据库用户名
         */
        private String username;
        /**
         * 驱动名称
         */
        private String driver;
        /**
         * 数据库连接url
         */
        private String url;
        /**
         * 数据库密码
         */
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
