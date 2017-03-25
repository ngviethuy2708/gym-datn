package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;













import org.apache.xerces.impl.xpath.regex.REUtil;

import library.LibraryString;
import bean.Bill;
import bean.DetailBill;
import bean.Product;
import bean.SearchForDate;
import bean.Search;
import bean.Training;
import bean.User;


public class ModelDetailBill {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public ArrayList<DetailBill> getList(int bid){
		ArrayList<DetailBill> alDetail = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT detailbill.Iddetail,product.Name,product.Picture,product.Price,detailbill.Numofproduct FROM detailbill  JOIN bill ON detailbill.Idbill = bill.Idbill JOIN product ON detailbill.Idproduct = product.Id WHERE detailbill.Idbill= ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, bid);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("Iddetail");
				String nameProduct = rs.getString("Name");
				String pictureProduct = rs.getString("Picture");
				int priceProduct = rs.getInt("Price");
				int numOfProduct = rs.getInt("Numofproduct");
				int  intoMoney = priceProduct*numOfProduct;
				DetailBill objDetail = new DetailBill(id, nameProduct, pictureProduct, priceProduct, numOfProduct, intoMoney);
				alDetail.add(objDetail);
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
		return alDetail;
	}
	public int  adDetailBill(ArrayList<DetailBill> alDetail){
		int result = 0;
		for (DetailBill d : alDetail) {
			conn = mConnect.getConnectSQL();
			String sql ="INSERT INTO detailbill(Iddetail,Idbill,Idproduct,Numofproduct) VALUES (?,?,?,?)";
			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1, d.getId());
				pst.setInt(2, d.getIdbill());
				pst.setInt(3, d.getIdProduct());
				pst.setInt(4, d.getNumOfProduct());
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
			
		}
		return result;
	}

}
