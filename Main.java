import DataTranslator.*;

public class Main {

	public static void main(String[] args) throws Exception { // improve throw
		String s = "Test string";
		Data d = new Data();
		System.out.println(d.toBinary(s));
	}

}
