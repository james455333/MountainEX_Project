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
import house.hList.model.HouseBeen;

public class MountainHouseDAO_JDBC {

	
	DataS dataS = new DataS();
	public List<HouseBeen> listMH(String add){
		List<HouseBeen> hBList = new ArrayList<>();
		dataS.setUsername("HI");
		dataS.setUserPassword("HI");
		DataSource datasoure = dataS.getDatasoure();
		try (
				Connection connection = datasoure.getConnection();
				){
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from mountainhouse ");
			
	
			while(rs.next()) {
				HouseBeen hB =new HouseBeen();
				
				hB.setMountainName(rs.getString("mountainname"));
				hB.setName(rs.getString("name"));
				hB.setSeat(rs.getInt("seat"));
				hB.setCampSeat(rs.getInt("campseat"));
				hB.setHight(rs.getString("hight"));
				hBList.add(hB);
				
				
				}
				}catch (SQLException e) {
					e.printStackTrace();
		}
		return hBList;
		}
			
	public List<HouseBeen> selectMountain(String add){
		List<HouseBeen> hBList =new ArrayList<>();
		dataS.setUsername("HI");
		dataS.setUserPassword("HI");
		DataSource datasoure = dataS.getDatasoure();
	
		try (
				Connection connection = datasoure.getConnection();
				PreparedStatement stmt = connection.prepareStatement("select * from mountainhouse where mountainname like ?");
//			ResultSet rs = stmt.executeQuery();
				){
		
			stmt.setString(1, "%"+add+"%");
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				HouseBeen hB =new HouseBeen();
				
				hB.setMountainName(rs.getString("mountainname"));
				hB.setName(rs.getString("name"));
				hB.setSeat(rs.getInt("seat"));
				hB.setCampSeat(rs.getInt("campseat"));
				hB.setHight(rs.getString("hight"));
				hBList.add(hB);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hBList;
	}
	
	public List<HouseBeen> selectName(String add){
		List<HouseBeen> hBList =new ArrayList<>();
		dataS.setUsername("HI");
		dataS.setUserPassword("HI");
		DataSource datasoure = dataS.getDatasoure();
		
		try (
				Connection connection = datasoure.getConnection();
				PreparedStatement stmt = connection.prepareStatement("select * from mountainhouse where name like ?");
//			ResultSet rs = stmt.executeQuery();
				){
		
			stmt.setString(1, "%"+add+"%");
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				HouseBeen hB =new HouseBeen();
				
				hB.setMountainName(rs.getString("mountainname"));
				hB.setName(rs.getString("name"));
				hB.setSeat(rs.getInt("seat"));
				hB.setCampSeat(rs.getInt("campseat"));
				hB.setHight(rs.getString("hight"));
				hBList.add(hB);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hBList;
	}
	
	
	public void insertHouse(String mou ,String nam,Integer sea , Integer cam,String hig){
		
		dataS.setUsername("HI");
		dataS.setUserPassword("HI");
		DataSource datasoure = dataS.getDatasoure();
		
		try (Connection connection = datasoure.getConnection();){
				PreparedStatement stmt = connection.prepareStatement(
						"insert into mountainhouse( mountainname,name,seat,campseat,hight)values(?, ?, ?, ?, ?)");
				stmt.setString(1,mou);
				stmt.setString(2,nam);
				stmt.setInt(3,sea);
				stmt.setInt(4,cam);
				stmt.setString(5,hig);
				
				ResultSet rs=stmt.executeQuery();		
				stmt.close();
				
				
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
	
	public void deleteHouse(String del) {
		dataS.setUsername("HI");
		dataS.setUserPassword("HI");
		DataSource datasoure = dataS.getDatasoure();
		try (Connection connection = datasoure.getConnection();){
			PreparedStatement stmt = connection.prepareStatement("delete from mountainhouse where name=?");
		stmt.setString(1, del);
		stmt.executeUpdate();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
	public void updateHouse(String mou1 ,String nam1,Integer sea1 , Integer cam1,String hig1) {
		dataS.setUsername("HI");
		dataS.setUserPassword("HI");
		DataSource datasoure = dataS.getDatasoure();
		System.out.println("333");
		try (Connection connection = datasoure.getConnection();){
			PreparedStatement stmt = connection.prepareStatement("update mountainhouse set mountainname=? ,seat=? ,campseat=? ,hight=? where name=?");
			stmt.setString(1,mou1 );
			stmt.setInt(2,sea1);
			stmt.setInt(3,cam1);			
			stmt.setString(4, hig1);
			stmt.setString(5, nam1);
			stmt.executeUpdate();
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
	
	
	
}