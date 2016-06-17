package br.com.sistema.produto.service;

import java.util.List;

import br.com.sistema.produto.model.Product;


public interface Ifacade {

	public List<Product> searchProducts(Product filter);

}
