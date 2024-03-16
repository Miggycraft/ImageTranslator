package ImageDrawer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
	
	public TableImage setImage(BufferedImage image) {
		this.image = image;
		return this;
	}
	
	public void setImage(String name) {
		try {
			image = ImageIO.read(new File(name + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public TableImage init() throws IOException {
		image = new BufferedImage(id.getX(), id.getY(), BufferedImage.TYPE_INT_ARGB);
		return this;
	}
	
	public void paintString(String s) {
	// TODO skip if may laman na
	// TODO throw error if nag ooverflow (meaning RGBArr is greater than length of canvas)
		if (image == null) {
			throw new NullPointerException("Image is null, try init() first");
		}
		
		Graphics g = image.getGraphics();
		Color[] RGBArr = Translator.toRGB(s);
		boolean flag = false;
		int i = 0;
		for (int y = 0; y < id.getY() && !flag; y++) {
			for (int x = 0; x < id.getX(); x++) {
				try {
					if (image.getRGB(x, y) == 0) {
						// TODO add black
						image.setRGB(x, y, RGBArr[i++].getRGB());
					}
				}
				catch(ArrayIndexOutOfBoundsException ex) {
					image.setRGB(x, y, Color.BLACK.getRGB());
					flag = true;
					break; // meaning ubos na si RGBArr
				}
			}
		}
		
		if (!flag) {
			image.setRGB(id.getX()-1, id.getY()-1, Color.BLACK.getRGB());
		}
		
		try {
			if (!new File(id.getDirectory()).exists()) // guard clause for checking folder exists
				new File(id.getDirectory()).mkdir();
			ImageIO.write(image, "png", new File(id.getDirectory() + id.getName() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> read(){
		ArrayList<String> output = new ArrayList<String>();
		if (image == null) {
			throw new NullPointerException("Image is null, try init() first");
		}
		
		if (image.getRGB(0, 0) == 0) { // empty image.
			return output;
		}
		StringBuilder temp = new StringBuilder();
		for (int y = 0; y < id.getY(); y++) {
			for (int x = 0; x < id.getX(); x++) {
		        int clr = image.getRGB(x, y);
		        if (clr == Color.BLACK.getRGB()) { // black
		        	output.add(temp.toString());
		        	temp.setLength(0);
		        }
		        int red = (clr & 0x00ff0000) >> 16;
		        int green = (clr & 0x0000ff00) >> 8;
		        int blue = clr & 0x000000ff;
		        try {			        	
		        	temp.append(Translator.readChar(red, green, blue));			        	
		        }
		        catch(Exception ex) {
		        	//throws an error when reading an empty color i think? maybe no need to fix this
		        }
			}
		}
		return output;
	}
}
