package br.com.sistema.produto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistema.produto.dao.IproductDAO;
import br.com.sistema.produto.model.Product;

@Service
public class Facade implements Ifacade {

	@Autowired
	private IproductDAO productDAO;
	
	@Override
	public List<Product> searchProducts( Product filter ){
		
		return productDAO.searchProducts( filter );
	}

	public void setProductDAO(IproductDAO productDAO) {
		this.productDAO = productDAO;
	}

}
