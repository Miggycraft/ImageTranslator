package Database;

import java.io.IOException;
import java.util.ArrayList;

import ImageDrawer.ImageData;
import ImageDrawer.TableImage;

public class ImageBase {
	private ArrayList<TableImage> dataArr = new ArrayList<TableImage>();
	
	public TableImage findOrMake(String tableName) {
		for (TableImage im: dataArr) {
			if (im.getImageData().getClass().equals(tableName)) {
				return im;
			}
		}
		
		/*
		 * Default values: 100,100 px
		 * Table_DEFAULT
		 */
		try {
			return new TableImage(new ImageData(100,100)).init();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		return null;
	}
}
