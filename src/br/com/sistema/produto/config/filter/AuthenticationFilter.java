package br.com.sistema.produto.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

	    avoidFilterResources(request, response, chain );
		
		if ( null == req.getSession().getAttribute( "user" ) &&
			!req.getRequestURI().contains( "login" ) ){
			res.sendRedirect( req.getContextPath() + "/login/" );
			return;
		} else {
			chain.doFilter(req, res);
		}
	}

	private void avoidFilterResources(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String uri = ((HttpServletRequest)request).getRequestURI();
		
		if ( uri.indexOf("/css") > 0){
	        chain.doFilter(request, response);
	    }
	    else if( uri.indexOf("/images") > 0){
	        chain.doFilter(request, response);
	    }
	    else if( uri.indexOf("/js") > 0){
	        chain.doFilter(request, response);
	    }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}
