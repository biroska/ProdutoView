package br.com.sistema.produto.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonParser {

	private static JSONParser jParser = new JSONParser();
	
	private static final Logger logger = LoggerFactory.getLogger(JsonParser.class);
	
	public static String get( String jSonString, String key ) throws ParseException{
		
		try {
			JSONObject jsonObject = ( JSONObject) jParser.parse( jSonString );
			return (String) jsonObject.get( key );
			
		} catch (ParseException e) {
//			e.printStackTrace();
			logger.error("[An error occurred]: ", e );
			
			throw e;
		}
		
	}

}
