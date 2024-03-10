package DataTranslator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 
 * purpose neto is to translate a given binary string (LITERAL STRING!)
 * to an array of hex codes.
 * 
 */

public class Translator {
	public static Color[] toRGB(Object o) {
		return toRGB(toHex(o));
	}
	
	public static Color[] toRGB(int[] arr) {
		ArrayList<Integer> fixedArr = (ArrayList<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toList());
		ArrayList<Color> colorArr = new ArrayList<Color>();
		while(fixedArr.size() % 3 != 0) {
			fixedArr.add(0);
		}
		
		for (int i = 0; i < fixedArr.size();) {
			int r = fixedArr.get(i++);
			int g = fixedArr.get(i++);
			int b = fixedArr.get(i++);
			colorArr.add(new Color(r,g,b)); // out of bounds is impossible.. right?
		}

		return colorArr.toArray(Color[]::new);
	}
	
	public static void readChar(int r, int g, int b) throws Exception {
		String sR = Data.toBinary(r);
		String sG = Data.toBinary(g);
		String sB = Data.toBinary(b);
		System.out.print((char)(Integer.parseInt(sR,2)));
		System.out.print((char)(Integer.parseInt(sG,2)));
		System.out.print((char)(Integer.parseInt(sB,2)));
	}
	
	public static int[] toHex(Object o){
		String b = null;
		try {
			b = Data.toBinary(o);		
		}
		catch(NoSuchFieldException x) {
			x.printStackTrace(); // invalid given object
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace(); // index overflow.
			System.exit(1);
		}
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
	
	private static String compensate(String b) {
		while(b.length() < 8) {
			b += '0';
		}
		return b;
	}
}
