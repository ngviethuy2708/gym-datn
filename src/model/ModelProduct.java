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
import bean.News;
import bean.Product;
import bean.Register;
import bean.SearchUserForDate;
import bean.SearchUsers;
import bean.Users;


public class ModelProduct {
	ModelConnectdb mConnect = new ModelConnectdb();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	
	public int addItem(Product objPro){
		int result = 0;
		conn = mConnect.getConnectSQL();
		String sql ="INSERT INTO product(name,preview,detail,price,picture,type) VALUES (?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objPro.getNameProduct());
			pst.setString(2, objPro.getPreviewProduct());
			pst.setString(3, objPro.getDetailProduct());
			pst.setInt(4, objPro.getPriceProduct());
			pst.setString(5, objPro.getPicture());
			pst.setBoolean(6, true);
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
	
	public int delItem(int pid){
		int result = 0;
		String sql = "DELETE FROM product WHERE Id = ?";
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
	
	public Product getItem(int nid){
		Product objProduct = null;
		String sql = "SELECT * FROM product WHERE Id = ?";
		conn = mConnect.getConnectSQL();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, nid);
			rs = pst.executeQuery();
			if(rs.next()){
				int idProduct = rs.getInt("Id");
				String nameProduct = rs.getString("Name");
				String previewProduct = rs.getString("Preview");
				String detailProduct = rs.getString("detail");
				int priceProduct = rs.getInt("Price");
				String picture = rs.getString("picture");
				boolean  typeProduct = rs.getBoolean("Type");
				objProduct = new Product(idProduct, nameProduct, previewProduct, detailProduct, priceProduct, picture, typeProduct);
				
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
		return objProduct;
	}
	public int editItem(Product objPro){
		int result = 0;
		conn = mConnect.getConnectSQL();
		try {
			if(objPro.getPicture().isEmpty()){
				String sql ="UPDATE product SET Name = ?, Preview = ? ,Detail =  ?,Price = ? WHERE Id = ? LIMIT 1";
				pst = conn.prepareStatement(sql);
				pst.setString(1, objPro.getNameProduct());
				pst.setString(2, objPro.getPreviewProduct());
				pst.setString(3, objPro.getDetailProduct());
				pst.setInt(4, objPro.getPriceProduct());
				pst.setInt(5, objPro.getIdProduct());
			}else{
				String sql ="UPDATE product SET Name = ?, Preview = ? ,Detail =  ?, Price = ?, Picture = ? WHERE Id = ? LIMIT 1";
				pst = conn.prepareStatement(sql);
				pst.setString(1, objPro.getNameProduct());
				pst.setString(2, objPro.getPreviewProduct());
				pst.setString(3, objPro.getDetailProduct());
				pst.setInt(4, objPro.getPriceProduct());
				pst.setString(5, objPro.getPicture());
				pst.setInt(6, objPro.getIdProduct());
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
		String sql ="SELECT COUNT(Id) AS sodong FROM product ";
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
	public ArrayList<Product> getListForPaginator(int offset, int rowCount){
		ArrayList<Product> alPro = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql = "SELECT * FROM product  LIMIT ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, rowCount);
			rs = pst.executeQuery();
			while(rs.next()){
				int idProduct = rs.getInt("Id");
				String nameProduct = rs.getString("Name");
				String previewProduct = rs.getString("Preview");
				String detailProduct = rs.getString("detail");
				int priceProduct = rs.getInt("Price");
				String picture = rs.getString("picture");
				boolean  typeProduct = rs.getBoolean("Type");
				Product objPro = new Product(idProduct, nameProduct, previewProduct, detailProduct, priceProduct, picture, typeProduct);
				alPro.add(objPro);
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
		return alPro;
	}
	public String getPicture(int pid){
		String picture = "";
		conn = mConnect.getConnectSQL();
		String sql = "SELECT Picture FROM product WHERE Id = ? LIMIT 1";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, pid);
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
	
	public ArrayList<Product> getListForSearch(SearchUsers item){
		ArrayList<Product> alPro = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql ="select * from product where (Type = '"+item.getType()+"' and  Name like '%"+item.getSomething()+"%') or (Type = '"+item.getType()+"' and  Preview like '%"+item.getSomething()+"%') or (Type = '"+item.getType()+"' and  Detail like '%"+item.getSomething()+"%') or (Type = '"+item.getType()+"' and  Price = '%"+item.getSomething()+"%')";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idProduct = rs.getInt("Id");
				String nameProduct = rs.getString("Name");
				String previewProduct = rs.getString("Preview");
				String detailProduct = rs.getString("detail");
				int priceProduct = rs.getInt("Price");
				String picture = rs.getString("picture");
				boolean  typeProduct = rs.getBoolean("Type");
				Product objPro = new Product(idProduct, nameProduct, previewProduct, detailProduct, priceProduct, picture, typeProduct);
				alPro.add(objPro);
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
		return alPro;
	}
	public int setActive(int pid, int active) {
		int result = 0;
		conn = mConnect.getConnectSQL();
		try {
			if(active == 0){	// không sửa hình
				String sql = "UPDATE product SET Type = 1 WHERE Id =?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, pid);
			}else{ // có sửa hình
				String sql = "UPDATE product SET Type = 0 WHERE Id =?";
				pst = conn.prepareStatement(sql);
				pst.setInt(1, pid);
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
	public ArrayList<Product> getListForPublic(){
		ArrayList<Product> alPro = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql ="select * from product ORDER BY Id DESC LIMIT 6";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idProduct = rs.getInt("Id");
				String nameProduct = rs.getString("Name");
				String previewProduct = rs.getString("Preview");
				String detailProduct = rs.getString("detail");
				int priceProduct = rs.getInt("Price");
				String picture = rs.getString("picture");
				boolean  typeProduct = rs.getBoolean("Type");
				Product objPro = new Product(idProduct, nameProduct, previewProduct, detailProduct, priceProduct, picture, typeProduct);
				alPro.add(objPro);
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
		return alPro;
	}
	public ArrayList<Product> getList(){
		ArrayList<Product> alPro = new ArrayList<>();
		conn = mConnect.getConnectSQL();
		String sql ="select * from product";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int idProduct = rs.getInt("Id");
				String nameProduct = rs.getString("Name");
				String previewProduct = rs.getString("Preview");
				String detailProduct = rs.getString("detail");
				int priceProduct = rs.getInt("Price");
				String picture = rs.getString("picture");
				boolean  typeProduct = rs.getBoolean("Type");
				Product objPro = new Product(idProduct, nameProduct, previewProduct, detailProduct, priceProduct, picture, typeProduct);
				alPro.add(objPro);
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
		return alPro;
	}
	public ArrayList<Product> getListForSparQl(ArrayList<Product> alProduct){
		ArrayList<Product> alPro = new ArrayList<>();
		for (Product product : alProduct) {
			conn = mConnect.getConnectSQL();
			String sql ="select * from product where Name like '%"+product.getNameProduct()+"%'";
			try {
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery();

				if(rs.next()){
					int idProduct = rs.getInt("Id");
					String nameProduct = rs.getString("Name");
					String previewProduct = rs.getString("Preview");
					String detailProduct = rs.getString("detail");
					int priceProduct = rs.getInt("Price");
					String picture = rs.getString("picture");
					boolean  typeProduct = rs.getBoolean("Type");
					Product objPro = new Product(idProduct, nameProduct, previewProduct, detailProduct, priceProduct, picture, typeProduct);
					alPro.add(objPro);
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
			
		}
		return alPro;
	}
	
	
}
