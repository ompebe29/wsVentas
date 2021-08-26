package com.examen.wsVentas;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@PropertySource(value = "file:$(ENSAMBLIKA_WS)/wsVentas.properties", ignoreResourceNotFound=true)
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class WsVentasApplication extends SpringBootServletInitializer implements CommandLineRunner{
	
	@Autowired
	private Environment env;
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WsVentasApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(WsVentasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		try {
			//Configurator.initialize(null, System.getenv("ENSAMBLIKA_WS") + "/WSEstructurasITKlog.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Bean
	public WebMvcConfigurer corsConfigure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*")
						.allowedHeaders("*")
						.allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS");
			}
		};
	}
	
	@Bean
	@Qualifier("datasource")
	public DataSource dsVentas() {
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);
		DataSource dataSource = (DataSource) dsLookup.getDataSource(env.getProperty("DSWSVENTAS"));
		return dataSource;
	}
	

}
