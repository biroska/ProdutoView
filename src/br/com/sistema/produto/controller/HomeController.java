package br.com.sistema.produto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.sistema.produto.model.User;

@Controller
public class HomeController {
	
	@RequestMapping( method = RequestMethod.GET,
			         value={"/", "/index", "/index.jsp", "/home", "/home.jsp", "/login", "/login.jsp"})
	public ModelAndView mainPage( ) {
		
		ModelAndView modelAndView = new ModelAndView("login");
		
		modelAndView.addObject("user", new User() );
		
		return modelAndView;
	}
}
