package Database;

import ImageDrawer.ImageData;
import ImageDrawer.TableImage;

public class ImageQuery {
	private ImageBase ib;
	
	public ImageQuery(ImageBase ib) {
		this.ib = ib;
	}
	
	public void write(String s, String tableName) {
		TableImage ti = ib.findOrMake(tableName);
		ti.paintString(s);
	}
	
	public void read(String tableName) {
		TableImage ti = ib.findOrMake(tableName);
		ti.read();
	}
}
