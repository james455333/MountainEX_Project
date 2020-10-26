package mountain.dbint;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import mountain.mountainList.dao.RouteBasicHibernateDAO;
import mountain.mountainList.model.NationalPark;
import mountain.mountainList.model.RouteBasic;
import mountain.mountainList.model.RouteInfo;
import mountain.mountainList.service.NationalParkHibernateService;
import mountain.mountainList.service.RouteBasicHibernateService;
import mountain.mountainList.service.impl.NationalParkService;
import mountain.mountainList.service.impl.RouteBasicService;
import util.HibernateUtil;

@WebServlet("/dataimport/RouteDateImportServlet")
public class RouteDateImportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String RouteImgTitle = "RouteMap";
	private static int RouteImgNum = 1;
	private static final String CHARSET = "UTF-8";
	//系統根目錄 根據真實目的地修改
	private static final String SYSTEM_ROOT="C:\\DataSource\\workspace\\MountainEX_Project";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		File file = new File(SYSTEM_ROOT+"\\data/Mountain_UTF8.csv");
		importDataToDB(file, session);

	}

	public static void importDataToDB(File file, Session session) {

		int importCounter = 0;

		try (FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis,CHARSET);
				BufferedReader br = new BufferedReader(isr);) {
			CSVParser parser = CSVFormat.EXCEL.withHeader().parse(br);
			System.out.println("File load Succsess");

			List<CSVRecord> results = parser.getRecords();

			for (CSVRecord csvRecord : results) {
				String npName = csvRecord.get("npName");
				String name = csvRecord.get("name");
				String description = csvRecord.get("description");
				String advice = csvRecord.get("advice");
				String traffic = csvRecord.get("traffic");
				String imgURL = csvRecord.get("img_url");
				System.out.println(imgURL);

				NationalPark npBean = new NationalPark();
				npBean.setName(npName);
				RouteBasic rBBean = new RouteBasic();
				RouteInfo rIBean = new RouteInfo();

				rIBean.setName(name);
				byte[] bytesDescp = description.getBytes(CHARSET);
				Blob descpBlob = Hibernate.getLobCreator(session).createBlob(bytesDescp);
				rIBean.setDescription(descpBlob);
				byte[] bytesAdvice = advice.getBytes(CHARSET);
				Blob adviceBlob = Hibernate.getLobCreator(session).createBlob(bytesAdvice);
				rIBean.setAdvice(adviceBlob);
				byte[] bytesTra = traffic.getBytes();
				Blob trafficBlob = Hibernate.getLobCreator(session).createBlob(bytesTra);
				rIBean.setTraffic(trafficBlob);
				String localPath = downloadGetLocalPath(imgURL);
				byte[] bytesLocal = localPath.getBytes();
				Blob localBlob = Hibernate.getLobCreator(session).createBlob(bytesLocal);
				rIBean.setImgUrl(localBlob);

				rBBean.setNational_park(npBean);
				npBean.setRouteBasic(rBBean);
				rBBean.setRouteInfo(rIBean);
				rIBean.setRoute_basic(rBBean);
				NationalParkService npService = new NationalParkHibernateService(session);
				NationalPark queryNP = npService.select(npName);
				if(queryNP !=null){
					RouteBasicService rBService = new RouteBasicHibernateService(session);
					rBBean.setNational_park(queryNP);
					RouteBasic insertRB = rBService.insert(rBBean);
					if(insertRB == null){
						System.out.println("第" + (++importCounter) + "筆資料為空");
					}else{
						System.out.println("第" + (++importCounter) + "筆 : \t" + rIBean.getName());
					}
				} else{
					NationalPark insertNP = npService.insert(npBean);
					if( insertNP == null){
						System.out.println("第" + (++importCounter) + "筆資料為空");
					}else {
						System.out.println("第" + (++importCounter) + "筆 : \t" + rIBean.getName());
					}
				}
				

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public static String downloadGetLocalPath(String imgURL) throws UnsupportedEncodingException {

		String routeImgNum = String.valueOf(RouteImgNum++);
		String localPath = SYSTEM_ROOT+"\\src\\main\\webapp\\mountain\\images/" + RouteImgTitle
				+ routeImgNum + ".jpg";
	
		// download
		try (InputStream is = new URL(imgURL).openStream();) {
			Files.copy(is, Paths.get(localPath), StandardCopyOption.REPLACE_EXISTING);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return localPath;
	}


}
