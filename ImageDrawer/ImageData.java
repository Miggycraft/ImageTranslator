package ImageDrawer;

public class ImageData {
	private int x;
	private int y;
	private String name;
	private String directory;
	
	public ImageData(int x, int y) {
		this.x = x;
		this.y = y;
		name = "Table_DEFAULT";
		directory = "";
	}
	
	public ImageData(int x, int y, String name) {
		this.x = x;
		this.y = y; 
		this.name = name;
	}
	
	
	public ImageData(int x, int y, String name, String directory) {
		this(x,y,name);
		this.directory = directory;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public ImageData setXY(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	public ImageData setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getTrueDirectory() {
		return directory;
	}
	
	public String getDirectory() {
		return System.getProperty("user.dir") + "\\" + directory + "\\";
	}
	
	public ImageData setDirectory(String directory) {
		this.directory = directory;
		return this;
	}
}
