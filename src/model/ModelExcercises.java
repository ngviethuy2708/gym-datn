package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;














import library.LibraryString;
import bean.Excercises;
import bean.Introduce;
import bean.News;
import bean.Register;
import bean.SearchForDate;
import bean.Search;
import bean.User;


public class ModelExcercises {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	
	public int addItem(Excercises objEx){
		int result = 0;
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO excercises(name,preview,detail,picture) VALUES (?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objEx.getNameExcercise());
			pst.setString(2, objEx.getPreviewExcercise());
			pst.setString(3, objEx.getDetailExcercise());
			pst.setString(4, objEx.getPicture());
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
	
	public int delItem(int eid){
		int result = 0;
		String sql = "DELETE FROM excercises WHERE Id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, eid);
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
	
	public Excercises getItem(int eid){
		Excercises objEx = null;
		String sql = "SELECT * FROM excercises WHERE Id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, eid);
			rs = pst.executeQuery();
			if(rs.next()){
				int idExcercise = rs.getInt("Id");
				String nameExcercise= rs.getString("Name");
				String previewExcercise = rs.getString("Preview");
				String detailExcercise = rs.getString("detail");
				String pictureExcercise = rs.getString("picture");
				objEx = new Excercises(idExcercise, nameExcercise, previewExcercise, detailExcercise, pictureExcercise);
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
		return objEx;
	}
	public int editItem(Excercises objEx){
		int result = 0;
		conn = mConnect.getConnectSQL();
		try {
			if(objEx.getPicture().isEmpty()){
				String sql ="UPDATE excercises SET Name = ?, Preview = ? ,Detail =  ? WHERE Id = ? LIMIT 1";
				pst = conn.prepareStatement(sql);
				pst.setString(1, objEx.getNameExcercise());
				pst.setString(2, objEx.getPreviewExcercise());
				pst.setString(3, objEx.getDetailExcercise());
				pst.setInt(4, objEx.getIdExcercise());
			}else{
				String sql ="UPDATE excercises SET Name = ?, Preview = ? ,Detail =  ?, Picture = ? WHERE Id = ? LIMIT 1";
				pst = conn.prepareStatement(sql);
				pst.setString(1, objEx.getNameExcercise());
				pst.setString(2, objEx.getPreviewExcercise());
				pst.setString(3, objEx.getDetailExcercise());
				pst.setString(4, objEx.getPicture());
				pst.setInt(5, objEx.getIdExcercise());
			}
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
		String sql ="SELECT COUNT(Id) AS sodong FROM excercises ";
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
	public ArrayList<Excercises> getListForPaginator(int offset, int rowCount){
		ArrayList<Excercises> alEx = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM excercises  LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, rowCount);
			rs = pst.executeQuery();
			while(rs.next()){
				int idExcercise = rs.getInt("Id");
				String nameExcercise= rs.getString("Name");
				String previewExcercise = rs.getString("Preview");
				String detailExcercise = rs.getString("detail");
				String pictureExcercise = rs.getString("picture");
				Excercises objEx = new Excercises(idExcercise, nameExcercise, previewExcercise, detailExcercise, pictureExcercise);
				alEx.add(objEx);
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
		return alEx;
	}
	public String getPicture(int nid){
		String picture = "";
		conn = mConnect.getConnectSQL();
		String sql = "SELECT Picture FROM excercises WHERE Id = ? LIMIT 1";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, nid);
			rs = pst.executeQuery();
			if(rs.next()){
				picture = rs.getString("Picture");
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
		return picture;
	}
	public ArrayList<Excercises> getListForSearch(String someThing){
		ArrayList<Excercises> alEx = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql ="SELECT * FROM excercises WHERE Name LIKE '%"+someThing+"%' OR Preview LIKE '%"+someThing+"%' OR Detail LIKE '%"+someThing+"%' ";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idExcercise = rs.getInt("Id");
				String nameExcercise= rs.getString("Name");
				String previewExcercise = rs.getString("Preview");
				String detailExcercise = rs.getString("detail");
				String pictureExcercise = rs.getString("picture");
				Excercises objEx = new Excercises(idExcercise, nameExcercise, previewExcercise, detailExcercise, pictureExcercise);
				alEx.add(objEx);
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
		return alEx;
	}
	public ArrayList<Excercises> getListForPublic(){
		ArrayList<Excercises> alEx = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql ="SELECT * FROM excercises ORDER BY Id DESC LIMIT 6 ";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idExcercise = rs.getInt("Id");
				String nameExcercise= rs.getString("Name");
				String previewExcercise = rs.getString("Preview");
				String detailExcercise = rs.getString("detail");
				String pictureExcercise = rs.getString("picture");
				Excercises objEx = new Excercises(idExcercise, nameExcercise, previewExcercise, detailExcercise, pictureExcercise);
				alEx.add(objEx);
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
		return alEx;
	}
	
}
