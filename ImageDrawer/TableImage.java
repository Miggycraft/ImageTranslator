package ImageDrawer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import DataTranslator.Translator;

import javax.imageio.ImageIO;

public class TableImage {	
	private BufferedImage image;
	private ImageData id;
	
	public TableImage() {}
	
	public TableImage(ImageData id) {
		this.id = id;
	}
	
	public void setImageData(ImageData id) {
		this.id = id;
	}
	
	public ImageData getImageData() {
		return id;
	}
	
	public void setImage(String name) {
		try {
			image = ImageIO.read(new File(name + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void init() throws IOException {
		image = new BufferedImage(id.getX(), id.getY(), BufferedImage.TYPE_INT_ARGB);
		
		ImageIO.write(image, "png", new File(id.getName() + ".png"));
	}
	
	public void paintString(String s) {
	// TODO skip if may laman na
	// TODO throw error if nag ooverflow (meaning RGBArr is greater than length of canvas)
		if (image == null) {
			throw new NullPointerException("Image is null, try init() first");
		}
		
		Graphics g = image.getGraphics();
		
		Color[] RGBArr = Translator.toRGB(s);
		int i = 0;
		for (int y = 0; y < id.getY(); y++) {
			for (int x = 0; x < id.getX(); x++) {
				try {
					image.setRGB(x, y, RGBArr[i++].getRGB());
				}
				catch(ArrayIndexOutOfBoundsException ex) {
					break; // meaning ubos na si RGBArr
				}
			}
		}			
		
		try {
			ImageIO.write(image, "png", new File(id.getName() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public TableImage findOrMake() {
		// TODO
		return null;
	}
	
	public void read() throws Exception {
		if (image == null) {
			throw new NullPointerException("Image is null, try init() first");
		}
		
		boolean flag = false; // just so no checking on y.
		
		for (int y = 0; y < id.getY() && !flag; y++) {
			for (int x = 0; x < id.getX(); x++) {
				if (image.getRGB(x, y) == 0) { // empty image.
					flag = true;
					break;
				}
				else {
			        int clr = image.getRGB(x, y);
			        int red =   (clr & 0x00ff0000) >> 16;
			        int green = (clr & 0x0000ff00) >> 8;
			        int blue =   clr & 0x000000ff;
			        Translator.readChar(red, green, blue);
				}
			}
		}
	}
}
