package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;











import library.LibraryString;
import library.TimeConvert;
import bean.Register;
import bean.SearchForDate;
import bean.Search;
import bean.User;


public class ModelRegister {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public ArrayList<Register> getList(){
		ArrayList<Register> alRegis = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT register.Idregister,users.UserName,users.Fullname,users.Birthday,users.Phone,trainingschedule.TrainingName,trainingschedule.TrainingDay,trainingschedule.Trainingprice,register.Begindate,register.Enddate ,register.Type FROM register JOIN users ON register.Idusers = users.Idusers Join trainingschedule ON register.Idtraining = trainingschedule.Idtraining";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idRegister = rs.getInt("Idregister");
				String userName = rs.getString("UserName");
				String fullName = rs.getString("Fullname");
				Date birthDay = rs.getDate("Birthday");
				String phoneNumber = rs.getString("Phone");
				String trainingName = rs.getString("TrainingName");
				int trainingDay = rs.getInt("TrainingDay");
				int trainingPrice = rs.getInt("Trainingprice");
				Date  beginDate = rs.getDate("Begindate");
				Date endDate = rs.getDate("Enddate");
				boolean type = rs.getBoolean("Type");
				Register objRegis = new Register(idRegister, userName, fullName, birthDay, phoneNumber, trainingName, trainingDay, trainingPrice, beginDate, endDate, type);
				alRegis.add(objRegis);
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
		return alRegis;
	}
	public ArrayList<Register> getUsersInRegister(){
		ArrayList<Register> alRegis = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT register.Idusers,register.Enddate FROM register JOIN users ON register.Idusers = users.Idusers";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idUsers = rs.getInt("Idusers");
				Date endDate = rs.getDate("Enddate");
				Register objRegis = new Register(idUsers, endDate);
				alRegis.add(objRegis);
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
		return alRegis;
	}
	public int addItem(Register objRegis){
		int result = 0;
		LibraryString lib = new LibraryString();
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO register(Idusers,Idtraining,Begindate,Enddate,Type) VALUES (?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objRegis.getIdUsers());
			pst.setInt(2, objRegis.getIdTraining());
			pst.setDate(3, objRegis.getBeginDate());
			pst.setDate(4, objRegis.getEndDate());
			pst.setBoolean(5, false);
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
	
	public int delItem(int rid){
		int result = 0;
		String sql = "DELETE FROM register WHERE Idregister = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, rid);
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
	
	public Register getItem(int rid){
		Register objRegis = null;
		String sql = "SELECT register.Idregister,register.Idusers,register.Idtraining,Users.Username,Users.Fullname,register.Begindate,register.Enddate FROM register JOIN users ON register.Idusers = users.Idusers WHERE Idregister = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, rid);
			rs = pst.executeQuery();
			if(rs.next()){
				int idRegister = rs.getInt("Idregister");
				int idUsers = rs.getInt("Idusers");
				int idTraining = rs.getInt("Idtraining");
				String userName = rs.getString("Username");
				String fullName = rs.getString("fullName");
				Date beginDate = rs.getDate("Begindate");
				Date endDate = rs.getDate("Enddate");
				objRegis = new Register(idRegister, idUsers, idTraining, userName, fullName, beginDate, endDate);
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
		return objRegis;
	}
	public int getIdRegister(int uid){
		int Idregister = 0;
		String sql = "SELECT Idregister FROM register WHERE Idusers = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, uid);
			rs = pst.executeQuery();
			if(rs.next()){
				Idregister = rs.getInt("Idregister");	
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
		return Idregister;
	}
	public Register getUserInRegister(int uid){
		Register objRegis = null;
		String sql = "SELECT Users.Username,Users.Fullname,Users.Birthday,Users.phone,trainingschedule.Trainingname,trainingschedule.Trainingday,trainingschedule.Trainingprice, register.Begindate,register.Enddate,register.type FROM register JOIN users ON register.Idusers = users.Idusers JOIN trainingschedule ON register.Idtraining = trainingschedule.Idtraining WHERE users.Idusers = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, uid);
			rs = pst.executeQuery();
			if(rs.next()){
				String userName = rs.getString("UserName");
				String fullName = rs.getString("Fullname");
				Date birthDay = rs.getDate("Birthday");
				String phoneNumber = rs.getString("Phone");
				String trainingName = rs.getString("TrainingName");
				int trainingDay = rs.getInt("TrainingDay");
				int trainingPrice = rs.getInt("Trainingprice");
				Date  beginDate = rs.getDate("Begindate");
				Date endDate = rs.getDate("Enddate");
				boolean type = rs.getBoolean("Type");
				objRegis = new Register(userName, fullName, birthDay, phoneNumber, trainingName, trainingDay, trainingPrice, beginDate, endDate, type);
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
		return objRegis;
	}
	public User getIdUser(int uid){
		User objUser = null;
		String sql = "SELECT Users.Idusers FROM register JOIN users ON register.Idusers = users.Idusers WHERE users.Idusers = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, uid);
			rs = pst.executeQuery();
			if(rs.next()){
				int idUser = rs.getInt("Idusers");
				objUser = new User(idUser);
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
		return objUser;
	}
	public int editItem(Register objRegis){
		int result = 0;
		String sql ="UPDATE register SET Idtraining = ?,Begindate = ?, Enddate = ? WHERE Idregister = ? LIMIT 1";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, objRegis.getIdTraining());
			pst.setDate(2, objRegis.getBeginDate());
			pst.setDate(3, objRegis.getEndDate());
			pst.setInt(4, objRegis.getIdRegister());
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
	public int editRegisterForEnddate(int idRegis){
		int result = 0;
		String sql ="UPDATE register SET type = 0 WHERE Idregister = ? ";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idRegis);
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
	public int getSum(){
		int sodong = 0;
		String sql ="SELECT COUNT(Idregister) AS sodong FROM register ";
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
	public ArrayList<Register> getListForPaginator(int offset, int rowCount){
		ArrayList<Register> alRegister = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT register.Idregister,users.UserName,users.Fullname,users.Birthday,users.Phone,trainingschedule.TrainingName,trainingschedule.TrainingDay,trainingschedule.Trainingprice,register.Begindate,register.Enddate ,register.Type FROM register JOIN users ON register.Idusers = users.Idusers Join trainingschedule ON register.Idtraining = trainingschedule.Idtraining  LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, rowCount);
			rs = pst.executeQuery();
			while(rs.next()){
				int idRegister = rs.getInt("Idregister");
				String userName = rs.getString("UserName");
				String fullName = rs.getString("Fullname");
				Date birthDay = rs.getDate("Birthday");
				String phoneNumber = rs.getString("Phone");
				String trainingName = rs.getString("TrainingName");
				int trainingDay = rs.getInt("TrainingDay");
				int trainingPrice = rs.getInt("Trainingprice");
				Date  beginDate = rs.getDate("Begindate");
				Date endDate = rs.getDate("Enddate");
				boolean type = rs.getBoolean("Type");
				Register objRegis = new Register(idRegister, userName, fullName, birthDay, phoneNumber, trainingName, trainingDay, trainingPrice, beginDate, endDate, type);
				alRegister.add(objRegis);
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
		return alRegister;
	}
	public ArrayList<Register> getListForSearch(Search item){
		ArrayList<Register> alRegis = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql ="SELECT register.Idregister,users.UserName,users.Fullname,users.Birthday,users.Phone,trainingschedule.TrainingName,trainingschedule.TrainingDay,trainingschedule.Trainingprice,register.Begindate,register.Enddate ,register.Type FROM register JOIN users ON register.Idusers = users.Idusers Join trainingschedule ON register.Idtraining = trainingschedule.Idtraining WHERE (register.Type = '"+item.getType()+"'  and  users.Username like '%"+item.getSomething()+"%') or (register.Type = '"+item.getType()+"'  and  users.Fullname like '%"+item.getSomething()+"%')";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idRegister = rs.getInt("Idregister");
				String userName = rs.getString("UserName");
				String fullName = rs.getString("Fullname");
				Date birthDay = rs.getDate("Birthday");
				String phoneNumber = rs.getString("Phone");
				String trainingName = rs.getString("TrainingName");
				int trainingDay = rs.getInt("TrainingDay");
				int trainingPrice = rs.getInt("Trainingprice");
				Date  beginDate = rs.getDate("Begindate");
				Date endDate = rs.getDate("Enddate");
				boolean type = rs.getBoolean("Type");
				Register objRegis = new Register(idRegister, userName, fullName, birthDay, phoneNumber, trainingName, trainingDay, trainingPrice, beginDate, endDate, type);
				alRegis.add(objRegis);
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
		return alRegis;
	}
	public ArrayList<Register> getListForSearchDate(SearchForDate item){
		ArrayList<Register> alRegis = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT register.Idregister,users.UserName,users.Fullname,users.Birthday,users.Phone,trainingschedule.TrainingName,trainingschedule.TrainingDay,trainingschedule.Trainingprice,register.Begindate,register.Enddate ,register.Type FROM register JOIN users ON register.Idusers = users.Idusers Join trainingschedule ON register.Idtraining = trainingschedule.Idtraining WHERE  (register.Type = '"+item.getType()+"'  and  register.Begindate = '"+item.getDate()+"') or (register.Type = '"+item.getType()+"'  and  register.Enddate = '"+item.getDate()+"')" ;
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idRegister = rs.getInt("Idregister");
				String userName = rs.getString("UserName");
				String fullName = rs.getString("Fullname");
				Date birthDay = rs.getDate("Birthday");
				String phoneNumber = rs.getString("Phone");
				String trainingName = rs.getString("TrainingName");
				int trainingDay = rs.getInt("TrainingDay");
				int trainingPrice = rs.getInt("Trainingprice");
				Date  beginDate = rs.getDate("Begindate");
				Date endDate = rs.getDate("Enddate");
				boolean type = rs.getBoolean("Type");
				Register objRegis = new Register(idRegister, userName, fullName, birthDay, phoneNumber, trainingName, trainingDay, trainingPrice, beginDate, endDate, type);
				alRegis.add(objRegis);
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
		return alRegis;
	}
	
	public int setActive(int nid, int active) {
		int result = 0;
		conn = mConnect.getConnectSQL();
		try {
			if(active == 0){	// không sửa hình
				String sql = "UPDATE register SET type = 1 WHERE Idregister =?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, nid);
			}else{ // có sửa hình
				String sql = "UPDATE register SET type = 0 WHERE Idregister =?";
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
}
