package br.com.sistema.produto.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {

	private static JSONParser jParser = new JSONParser();
	
	public static String get( String jSonString, String key ) throws ParseException{
		
		try {
			JSONObject jsonObject = ( JSONObject) jParser.parse( jSonString );
			return (String) jsonObject.get( key );
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw e;
		}
		
	}

}
