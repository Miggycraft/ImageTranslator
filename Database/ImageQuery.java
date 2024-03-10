package Database;

import ImageDrawer.ImageData;
import ImageDrawer.TableImage;

public class ImageQuery {
	private ImageBase ib;
	
	public ImageQuery(ImageBase ib) {
		this.ib = ib;
	}
	/*
	 * ImageBase ib = new ImageBase...
	 * ImageQuery iq = new ImageQuery(ib) parang connected sila
	 * iq.write("string here or something blah2", "Table_1") it stores/access from table_1
	 * 
	 */
	
	public void write(String s, String tableName) {
		TableImage ti = ib.findOrMake(tableName);
		ti.paintString(s);
	}
	
	public void read(String tableName) {
		TableImage ti = ib.findOrMake(tableName);
		ti.read();
	}
}
