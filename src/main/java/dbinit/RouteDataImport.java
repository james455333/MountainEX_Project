package dbinit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import mountain.mountainList.service.NationalParkHibernateService;

public class RouteDataImport {

	public static void main(String[] args) {
		
		File file = new File("C:\\±MÃD\\MountainEX_Project/Mountain_UTF8.csv");
		try {
			CSVParser parser = csvRecords(file);
			List<CSVRecord> results = parser.getRecords();
			for (CSVRecord csvRecord : results) {
				String name = csvRecord.get("name");
				String description = csvRecord.get("description");
				String advice = csvRecord.get("advice");
				String traffic = csvRecord.get("traffic");
				String npName = csvRecord.get("npName");
				String imgURL = csvRecord.get("img_url");
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

	
	public static CSVParser csvRecords(File file) throws Exception {
		try (
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			){
			CSVParser parser = CSVFormat.EXCEL.withHeader().parse(br);
			return parser;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} throw new Exception("Unknow error or exception");
    
	}
}
