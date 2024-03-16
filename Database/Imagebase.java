package Database;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import ImageDrawer.ImageData;
import ImageDrawer.TableImage;

public class ImageBase {
	private String name; //used for directory
	private String DEFAULT_PATHWAY = System.getProperty("user.dir");
	private ArrayList<TableImage> dataArr = new ArrayList<TableImage>();
	private int x = 100;
	private int y = 100;
	
	public ImageBase() {
		this("default");
	}
	
	public ImageBase(String name) {
		this.name = name;
		init();
	}
	
	private String getPath() {
		return DEFAULT_PATHWAY + "\\" + name;
	}
	
	private void init() {
		File f = new File(getPath() + "\\");
		
		if (!f.exists())
			return; // no content inside
		
		for (File item: f.listFiles()) {
			try {
				String name = item.getName();
				if ("png".equals(name.substring(name.length() -3, name.length()))){
					BufferedImage bimg = ImageIO.read(new File(getPath() + "\\" + name));
					int width = bimg.getWidth();
					int height = bimg.getHeight();
					ImageData temp = new ImageData(width, height, this.name, name);
					dataArr.add(new TableImage(temp).setImage(bimg));
				}
			}
			catch(StringIndexOutOfBoundsException x) {
				continue; // for file names less than 3
			}
			catch(Exception x) {
//				x.printStackTrace();
				continue; // for cases na png ang final but not actually png
			}
		}
	}
	
	private boolean exists(ImageData im, String tableName) {
		tableName += ".png";
		return (im.getName().equals(name) && im.getTrueDirectory().equals(tableName));
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
		
		if (exists(tableName)) { // init() already does but for runtime to, if implemented lol
			try {
				BufferedImage bimg = ImageIO.read(new File(getPath() + "\\" + tableName + ".png"));
				int width = bimg.getWidth();
				int height = bimg.getHeight();
				ImageData temp = new ImageData(width, height, tableName, name);
				return new TableImage(temp).setImage(bimg);
			} catch (IOException e) {
				// should be impossible because exists already checks for this.
				e.printStackTrace();
				System.exit(1);
			} catch (NullPointerException e) {
				throw new NullPointerException("Image is corrupted!");
			}
		}
		/* 
		 * --- MAKE ---
		 * Default values: 100,100 px
		 * Table_DEFAULT
		 */
		try {
			TableImage temp = new TableImage(new ImageData(this.x, this.y)).init();
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
	
	public String getName() {
		return name;
	}
	
	public void setDimension(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
