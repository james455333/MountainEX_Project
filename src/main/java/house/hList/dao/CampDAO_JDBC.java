package house.hList.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dB.DataS;
import house.hList.model.CampBeen;
import house.hList.model.HouseBeen;

public class CampDAO_JDBC {

	DataS dataS = new DataS();
	public List<CampBeen> listCamp(String abc){
		List<CampBeen> cBList = new ArrayList<>();
		dataS.setUsername("HI");
		dataS.setUserPassword("HI");
		DataSource datasoure = dataS.getDatasoure();
		try (
				Connection connection = datasoure.getConnection();
				){
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from camp ");

			while(rs.next()) {
				CampBeen cB =new CampBeen();
				
				cB.setCity(rs.getString("city"));
				cB.setCamptown(rs.getString("camptown"));
				cB.setCampname(rs.getNString("campname"));
				cB.setCampdesc(rs.getNString("campdesc"));
				cBList.add(cB);
				
				
				}
				}catch (SQLException e) {
					e.printStackTrace();
		}
		return cBList;
		}
	public List<CampBeen> slesctCity(String abc){
		List<CampBeen> cBList = new ArrayList<>();
		dataS.setUsername("HI");
		dataS.setUserPassword("HI");
		DataSource datasoure = dataS.getDatasoure();
		try (
				Connection connection = datasoure.getConnection();
				PreparedStatement stmt = connection.prepareStatement("select * from camp where city like ?");
				){
			stmt.setString(1, "%"+abc+"%");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				CampBeen cB =new CampBeen();
				
				cB.setCity(rs.getString("city"));
				cB.setCamptown(rs.getString("camptown"));
				cB.setCampname(rs.getNString("campname"));
				cB.setCampdesc(rs.getNString("campdesc"));
				cBList.add(cB);
				
				
				}
				}catch (SQLException e) {
					e.printStackTrace();
		}
		return cBList;
		}
	
	public List<CampBeen> slesctTown(String abc){
		List<CampBeen> cBList = new ArrayList<>();
		dataS.setUsername("HI");
		dataS.setUserPassword("HI");
		DataSource datasoure = dataS.getDatasoure();
		try (
				Connection connection = datasoure.getConnection();
				PreparedStatement stmt = connection.prepareStatement("select * from camp where camptown like ?");
				){
			stmt.setString(1, "%"+abc+"%");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				CampBeen cB =new CampBeen();
				
				cB.setCity(rs.getString("city"));
				cB.setCamptown(rs.getString("camptown"));
				cB.setCampname(rs.getNString("campname"));
				cB.setCampdesc(rs.getNString("campdesc"));
				cBList.add(cB);
				
				
				}
				}catch (SQLException e) {
					e.printStackTrace();
		}
		return cBList;
		}
	
	public List<CampBeen> slesctName(String abc){
		List<CampBeen> cBList = new ArrayList<>();
		dataS.setUsername("HI");
		dataS.setUserPassword("HI");
		DataSource datasoure = dataS.getDatasoure();
		try (
				Connection connection = datasoure.getConnection();
				PreparedStatement stmt = connection.prepareStatement("select * from camp where campname like ?");
				){
			stmt.setString(1, "%"+abc+"%");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				CampBeen cB =new CampBeen();
				
				cB.setCity(rs.getString("city"));
				cB.setCamptown(rs.getString("camptown"));
				cB.setCampname(rs.getNString("campname"));
				cB.setCampdesc(rs.getNString("campdesc"));
				cBList.add(cB);
				
				
				}
				}catch (SQLException e) {
					e.printStackTrace();
		}
		return cBList;
		}
	
public void insertCamp(String cit ,String cmpt,String cmpn, String cmpd){
		
		dataS.setUsername("HI");
		dataS.setUserPassword("HI");
		DataSource datasoure = dataS.getDatasoure();
		
		try (Connection connection = datasoure.getConnection();){
				PreparedStatement stmt = connection.prepareStatement(
						"insert into camp( city,camptown,campname,campdesc)values(?, ?, ?, ?)");
				stmt.setString(1,cit);
				stmt.setString(2,cmpt);
				stmt.setString(3,cmpn);
				stmt.setString(4,cmpd);
				
				ResultSet rs=stmt.executeQuery();		
				stmt.close();
				
				
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
	
	public void deleteCamp(String del) {
		dataS.setUsername("HI");
		dataS.setUserPassword("HI");
		DataSource datasoure = dataS.getDatasoure();
		try (Connection connection = datasoure.getConnection();){
			PreparedStatement stmt = connection.prepareStatement("delete from camp where campname=?");
		stmt.setString(1, del);
		stmt.executeUpdate();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	public void updateCamp(String cit1 ,String cmpt1,String cmpn1, String cmpd1) {
		dataS.setUsername("HI");
		dataS.setUserPassword("HI");
		DataSource datasoure = dataS.getDatasoure();
		System.out.println("333");
		try (Connection connection = datasoure.getConnection();){
			PreparedStatement stmt = connection.prepareStatement("update camp set city=? ,camptown=? ,campdesc=?  where campname=?");
			stmt.setString(1,cit1 );					
			stmt.setString(2, cmpt1);
			stmt.setString(3, cmpd1);
			stmt.setString(4, cmpn1);
			stmt.executeUpdate();
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
	
	
		
		}
