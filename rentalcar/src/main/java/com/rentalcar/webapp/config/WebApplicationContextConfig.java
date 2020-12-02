package com.rentalcar.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration //così spring capisce che è una classe di configurazione
@EnableWebMvc  // attivazione delle notazioni primarie
@ComponentScan(basePackages = "com.rentalcar.webapp")  //specifica a spring dove andare a cercare il controller
public class WebApplicationContextConfig implements WebMvcConfigurer
{
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}
	
	@Override  //stiamo dicendo di non utilizzare più solo il view resolver di default ma anche quello con le tiles
	public void configureViewResolvers(ViewResolverRegistry registry)
	{
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
		
	}
	
	@Bean   //questo bean ci permetto di risolvere i dati grezzi che riceviamo dal controller e trasformarli con il view resolver
	public InternalResourceViewResolver getInternalResourceViewResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
}
