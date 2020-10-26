package product.dbImport;

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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import product.model.FirstClass;
import product.model.FirstClassDAO;
import product.model.ItemBasic;
import product.model.ItemBasicDAO;
import product.model.ItemInfo;
import product.model.ItemInfoDAO;
import product.model.SecondClass;
import product.model.SecondClassDAO;
import util.HibernateUtil;

@WebServlet("/product/DbDataImportServlet")
public class DbDataImportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String imgTitle = "imgShop";
	private static int imgNum = 1;
	private static final String CHARSET = "UTF-8";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String path1 = "C:\\imges/imgShop1.jpg";
//		path1 = path1.concat(imgTitle);
//		String imgNUMString = String.valueOf(imgNum++);
//		path1 = path1.concat(imgNUMString + ".jpg");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		File file = new File("C:\\iii\\csv/shopitem_UTF8.csv");
		importDataToDB(file, session);

	}

//		String url = "";
//		InputStream is = new URL(url).openStream();
	public static void importDataToDB(File file, Session session) {

//		int importCounter = 0;

		try (FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis,CHARSET);
				BufferedReader br = new BufferedReader(isr);) {
			CSVParser parser = CSVFormat.EXCEL.withHeader().parse(br);
			System.out.println("File load Succsess");

			List<CSVRecord> results = parser.getRecords();
			FirstClass fcBeam = new FirstClass(); 
			SecondClass scBean = new SecondClass();
			
			
			for (CSVRecord csvRecord : results) {
				
				String firstClassName = csvRecord.get("FIRST_CLASS_NAME");
				String name = csvRecord.get("NAME");
				String type = csvRecord.get("TYPE");
				String pricesString = csvRecord.get("PRICE");
				String imgURL = csvRecord.get("IMG_URL");
				String description = csvRecord.get("DESCRIPTION");
				String secondClass = csvRecord.get("SECOND_CLASS");
				String stockString = csvRecord.get("STOCK");
//				System.out.println(imgURL);

				ItemBasic ibBean = new ItemBasic();
				ItemInfo iiBean = new ItemInfo();
				

				//firstClass filed
				Set<String> firstClassNameSet = fcBeam.getName();
				firstClassNameSet.add(firstClassName);
				fcBeam.setName(firstClassNameSet);
				
				//secondClass field
				
				Set<String> scBeanName = scBean.getName();
				scBeanName.add(secondClass);
				scBean.setFirstClass(fcBeam);
				
				ibBean.setName(name);
				int stock = Integer.parseInt(stockString);
				ibBean.setStock(stock);
				iiBean.setType(type);
				int price = Integer.parseInt(pricesString);
				iiBean.setPrice(price);
				
				byte[] bytesDescption = description.getBytes(CHARSET);
				Blob descptionBlob = Hibernate.getLobCreator(session).createBlob(bytesDescption);
				iiBean.setDescription(descptionBlob);
				byte[] bytesImgURL = imgURL.getBytes(CHARSET);
				Blob imgUrlBlob = Hibernate.getLobCreator(session).createBlob(bytesImgURL);
				iiBean.setImgUrl(imgUrlBlob);
				
				Set<SecondClass> secondClasses = new HashSet<SecondClass>();
				
				
				Set<ItemBasic> itemBasics =new HashSet<ItemBasic>();
				scBean.setItemBasics(itemBasics);
				ibBean.setFirstClassId(firstClass);
				ibBean.setItemInfo(iiBean);
				iiBean.setItemBasic(ibBean);
				
				//FirstClass object
				Set<SecondClass> secondClassesSet = fcBeam.getSecondClasses();
				secondClassesSet.add(scBean);
				fcBeam.setSecondClasses(secondClassesSet);
				List<ItemBasic> itemBasicList = fcBeam.getItemBasic();
				itemBasicList.add(ibBean);
				fcBeam.setItemBasic(itemBasicList);
				
				
				FirstClassDAO firstClassDAO = new FirstClassDAO(session);
				
				SecondClassDAO secondClassDAO = new SecondClassDAO(session);
				
				ItemBasicDAO itemBasicDAO = new ItemBasicDAO(session);
				
				ItemInfoDAO itemInfoDAO = new ItemInfoDAO(session);
//				ItemBasicDAO itemBasicDAO = new ItemBasicDAO(session);
//				ItemBasic queryIB = itemBasicDAO.select(name);
//				if(queryIB ==null){
//					RouteBasicService rBService = new RouteBasicHibernateService(session);
//					rBBean.setNational_park(queryNP);
//					RouteBasic insertRB = rBService.insert(rBBean);
//					if(insertRB == null){
//						System.out.println("第" + (++importCounter) + "筆資料為空");
//					}else{
//						System.out.println("第" + (++importCounter) + "筆 : \t" + rIBean.getName());
//					}
//				} else{
//					NationalPark insertNP = npService.insert(npBean);
//					if( insertNP == null){
//						System.out.println("第" + (++importCounter) + "筆資料為空");
//					}else {
//						System.out.println("第" + (++importCounter) + "筆 : \t" + rIBean.getName());
//					}
//				}
//				
//				downloadGetLocalPath(imgURL);

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

		String routeImgNum = String.valueOf(imgNum++);
		String localPath = "C:\\iii\\images/shopitem_UTF8.csv" + imgTitle
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
