package mountain.test;

import java.text.NumberFormat;
import java.text.ParseException;

public class test {

	public static void main(String[] args) throws ParseException {
		String i = "15df66";
		System.out.println(i.matches("[0-9]{4}"));
	}

}
