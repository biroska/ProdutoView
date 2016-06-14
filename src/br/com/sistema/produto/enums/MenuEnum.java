package br.com.sistema.produto.enums;

import org.apache.commons.lang3.StringUtils;

public enum MenuEnum {

	PRODUTO("PRODUTO", "/ProdutoView/product/"),
	BUSCA_PRODUTO("PRODUTO", "/ProdutoView/searchProduct/");
	
	private String menu;
	
	private String url;

	private MenuEnum(String menu, String url) {
		this.menu = menu;
		this.url = url;
	}
	
	public static String getMenuParameter( String url ){
		
		if ( StringUtils.isBlank( url ) ){
			return null;
		}
		
		for ( MenuEnum item : MenuEnum.values() ) {
			
			if ( item.getUrl().equals( url ) ){
				return item.getMenu();
			}
		}

		return null;
	}
	
	public String getUrl() {
		return url;
	}

	public String getMenu() {
		return menu;
	}
	
}