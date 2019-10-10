package edu.mum.cs.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * similar to web.xml
 * 
 * @author rXing
 *
 */
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	/**
	 * Tell DispatchServlet about out controller classes and view files
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebApplicationContextConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
