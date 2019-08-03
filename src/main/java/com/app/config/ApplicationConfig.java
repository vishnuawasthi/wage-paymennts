
package com.app.config;

import javax.sql.DataSource;

import org.apache.camel.component.mybatis.MyBatisComponent;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*@ComponentScan(basePackages={
"com.app.config",
"com.app.routes",
"com.app.controller",
"com.app.dao",
"com.app.service",
"com.app.utils"


})*/
//@EnableWebMvc
@Configuration
public class ApplicationConfig {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resourceView = new InternalResourceViewResolver();
		resourceView.setPrefix("/WEB-INF/jsp/");
		resourceView.setSuffix(".jsp");
		return resourceView;
	}

	/*
	 * @Bean public DataSource dataSource(){ try { InitialContext cxt = new
	 * InitialContext(); DataSource ds = (DataSource) cxt.lookup(
	 * "java:/comp/env/jdbc/postgresDB" ); return ds; } catch (NamingException e) {
	 * e.printStackTrace(); } return null; }
	 */

	@Bean
	public DataSource driverManagerDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/POC_SCHEMA");
		dataSource.setUsername("POC_ADMIN");
		dataSource.setPassword("login@123");
		return dataSource;
	}

	@Bean
	@DependsOn("driverManagerDataSource")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("driverManagerDataSource") DriverManagerDataSource driverManagerDataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(driverManagerDataSource);
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	@DependsOn("driverManagerDataSource")
	public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("driverManagerDataSource") DriverManagerDataSource driverManagerDataSource) {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(driverManagerDataSource);
		return dataSourceTransactionManager;
	}

	@Bean(name = "myBatisComponent")
	@DependsOn("sqlSessionFactory")
	public MyBatisComponent batisComponent(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory)throws Exception {
		MyBatisComponent batisComponent = new MyBatisComponent();
		batisComponent.setSqlSessionFactory(sqlSessionFactory);
		return batisComponent;
	}

}
