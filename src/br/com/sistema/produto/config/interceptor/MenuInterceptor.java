package br.com.sistema.produto.config.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import br.com.sistema.produto.enums.MenuEnum;
import br.com.sistema.produto.util.Constants;

public class MenuInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
    	
    	System.out.println("MenuInterceptor.preHandle()");
    	String menuNavigation = MenuEnum.getMenuParameter( httpServletRequest.getRequestURI() );
    	
    	if ( StringUtils.isNotBlank( menuNavigation ) ){
    		httpServletRequest.getSession( true ).setAttribute( Constants.MENU_PARAM, menuNavigation );
    	}
    	
    	return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    	
    	System.out.println("MenuInterceptor.postHandle()");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    	
    	System.out.println("MenuInterceptor.afterCompletion()");
    	
    }
}