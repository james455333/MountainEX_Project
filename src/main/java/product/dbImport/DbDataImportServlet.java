package product.dbImport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


@WebServlet("/product/DbDataImportServlet")
public class DbDataImportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String imgTitle = "imgShop";
	private static int imgNum = 1;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String path1 = "C:\\imges/imgShop1.jpg";
//		path1 = path1.concat(imgTitle);
//		String imgNUMString = String.valueOf(imgNum++);
//		path1 = path1.concat(imgNUMString + ".jpg");
		File file = new File("");
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		CSVParser parse = CSVFormat.EXCEL.withHeader().parse(isr);
		List<CSVRecord> records = parse.getRecords();
		
		for (CSVRecord csvRecord : records) {
			String string = csvRecord.get("");
		}
		
		
		String url = "";
		InputStream is = new URL(url).openStream();
		
	
	}

}
