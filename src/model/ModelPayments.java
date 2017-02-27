package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;










import library.LibraryString;
import bean.Payments;
import bean.SearchUserForDate;
import bean.SearchUsers;
import bean.Training;
import bean.Users;


public class ModelPayments {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public ArrayList<Payments> getList(){
		ArrayList<Payments> alPay = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM payments";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idPayments = rs.getInt("Id");
				String namePayMents = rs.getString("Name");
				String detail = rs.getString("Detail");
				Payments objPay = new Payments(idPayments, namePayMents, detail);
				alPay.add(objPay);
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
		return alPay;
	}
	public int addItem(Payments objPay){
		int result = 0;
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO payments(Name,Detail) VALUES (?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objPay.getNamePayMents());
			pst.setString(2, objPay.getDetail());
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
	
	public int delItem(int payid){
		int result = 0;
		String sql = "DELETE FROM payments WHERE Id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, payid);
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
	
	public Payments getItem(int payid){
		Payments objPay = null;
		String sql = "SELECT * FROM payments WHERE Id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, payid);
			rs = pst.executeQuery();
			if(rs.next()){
				int idPayments = rs.getInt("Id");
				String namePayMents = rs.getString("Name");
				String detail = rs.getString("Detail");
				objPay = new Payments(idPayments, namePayMents, detail);
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
		return objPay;
	}
	
	public int editItem(Payments objPay){
		int result = 0;
		LibraryString lib = new LibraryString();
		String sql ="UPDATE payments SET Name = ?, Detail = ? WHERE Id = ? LIMIT 1";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objPay.getNamePayMents());
			pst.setString(2, objPay.getDetail());
			pst.setInt(3, objPay.getIdPayments());
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
	
}
