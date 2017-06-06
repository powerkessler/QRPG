package main;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Images {
	BufferedImage charactersprites;
	BufferedImage bulletsprites;
	
	public Images(){
		try {
			createSheets();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createSheets() throws IOException {
		charactersprites = ImageIO.read(new File("src/lib/character.png"));
		charactersprites = ImageIO.read(new File("src/lib/bullet.png"));
	}
	public BufferedImage createImage(String type, int size) {
		BufferedImage tmpImg;
		switch (type){
		case "character":
			tmpImg = charactersprites;
			break;
		case "bullet":
			tmpImg = bulletsprites;
			break;
		default:
			tmpImg = charactersprites;
			break;
		}
		BufferedImage tmpImg2 = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
		return tmpImg2;
	}
	
}
