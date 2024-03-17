package Database;

import java.util.ArrayList;

import ImageDrawer.ImageData;
import ImageDrawer.TableImage;

public class ImageQuery {
	private ImageBase ib;
	private String tableName;
	
	public void setDimension(int x, int y) {
		ib.setDimension(x, y); // lol
	}
	
	public ImageQuery(ImageBase ib) {
		this.ib = ib;
	}
	
	public void write(String s) {
		write(s, tableName);
	}
	
	public void write(String s, String tableName) {
		TableImage ti = ib.findOrMake(tableName);
		printSuccess(s);
		ti.paintString(s);
	}
	
	public ArrayList<String> read(){
		return read(tableName);
	}
	
	public ArrayList<String> read(String tableName) {
		TableImage ti = ib.findOrMake(tableName);
		return ti.read();
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public void printSuccess(String s) {
		if (s.length() > 10) {
			System.out.println("Message: " + s.substring(0, 10) + "... is written successfully!");
		}
		else {
			System.out.println("Message: " + s + " is written successfully!");
		}
	}
}
