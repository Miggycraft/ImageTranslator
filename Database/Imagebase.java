package Database;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import ImageDrawer.ImageData;
import ImageDrawer.TableImage;

public class ImageBase {
	private String name = "default"; //used for directory
	private String DEFAULT_PATHWAY = System.getProperty("user.dir");
	private ArrayList<TableImage> dataArr = new ArrayList<TableImage>();
	
	private String getPath() {
		return DEFAULT_PATHWAY + "\\" + name;
	}
	
	private boolean exists(ImageData im, String tableName) {
		return (im.getName() == tableName && im.getTrueDirectory() == name);
	}
	
	private boolean exists(String tableName) { // file search
		File f = new File(getPath() + "\\" + tableName + ".png");
		return f.exists();
	}
	
	public TableImage findOrMake(String tableName) {		
		for (TableImage ti: dataArr) { // iteration over existing lists
			if (exists(ti.getImageData(), tableName)) {
				ImageData temp = ti.getImageData();
				temp.setDirectory(name);
				temp.setName(tableName);
				ti.setImageData(temp);
				return ti;
			}
		}
		
		
		if (exists(tableName)) {
			try {
				BufferedImage bimg = ImageIO.read(new File(getPath() + "\\" + tableName + ".png"));
				int width = bimg.getWidth();
				int height = bimg.getHeight();
				ImageData temp = new ImageData(width, height, name, tableName);
				return new TableImage(temp).setImage(bimg);
			} catch (IOException e) {
				// should be impossible because exists already checks for this.
				e.printStackTrace();
				System.exit(1);
			}
		}
		
		/* 
		 * --- MAKE ---
		 * Default values: 100,100 px
		 * Table_DEFAULT
		 */
		try {
			TableImage temp = new TableImage(new ImageData(100,100)).init();
			temp.getImageData().setDirectory(name);
			temp.getImageData().setName(tableName);
			dataArr.add(temp);
			return temp;
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		return null;
	}
	
	public void add(TableImage im) {
		dataArr.add(im);
	}
	
	public void setName(String name) {
		// TODO add conficlting database name
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
