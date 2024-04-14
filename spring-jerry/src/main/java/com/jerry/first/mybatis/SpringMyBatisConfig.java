package com.jerry.first.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@ComponentScan("com.jerry.first.mybatis")
@MapperScan("com.jerry.first.mybatis")
public class SpringMyBatisConfig {

	// 数据源
	@Bean("dataSource")
	public DataSource dataSource(){
		System.out.println("初始化数据源 DruidDataSource ");

		String url="jdbc:mysql://127.0.0.1:3306/test?useSSL=false&allowPublicKeyRetrieval=true";
		String username = "root";
		String password = "root";
		String driverClassName = "com.mysql.cj.jdbc.Driver";

		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setUsername(username);
		druidDataSource.setPassword(password);
		druidDataSource.setUrl(url);
		druidDataSource.setDriverClassName(driverClassName);

		return druidDataSource;
	}

	// 事物管理器
	@Bean
	public TransactionManager transactionManager(){
		return new DataSourceTransactionManager(dataSource());
	}

	// SqlSeesion工厂Bean
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		// 设置 MyBatis 配置文件路径
		factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		// 设置 SQL 映射文件路径
		factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
		// 这是类型别名
		factoryBean.setTypeAliases(Employee.class);
		return factoryBean;
	}
}