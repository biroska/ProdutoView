package teste;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class TesteImagem {

	public static void main(String args[]) {
		try {

			String path = "C:/Users/Notebook/Desktop/testeImagens/";

			byte[] imageInByte;
			BufferedImage originalImage = ImageIO.read(new File(path + "bernardo.jpeg"));

			// convert BufferedImage to byte array
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "jpg", baos);
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();

			System.out.println("imageInByte: " + imageInByte);

			// convert byte array back to BufferedImage
			InputStream in = new ByteArrayInputStream(imageInByte);
			BufferedImage bImageFromConvert = ImageIO.read(in);

			System.out.println("bImageFromConvert: " + bImageFromConvert);

			ImageIO.write(bImageFromConvert, "jpg", new File(path + "bernardo_duplicado.jpeg"));

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}