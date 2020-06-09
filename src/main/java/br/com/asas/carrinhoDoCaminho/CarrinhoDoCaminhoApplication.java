package br.com.asas.carrinhoDoCaminho;

import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;
import java.util.Locale;


@SpringBootApplication
@ComponentScan(basePackages = {"br.com.asas.carrinhoDoCaminho.controller", "br.com.asas.carrinhoDoCaminho.service"})
@EnableJpaRepositories(basePackages = {"br.com.asas.carrinhoDoCaminho.repository"})
@EntityScan(basePackages = {"br.com.asas.carrinhoDoCaminho.model"})
@EnableSwagger2
public class CarrinhoDoCaminhoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrinhoDoCaminhoApplication.class, args);
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/carrinho_do_caminho");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");

		return dataSource;
	}

//	@Bean
//	public LocalResolver localResolver() {
//		SessionLocaleResolver slr = new SessionLocaleResolver();
//		slr.setDefaultLocale(Locale.US);
//	}
}
