import java.util.Arrays;

import DataTranslator.*;
import Database.*;
import ImageDrawer.*;

/**
 * 
 * @author Miggy
 * TODO
 * 	-append images by pixel rather than overrwriting them
 *  -a database should have multiple tables and you have to initialize your 
 *  	x, y there
 * 	-add a rule if there is a "painted color" already in the table then it moves
 *  	over to the next unpainted pixel
 * 	-add a way to read the colors and convert them back to texts
 * 	-(idea) what if we set canvas to black as a "stopper" when it comes to 
 * 		reading strings? like if you are reading string and then suddenly
 * 		changed the datatype to integer then add a black so java knows. actually
 * 		always assume that you read with string first, and then if you read a black
 * 		color (aka 0,0,0) then change your boolean to read numbers.
 */

public class Main {
	public static void main(String[] args) throws Exception { // improve throw
		ImageBase ib = new ImageBase();
		ImageQuery iq = new ImageQuery(ib);
//		iq.write("Hello this is a message", "image1");
		iq.read("image1");
	}
}