package br.com.sistema.produto.dao;

import java.util.List;

import br.com.sistema.produto.model.Product;

public interface IproductDAO {

	public List<Product> searchProducts(Product filter);

}
