package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;













import library.LibraryString;
import bean.Introduce;
import bean.Register;
import bean.SearchForDate;
import bean.Search;
import bean.User;


public class ModelIntroduce {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	
	public int addItem(Introduce objIntro){
		int result = 0;
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO Introduce(name,preview,detail,picture) VALUES (?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objIntro.getNameIntroduce());
			pst.setString(2, objIntro.getPreviewIntroduce());
			pst.setString(3, objIntro.getDetailIntroduce());
			pst.setString(4, objIntro.getPicture());
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
	
	public int delItem(int iid){
		int result = 0;
		String sql = "DELETE FROM introduce WHERE Id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, iid);
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
	
	public Introduce getItem(int iid){
		Introduce objIntro = null;
		String sql = "SELECT * FROM introduce WHERE Id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, iid);
			rs = pst.executeQuery();
			if(rs.next()){
				int idIntroduce = rs.getInt("Id");
				String nameIntroduce = rs.getString("Name");
				String previewIntroduce = rs.getString("Preview");
				String detailIntroduce = rs.getString("Detail");
				String picture = rs.getString("Picture");
				objIntro = new Introduce(idIntroduce, nameIntroduce, previewIntroduce, detailIntroduce, picture);
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
		return objIntro;
	}
	public int editItem(Introduce objIntro){
		int result = 0;
		conn = mConnect.getConnectSQL();
		try {
			if(objIntro.getPicture().isEmpty()){
				String sql ="UPDATE introduce SET Name = ?, Preview = ? ,Detail =  ? WHERE Id = ? LIMIT 1";
				pst = conn.prepareStatement(sql);
				pst.setString(1, objIntro.getNameIntroduce());
				pst.setString(2, objIntro.getPreviewIntroduce());
				pst.setString(3, objIntro.getDetailIntroduce());
				pst.setInt(4, objIntro.getIdIntroduce());
			}else{
				String sql ="UPDATE introduce SET Name = ?, Preview = ? ,Detail =  ?, Picture = ? WHERE Id = ? LIMIT 1";
				pst = conn.prepareStatement(sql);
				pst.setString(1, objIntro.getNameIntroduce());
				pst.setString(2, objIntro.getPreviewIntroduce());
				pst.setString(3, objIntro.getDetailIntroduce());
				pst.setString(4, objIntro.getPicture());
				pst.setInt(5, objIntro.getIdIntroduce());
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
		String sql ="SELECT COUNT(Id) AS sodong FROM introduce ";
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
	public ArrayList<Introduce> getListForPaginator(int offset, int rowCount){
		ArrayList<Introduce> alIntro = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM introduce  LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, rowCount);
			rs = pst.executeQuery();
			while(rs.next()){
				int idIntroduce = rs.getInt("Id");
				String nameIntroduce = rs.getString("Name");
				String previewIntroduce = rs.getString("Preview");
				String detailIntroduce = rs.getString("detail");
				String picture = rs.getString("picture");
				Introduce objIntro = new Introduce(idIntroduce, nameIntroduce, previewIntroduce, detailIntroduce, picture);
				alIntro.add(objIntro);
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
		return alIntro;
	}
	public String getPicture(int iid){
		String picture = "";
		conn = mConnect.getConnectSQL();
		String sql = "SELECT Picture FROM introduce WHERE Id = ? LIMIT 1";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, iid);
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
	public ArrayList<Introduce> getListForSearch(String someThing){
		ArrayList<Introduce> alIntro = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql ="SELECT * FROM introduce WHERE Name LIKE '%"+someThing+"%' OR Preview LIKE '%"+someThing+"%' OR Detail LIKE '%"+someThing+"%' ";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idIntroduce = rs.getInt("Id");
				String nameIntroduce = rs.getString("Name");
				String previewIntroduce = rs.getString("Preview");
				String detailIntroduce = rs.getString("detail");
				String picture = rs.getString("picture");
				Introduce objIntro = new Introduce(idIntroduce, nameIntroduce, previewIntroduce, detailIntroduce, picture);
				alIntro.add(objIntro);
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
		return alIntro;
	}
	public ArrayList<Introduce> getListForPublic(){
		ArrayList<Introduce> alIntro = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql ="SELECT * FROM introduce ORDER BY Id DESC LIMIT 6 ";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idIntroduce = rs.getInt("Id");
				String nameIntroduce = rs.getString("Name");
				String previewIntroduce = rs.getString("Preview");
				String detailIntroduce = rs.getString("detail");
				String picture = rs.getString("picture");
				Introduce objIntro = new Introduce(idIntroduce, nameIntroduce, previewIntroduce, detailIntroduce, picture);
				alIntro.add(objIntro);
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
		return alIntro;
	}
	
	
}
