package br.com.sistema.produto.config.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import br.com.sistema.produto.config.WebAppConfig;
import br.com.sistema.produto.config.filter.AuthenticationFilter;

public class webAppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebAppConfig.class);
		
		servletContext.addListener(new ContextLoaderListener(ctx));
		
		/*
		 * Filter configuration
		 * */
		
		servletContext.addFilter("AuthenticationFilter", AuthenticationFilter.class).addMappingForUrlPatterns(null, false, "/*");
		
		ctx.setServletContext(servletContext);

		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}
}