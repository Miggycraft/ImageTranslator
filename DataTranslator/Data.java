package DataTranslator;

/**
 * pleaes understand that the Datatype translated to binary supports
 *	ASCII encoding only, not UTF KAY YAWA MAN! :3
 */

public class Data {
	final Object[] SUPPORTED_CLASS = 
		{String.class, Integer.class, Long.class};
	int classIndex = -1;
	
	public String toBinary(Object o) throws Exception {
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

	private String readString(String s) {
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar))   // char -> int, auto-cast
                            .replaceAll(" ", "0")                         // zero pads
            );
        }
        return result.toString();
	}

	private String readInt(Integer o) {
		return null;
	}
	
	private String readLong(Long o) {
		return null;
	}

}
