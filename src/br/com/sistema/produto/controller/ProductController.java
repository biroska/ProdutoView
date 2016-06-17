package br.com.sistema.produto.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

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
	
	public static void main (String args[]){
		try {
			
			String path = "C:/Users/Notebook/Desktop/testeImagens/";
			
			byte[] imageInByte;
			BufferedImage originalImage = ImageIO.read(new File(path + "bernardo.jpeg"));

			// convert BufferedImage to byte array
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "jpg", baos);
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();

			System.out.println("imageInByte: " + imageInByte );
			
			// convert byte array back to BufferedImage
			InputStream in = new ByteArrayInputStream(imageInByte);
			BufferedImage bImageFromConvert = ImageIO.read(in);
			
			System.out.println("bImageFromConvert: " + bImageFromConvert );

			ImageIO.write(bImageFromConvert, "jpg", new File(
					path + "bernardo_duplicado.jpeg"));

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void setFacade(Ifacade facade) {
		this.facade = facade;
	}
		
}