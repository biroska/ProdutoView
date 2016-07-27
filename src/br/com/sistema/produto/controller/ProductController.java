package br.com.sistema.produto.controller;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.sistema.produto.model.Product;
import br.com.sistema.produto.model.User;
import br.com.sistema.produto.service.Ifacade;
import br.com.sistema.produto.util.Constants;
import br.com.sistema.produto.util.JsonParser;
import br.com.sistema.produto.util.Util;
import br.com.sistema.produto.util.WriteImage;

@Controller
@RequestMapping(value="/product")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private Ifacade facade;
	
	@RequestMapping( value={"/", "/product"})
	public ModelAndView mainPage( ) {
		
		ModelAndView modelAndView = new ModelAndView("produto");
		
		modelAndView.addObject("user", new User() );
		modelAndView.addObject("produto", new Product() );
		
		return modelAndView;
	}
	

	@RequestMapping( value={"/searchProduct"})
	public ModelAndView searchProduct( ) {
		
		ModelAndView modelAndView = new ModelAndView("consultarProduto");
		
		modelAndView.addObject("user", new User() );
		modelAndView.addObject("produto", new Product() );
		
		facade.searchProducts( new Product( "5", "Produto_5" , "Bla bla 5" ) );
		
		return modelAndView;
	}

	@RequestMapping( value={"/save"}, method = RequestMethod.POST, 
					 produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE )
	public @ResponseBody Product save( @RequestBody Product produto  ) {
		
		produto.setName( produto.getName() + " Alterado" );
		produto.setCode( produto.getCode() + " Alterado" );
		produto.setDescription( produto.getDescription() + " Alterado" );
		
		return produto;
	}
	
	@RequestMapping( value={"/testeCaptura"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String captureImage( @RequestBody String base64JsonImage ) {

		String base64Image = null;
		
		try {
			base64Image = JsonParser.get( base64JsonImage, "base64Image" );
			String imageName = "imagemCapturda" + Util.dateToStr("yyyyMMddHHmmss");
			
			WriteImage.base64Encode( base64Image, Constants.FILES.IMAGE_PATH + imageName + 
												  Constants.FILES.IMAGE_FILE_SEPARATOR + 
												  Constants.FILES.IMAGE_FILE_EXTENSION );
		} catch (ParseException e) {
//			e.printStackTrace();
			logger.error("[An error occurred]: ", e );
			
		} catch (IOException e) {
//			e.printStackTrace();
			logger.error("[An error occurred]: ", e );
		}
		return base64Image;
	}
	
	@RequestMapping(value = {"/testJSON" },
					method = RequestMethod.POST,
					produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String testJSON() {

		JSONObject obj = new JSONObject();
		
		JSONArray list = new JSONArray();
		
		JSONObject j = new JSONObject();
		  j.put("first_name", "Airi");
		  j.put("last_name", "Satou");
		  j.put("position", "Accountant");
		  j.put("office", "Tokyo");
		  j.put("start_date", "28th Nov 08");
		  j.put("salary", "$162,700");
		list.add( j );
		j = new JSONObject();
		  j.put("first_name", "Angelica");
		  j.put("last_name", "Ramos");
		  j.put("position", "Chief Executive Officer (CEO)");
		  j.put("office", "London");
		  j.put("start_date", "9th Oct 09");
		  j.put("salary", "$1,200,000");
		list.add( j );
		j = new JSONObject();
		  j.put("first_name", "Ashton");
		  j.put("last_name", "Cox");
		  j.put("position", "Junior Technical Author");
		  j.put("office", "San Francisco");
		  j.put("start_date", "12th Jan 09");
		  j.put("salary", "$86,000");
		list.add( j );
		j = new JSONObject();
		  j.put("first_name", "Bradley");
		  j.put("last_name", "Greer");
		  j.put("position", "Software Engineer");
		  j.put("office", "London");
		  j.put("start_date", "13th Oct 12");
		  j.put("salary", "$132,000");
		list.add( j );
		j = new JSONObject();
		  j.put("first_name", "Brenden");
		  j.put("last_name", "Wagner");
		  j.put("position", "Software Engineer");
		  j.put("office", "San Francisco");
		  j.put("start_date", "7th Jun 11");
		  j.put("salary", "$206,850");
		list.add( j );
		j = new JSONObject();
		  j.put("first_name", "Brielle");
		  j.put("last_name", "Williamson");
		  j.put("position", "Integration Specialist");
		  j.put("office", "New York");
		  j.put("start_date", "2nd Dec 12");
		  j.put("salary", "$372,000");
		list.add( j );
		j = new JSONObject();
		  j.put("first_name", "Bruno");
		  j.put("last_name", "Nash");
		  j.put("position", "Software Engineer");
		  j.put("office", "London");
		  j.put("start_date", "3rd May 11");
		  j.put("salary", "$163,500");
		list.add( j );
		j = new JSONObject();
		  j.put("first_name", "Caesar");
		  j.put("last_name", "Vance");
		  j.put("position", "Pre-Sales Support");
		  j.put("office", "New York");
		  j.put("start_date", "12th Dec 11");
		  j.put("salary", "$106,450");
		list.add( j );
		j = new JSONObject();
		  j.put("first_name", "Cara");
		  j.put("last_name", "Stevens");
		  j.put("position", "Sales Assistant");
		  j.put("office", "New York");
		  j.put("start_date", "6th Dec 11");
		  j.put("salary", "$145,600");
		list.add( j );
		j = new JSONObject();
		  j.put("first_name", "Cedric");
		  j.put("last_name", "Kelly");
		  j.put("position", "Senior Javascript Developer");
		  j.put("office", "Edinburgh");
		  j.put("start_date", "29th Mar 12");
		  j.put("salary", "$433,060");
		list.add( j );
		
		j = new JSONObject();
		  j.put("first_name", "Airi2");
		  j.put("last_name", "Satou2");
		  j.put("position", "Accountant");
		  j.put("office", "Tokyo");
		  j.put("start_date", "28th Nov 08");
		  j.put("salary", "$162,700");
		list.add( j );
		j = new JSONObject();
		  j.put("first_name", "Angelica2");
		  j.put("last_name", "Ramos2");
		  j.put("position", "Chief Executive Officer (CEO)");
		  j.put("office", "London");
		  j.put("start_date", "9th Oct 09");
		  j.put("salary", "$1,200,000");
		list.add( j );
		j = new JSONObject();
		  j.put("first_name", "Ashton2");
		  j.put("last_name", "Cox2");
		  j.put("position", "Junior Technical Author");
		  j.put("office", "San Francisco");
		  j.put("start_date", "12th Jan 09");
		  j.put("salary", "$86,000");
		list.add( j );
		j = new JSONObject();
		  j.put("first_name", "Bradley2");
		  j.put("last_name", "Greer2");
		  j.put("position", "Software Engineer");
		  j.put("office", "London");
		  j.put("start_date", "13th Oct 12");
		  j.put("salary", "$132,000");
		list.add( j );
		j = new JSONObject();
		  j.put("first_name", "Brenden2");
		  j.put("last_name", "Wagner2");
		  j.put("position", "Software Engineer");
		  j.put("office", "San Francisco");
		  j.put("start_date", "7th Jun 11");
		  j.put("salary", "$206,850");
		list.add( j );
		j = new JSONObject();
		  j.put("first_name", "Brielle2");
		  j.put("last_name", "Williamson2");
		  j.put("position", "Integration Specialist");
		  j.put("office", "New York");
		  j.put("start_date", "2nd Dec 12");
		  j.put("salary", "$372,000");
		list.add( j );
		j = new JSONObject();
		  j.put("first_name", "Bruno2");
		  j.put("last_name", "Nash2");
		  j.put("position", "Software Engineer");
		  j.put("office", "London");
		  j.put("start_date", "3rd May 11");
		  j.put("salary", "$163,500");
		list.add( j );
		j = new JSONObject();
		  j.put("first_name", "Caesar2");
		  j.put("last_name", "Vance2");
		  j.put("position", "Pre-Sales Support");
		  j.put("office", "New York");
		  j.put("start_date", "12th Dec 11");
		  j.put("salary", "$106,450");
		list.add( j );
		j = new JSONObject();
		  j.put("first_name", "Cara2");
		  j.put("last_name", "Stevens2");
		  j.put("position", "Sales Assistant");
		  j.put("office", "New York");
		  j.put("start_date", "6th Dec 11");
		  j.put("salary", "$145,600");
		list.add( j );
		j = new JSONObject();
		  j.put("first_name", "Cedric2");
		  j.put("last_name", "Kelly2");
		  j.put("position", "Senior Javascript Developer");
		  j.put("office", "Edinburgh");
		  j.put("start_date", "29th Mar 12");
		  j.put("salary", "$433,060");
		list.add( j );
		
		obj.put("data", list);
		
		obj.put("recordsTotal", ""+list.size() );
		obj.put("recordsFiltered", ""+list.size() );
		obj.put("draw","1");

		System.out.print(obj.toJSONString());

		return obj.toJSONString();
	}
	
	public void setFacade(Ifacade facade) {
		this.facade = facade;
	}
		
}