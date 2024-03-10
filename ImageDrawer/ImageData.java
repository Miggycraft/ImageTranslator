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
		directory = "\\";
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDirectory() {
		return directory;
	}
	
	public void setDirectory(String directory) {
		this.directory = directory;
	}
}
