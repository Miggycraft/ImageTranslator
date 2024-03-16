package Database;

import java.util.ArrayList;

import ImageDrawer.ImageData;
import ImageDrawer.TableImage;

public class ImageQuery {
	private ImageBase ib;
	
	public void setDimension(int x, int y) {
		ib.setDimension(x, y); // lol
	}
	
	public ImageQuery(ImageBase ib) {
		this.ib = ib;
	}
	
	public void write(String s, String tableName) {
		TableImage ti = ib.findOrMake(tableName);
		ti.paintString(s);
	}
	
	public ArrayList<String> read(String tableName) {
		TableImage ti = ib.findOrMake(tableName);
		return ti.read();
	}
}
