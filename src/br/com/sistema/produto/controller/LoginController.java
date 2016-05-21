package br.com.sistema.produto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.sistema.produto.model.User;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	
    @RequestMapping(value="/login", method = RequestMethod.POST )
    public ModelAndView login( @ModelAttribute User user, HttpServletRequest request, HttpServletResponse response ) {

    	request.getSession().setAttribute("user", user );
    	
    	ModelAndView modelAndView = new ModelAndView("home");
        
        modelAndView.addObject("user", user );
        
        return modelAndView;
    }
}