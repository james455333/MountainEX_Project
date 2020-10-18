package tester;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
	public static void main(String[] args) throws ParseException {
		String i = "insert into activity_summary values(hr.SEQUENCE_ACTIVITY_SUMMARY.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,to_date(sysdate,'yyyy-MM-dd'),0,?,?,?,?)";
		System.out.println(i.substring(126));
	}
	
	
	

}
