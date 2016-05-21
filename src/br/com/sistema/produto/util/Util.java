package br.com.sistema.produto.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Util {

	private static HashMap<String, SimpleDateFormat > sdfMap = new HashMap<String, SimpleDateFormat>(); 
	
	public static String dateToStr( String pattern ){
		return getSdf( pattern ).format( new Date() );
	}
	
	public static String dateToStr( Date date, String pattern ){
		return getSdf( pattern ).format(date);
	}
	
	private static SimpleDateFormat getSdf( String format ){
		SimpleDateFormat simpleDateFormat = sdfMap.get( format );
		
		if ( simpleDateFormat == null ){
			simpleDateFormat = new SimpleDateFormat( format );
			sdfMap.put( format, simpleDateFormat );
		}
		return simpleDateFormat;
	}
}