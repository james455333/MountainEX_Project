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

public class RouteDataImport {

	public static void main(String[] args) {
		
		
		
		
		
		

	}

	
	public static List<CSVRecord> csvRecords(File file) throws Exception {
		try (
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			){
			CSVParser parser = CSVFormat.EXCEL.withHeader().parse(br);
			List<CSVRecord> results = parser.getRecords();						
			return results;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} throw new Exception("Unknow error or exception");
    
	}
}
