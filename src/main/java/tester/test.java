package tester;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
	public static void main(String[] args) throws ParseException {
		Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
		Path filePath = Paths.get(root.toString(),"src", "main", "resources");
		System.out.println("root : " + root.toString());
		String property = System.getProperty("user.dir")+"\\src\\main\\webapp\\mountain\\images/";
		System.out.println(property);
	}
	
	
	

}
