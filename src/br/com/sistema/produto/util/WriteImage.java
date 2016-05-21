package br.com.sistema.produto.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;

public class WriteImage {

	public static void base64Encode( String base64Image, String path ) throws IOException{
		try {
			byte[] imageInBytes = DatatypeConverter.parseBase64Binary( base64Image );
			
			InputStream in = new ByteArrayInputStream( imageInBytes );
			BufferedImage bImageFromConvert = ImageIO.read( in );
			ImageIO.write(bImageFromConvert, "jpg", new File( path ) );
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			throw e;
		}
		
		
	}
}
