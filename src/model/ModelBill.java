package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;













import library.LibraryString;
import bean.Bill;
import bean.News;
import bean.Register;
import bean.SearchForDate;
import bean.Search;
import bean.User;


public class ModelBill {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public int delItem(int pid){
		int result = 0;
		String sql = "DELETE FROM bill WHERE Idbill = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return result;
	}
	public int delDetailBill(int pid){
		int result = 0;
		String sql = "DELETE FROM detailbill WHERE Idbill = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return result;
	}

	public int getSum(){
		int sodong = 0;
		String sql ="SELECT COUNT(Idbill) AS sodong FROM bill ";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				sodong = rs.getInt("sodong");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sodong;
	}
	
	public ArrayList<Bill> getListForPaginator(int offset, int rowCount){
		ArrayList<Bill> alBill = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT bill.Idbill,users.Username,users.Fullname,users.Birthday,users.Address,users.Phone,bill.information,payments.Name,bill.Dateorder,bill.Tranfer,bill.ship FROM bill JOIN users ON bill.IdUsers = users.IdUsers JOIN payments ON bill.Idpayments = payments.Id  LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, rowCount);
			rs = pst.executeQuery();
			while(rs.next()){
				int idBill = rs.getInt("Idbill");
				String userName = rs.getString("Username");
				String fullName = rs.getString("Fullname");
				Date birthDay = rs.getDate("Birthday");
				String address = rs.getString("Address");
				String phone = rs.getString("Phone");
				String information = rs.getString("Information");
				String namePayment = rs.getString("Name");
				Date dateOrder = rs.getDate("Dateorder");
				boolean tranfer = rs.getBoolean("Tranfer");
				boolean ship = rs.getBoolean("Ship");
				Bill objBill = new Bill(idBill, userName, fullName, birthDay, address, phone, information, namePayment, dateOrder, tranfer, ship);
				alBill.add(objBill);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alBill;
	}
	public ArrayList<Bill> getListForSearch(Search item){
		ArrayList<Bill> alBill = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql ="SELECT bill.Idbill,users.Username,users.Fullname,users.Birthday,users.Address,users.Phone,bill.information,payments.Name,bill.Dateorder,bill.Tranfer,bill.ship FROM bill JOIN users ON bill.IdUsers = users.IdUsers JOIN payments ON bill.Idpayments = payments.Id WHERE (bill.Tranfer = '"+item.getType()+"' AND users.Username LIKE '%"+item.getSomething()+"%') OR (bill.Tranfer = '"+item.getType()+"' AND users.Fullname LIKE '%"+item.getSomething()+"%') OR (bill.Tranfer = '"+item.getType()+"' AND users.Phone LIKE '%"+item.getSomething()+"%') OR (bill.Tranfer = '"+item.getType()+"' AND payments.Name LIKE '%"+item.getSomething()+"%')";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idBill = rs.getInt("Idbill");
				String userName = rs.getString("Username");
				String fullName = rs.getString("Fullname");
				Date birthDay = rs.getDate("Birthday");
				String address = rs.getString("Address");
				String phone = rs.getString("Phone");
				String information = rs.getString("Information");
				String namePayment = rs.getString("Name");
				Date dateOrder = rs.getDate("Dateorder");
				boolean tranfer = rs.getBoolean("Tranfer");
				boolean ship = rs.getBoolean("Ship");
				Bill objBill = new Bill(idBill, userName, fullName, birthDay, address, phone, information, namePayment, dateOrder, tranfer, ship);
				alBill.add(objBill);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alBill;
	}
	public ArrayList<Bill> getListForSearchDate(SearchForDate item){
		ArrayList<Bill> alBill = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT bill.Idbill,users.Username,users.Fullname,users.Birthday,users.Address,users.Phone,bill.information,payments.Name,bill.Dateorder,bill.Tranfer,bill.ship FROM bill JOIN users ON bill.IdUsers = users.IdUsers JOIN payments ON bill.Idpayments = payments.Id WHERE (bill.Tranfer = '"+item.getType()+"' AND users.Birthday = '"+item.getDate()+"') OR (bill.Tranfer = '"+item.getType()+"' AND bill.Dateorder = '"+item.getDate()+"')  " ;
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idBill = rs.getInt("Idbill");
				String userName = rs.getString("Username");
				String fullName = rs.getString("Fullname");
				Date birthDay = rs.getDate("Birthday");
				String address = rs.getString("Address");
				String phone = rs.getString("Phone");
				String information = rs.getString("Information");
				String namePayment = rs.getString("Name");
				Date dateOrder = rs.getDate("Dateorder");
				boolean tranfer = rs.getBoolean("Tranfer");
				boolean ship = rs.getBoolean("Ship");
				Bill objBill = new Bill(idBill, userName, fullName, birthDay, address, phone, information, namePayment, dateOrder, tranfer, ship);
				alBill.add(objBill);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return alBill;
	}
	
	public int setActiveTranfer(int nid, int active) {
		int result = 0;
		conn = mConnect.getConnectSQL();
		try {
			if(active == 0){	// không sửa hình
				String sql = "UPDATE bill SET Tranfer = 1 WHERE Idbill =?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, nid);
			}else{ // có sửa hình
				String sql = "UPDATE bill SET Tranfer = 0 WHERE Idbill =?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, nid);
			}
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public int setActiveShip(int nid, int active) {
		int result = 0;
		conn = mConnect.getConnectSQL();
		try {
			if(active == 0){	// không sửa hình
				String sql = "UPDATE bill SET Ship = 1 WHERE Idbill =?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, nid);
			}else{ // có sửa hình
				String sql = "UPDATE bill SET Ship = 0 WHERE Idbill =?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, nid);
			}
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public int editTypeUsersWhenAdminUpdateEnddate(int IdUsers){
		int result = 0;
		String sql ="UPDATE users SET Isregister = 1 WHERE Idusers = ? LIMIT 1";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, IdUsers);
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				result = 0;
				e.printStackTrace();
			}
		}
		return result;
	}
	public int addItem(Bill objBill){
		int result = 0;
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO bill(Idbill,IdUsers,Information,IdPayments,Dateorder,tranfer,Ship) VALUES (?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objBill.getIdBill());
			pst.setInt(2, objBill.getIdUser());
			pst.setString(3, objBill.getInformation());
			pst.setInt(4, objBill.getIdPayment());
			pst.setDate(5, objBill.getDateOrder());
			pst.setBoolean(6, objBill.isTranfer());
			pst.setBoolean(7, objBill.isShip());
			pst.executeUpdate();
			result = 1;
		} catch (SQLException e) {
			result = 0;
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public int getIdMax(){
		int idBill = 0;
		String sql ="SELECT Idbill FROM bill WHERE Idbill=( SELECT max(Idbill) FROM bill ) ";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				idBill = rs.getInt("Idbill");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return idBill;
	}
	
}
