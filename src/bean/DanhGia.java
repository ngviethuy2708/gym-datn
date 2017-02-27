package bean;

public class DanhGia {
	int idDanhGia;
	int idUsers;
	int idProducts;
	int danhGia;
	public int getIdDanhGia() {
		return idDanhGia;
	}
	public void setIdDanhGia(int idDanhGia) {
		this.idDanhGia = idDanhGia;
	}
	public int getIdUsers() {
		return idUsers;
	}
	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}
	public int getIdProducts() {
		return idProducts;
	}
	public void setIdProducts(int idProducts) {
		this.idProducts = idProducts;
	}
	public int getDanhGia() {
		return danhGia;
	}
	public void setDanhGia(int danhGia) {
		this.danhGia = danhGia;
	}
	public DanhGia(int idDanhGia, int idUsers, int idProducts, int danhGia) {
		super();
		this.idDanhGia = idDanhGia;
		this.idUsers = idUsers;
		this.idProducts = idProducts;
		this.danhGia = danhGia;
	}
	public DanhGia() {
		super();
	}
	
}
