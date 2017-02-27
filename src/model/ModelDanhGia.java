package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.DanhGia;
import bean.Product;

public class ModelDanhGia {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public ArrayList<DanhGia> getList(){
		ArrayList<DanhGia> alDanhGia = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql ="select * from danhgia";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idDanhGia = rs.getInt("Id_danhgia");
				int idUsers = rs.getInt("Idusers");
				int idProducts = rs.getInt("Id");
				int danhGia = rs.getInt("Danhgia");
				DanhGia objDanhGia = new DanhGia(idDanhGia, idUsers, idProducts, danhGia);
				alDanhGia.add(objDanhGia);
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
		return alDanhGia;
	}
}
