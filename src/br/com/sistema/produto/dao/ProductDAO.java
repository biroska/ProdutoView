package br.com.sistema.produto.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import br.com.sistema.produto.model.Product;

@Repository
public class ProductDAO implements IproductDAO {
	
	private static List<Product> productList;
	
	static {
		productList = new ArrayList<Product>();
		
		for ( int i = 0; i <= 19; i++ ){
			productList.add( new Product( String.valueOf( i ), "Produto_" + i , "Bla bla " + i ) );
		}
	}
	
	public ProductDAO (){}
	
	@Override
	public List<Product> searchProducts( Product filter ){
		
		if ( filter == null || 
			 ( StringUtils.isBlank( filter.getCode() ) &&
			   StringUtils.isBlank( filter.getName() ) &&
			   StringUtils.isBlank( filter.getDescription() ) ) )
			return null;
		
		List<Product> retornoList = new ArrayList<Product>();
		
		for (Product item : productList) {
			
			if ( StringUtils.isNotBlank( filter.getCode() ) ){
			
				if ( item.getCode().contains( filter.getCode() ) ){
					retornoList.add( item );
				}
			}
		}
		
		return retornoList;
	}

}
