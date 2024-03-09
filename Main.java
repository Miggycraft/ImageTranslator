import java.util.Arrays;

import DataTranslator.*;

public class Main {

	public static void main(String[] args) throws Exception { // improve throw
		String s = "Test string";
		Translator t = new Translator();
		System.out.println(Arrays.toString(t.toHex(1234)));
	}

}

//10011010, 01000000 = right