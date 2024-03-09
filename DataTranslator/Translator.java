package DataTranslator;

import java.util.ArrayList;

/**
 * 
 * purpose neto is to translate a given binary string (LITERAL STRING!)
 * to an array of hex codes.
 * 
 */

public class Translator {
	public int[] toHex(Object o) throws Exception{
		String b = Data.toBinary(o);
		ArrayList<String> binaryArr = new ArrayList<String>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		String temp = null;
		
		do{
			try {
				temp = b.substring(0, 8);
				binaryArr.add(temp);
				b = b.substring(8);
			}
			catch(Exception x) {
				b = compensate(b);
			}
		}
		while(!b.equals("00000000"));
		
		for (String s : binaryArr) {
			result.add(Integer.parseInt(s, 2));
		}
		
		return result.stream().mapToInt(i -> i).toArray();
	}
	
	private String compensate(String b) { // my pp is not smol...
		while(b.length() < 8) {
			b += '0';
		}
		return b;
	}
}
