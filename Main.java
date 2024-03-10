import java.util.Arrays;

import DataTranslator.*;
import ImageDrawer.*;

public class Main {
	public static void main(String[] args) throws Exception { // improve throw
//		String s = "Test string";
//		Translator t = new Translator();
//		System.out.println(t.toRGB(t.toHex(12345))[0]);
		TableImage ti = new TableImage(new ImageData(25,25));
		ti.setImage("Table_DEFAULT");
//		ti.init();
//		ti.paintString("Hello my name is kyle\r\n"
//				+ "blah blah blah blah\r\n"
//				+ "lorem ipsum\r\n"
//				+ "wow amazing");
		ti.read();
	}
}

/**
 * TODO NEXT!
 * -initialize your database 
 * -a database should have multiple tables and you have to initialize your x, y there lawl
 * -add query that is connected to the Database
 * -Add a way to paint canvas in your "table"
 * -add a rule if there is a "painted color" already in the table then it moves over
 * to the next unpainted pixel
 * -add a way to read the colors and convert them back to texts
 * -(idea) what if we set canvas to black as a "stopper" when it comes to 
 * 		reading strings? like if you are reading string and then suddenly
 * 		changed the datatype to integer then add a black so java knows. actually
 * 		always assume that you read with string first, and then if you read a black
 * 		color (aka 0,0,0) then change your boolean to read numbers.
 */