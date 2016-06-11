package br.com.sistema.produto.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WriteImage {
	
	private static final Logger logger = LoggerFactory.getLogger(WriteImage.class);

	public static void base64Encode( String base64Image, String path ) throws IOException{
		try {
			byte[] imageInBytes = DatatypeConverter.parseBase64Binary( base64Image );
			
			InputStream in = new ByteArrayInputStream( imageInBytes );
			BufferedImage bImageFromConvert = ImageIO.read( in );
			ImageIO.write(bImageFromConvert, "jpg", new File( path ) );
			
		} catch (IOException e) {
//			e.printStackTrace();
			logger.error("[An error occurred]: ", e );
			throw e;
		}
		
		
	}
}
