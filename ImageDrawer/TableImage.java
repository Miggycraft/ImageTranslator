package ImageDrawer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TableImage {	
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
	
	public void init() throws IOException {
		BufferedImage image = new BufferedImage(id.getX(), id.getY(), BufferedImage.TYPE_INT_ARGB);
		
		ImageIO.write(image, "png", new File(id.getName() + ".png"));
	}
}
