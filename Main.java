import java.util.Arrays;

import DataTranslator.*;

public class Main {

	public static void main(String[] args) throws Exception { // improve throw
		String s = "Test string";
		Translator t = new Translator();
//		System.out.println(Arrays.toString(t.toHex(s)));
		System.out.println(t.toRGB(t.toHex(2))[0]);
	}

}

//[84, 101, 115, 
//116, 32, 115, 
//116, 114, 105, 
//110, 103]