package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;









import library.LibraryString;
import bean.SearchUserForDate;
import bean.SearchUsers;
import bean.Training;
import bean.Users;


public class ModelTraining {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public ArrayList<Training> getList(){
		ArrayList<Training> alTraining = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM trainingschedule";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idTraining = rs.getInt("Idtraining");
				String nameTraining = rs.getString("Trainingname");
				int dayTraining = rs.getInt("Trainingday");
				int priceTraining = rs.getInt("Trainingprice");
				Training objTraining = new Training(idTraining, nameTraining, dayTraining, priceTraining);
				alTraining.add(objTraining);
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
		return alTraining;
	}
	public int addItem(Training objTraining){
		int result = 0;
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO trainingschedule(Trainingname,Trainingday,Trainingprice) VALUES (?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objTraining.getNameTraining());
			pst.setInt(2, objTraining.getDayTraining());
			pst.setInt(3, objTraining.getPriceTraining());
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
	
	public int delItem(int tid){
		int result = 0;
		String sql = "DELETE FROM trainingschedule WHERE Idtraining = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, tid);
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
	
	public Training getItem(int tid){
		Training objTraining = null;
		String sql = "SELECT * FROM trainingschedule WHERE Idtraining = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, tid);
			rs = pst.executeQuery();
			if(rs.next()){
				int idTraining = rs.getInt("Idtraining");
				String nameTraining = rs.getString("Trainingname");
				int dayTraining = rs.getInt("Trainingday");
				int priceTraining = rs.getInt("Trainingprice");
				objTraining = new Training(idTraining, nameTraining, dayTraining, priceTraining); 
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
		return objTraining;
	}
	
	public int editItem(Training objTraining){
		int result = 0;
		LibraryString lib = new LibraryString();
		String sql ="UPDATE trainingschedule SET  Trainingname = ?,Trainingday = ?, Trainingprice = ? WHERE Idtraining = ? LIMIT 1";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objTraining.getNameTraining());
			pst.setInt(2, objTraining.getDayTraining());
			pst.setInt(3, objTraining.getPriceTraining());
			pst.setInt(4, objTraining.getIdTraining());
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
