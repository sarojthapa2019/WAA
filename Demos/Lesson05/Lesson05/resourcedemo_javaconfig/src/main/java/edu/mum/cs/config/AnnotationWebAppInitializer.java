package edu.mum.cs.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;

public class AnnotationWebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		servletContext.setInitParameter("spring.profiles.default", "dev");
		servletContext.setAttribute("appName", "Lesson05 JavaConfig Demo");
	}

}
