package DataTranslator;

/**
 * pleaes understand that the Datatype translated to binary supports
 * ASCII encoding only, not UTF KAY YAWA MAN! :3 
 */

public class Data {
	final static Object[] SUPPORTED_CLASS = 
		{String.class, Integer.class, Long.class}; //INTEGER AND LONG CLASS ARE STUPID, better if we set to string only!
	static int classIndex = -1;
	
	public static String toBinary(Object o) throws Exception {
		String binaryString = "";
		Object classType = o.getClass();
		int i = 0;
		for (Object supportedType : SUPPORTED_CLASS) {
			if (classType.equals(supportedType)) {
				classIndex = i;
			}
			i++;
		}
		
		if (classIndex == -1) { // meaning unsupported
			throw new NoSuchFieldException("Given datatype " + o.getClass() + " is not supported!");
		}
		
		switch(classIndex) {
		case 0: // string
			binaryString = readString((String)o);
			break;
		case 1: // int
			binaryString = readInt((Integer)o);
			break;
		case 2: // long
			binaryString = readLong((Long)o);
			break;
		default:
			throw new Exception("Class index overflow");
		}
		
		return binaryString;
	}

	private static String readString(String s) {
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            result.append(
            	String.format("%8s", Integer.toBinaryString(aChar))
            	.replaceAll(" ", "0")
            );
        }
        return result.toString();
	}

	private static String readInt(Integer i) {
		StringBuilder result = new StringBuilder();
		
		while (i > 0) {
			if (i % 2 == 0)
				result.append('0');
			else
				result.append('1');
			i /= 2;
		}
		
		return result.reverse().toString();
	}
	
	private static String readLong(Long l) {
		/**
		 * as of now same purpose lang sila with int but chances are...
		 * actually idk why i made a long version whoops
		 */
		StringBuilder result = new StringBuilder();
		
		while (l > 0) {
			if (l % 2 == 0)
				result.append('0');
			else
				result.append('1');
			l /= 2;
		}
		
		return result.reverse().toString();
	}

}
