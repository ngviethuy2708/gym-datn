package bean;

import java.sql.Date;

public class Bill {
	private int idBill;
	private int idUser;
	private int idPayment;
	private String userName;
	private String fullName;
	private Date birthDay;
	private String address;
	private String phone;
	private String information;
	private String namePayment;
	private Date dateOrder;
	private boolean tranfer;
	private boolean ship;
	public int getIdBill() {
		return idBill;
	}
	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public String getNamePayment() {
		return namePayment;
	}
	public void setNamePayment(String namePayment) {
		this.namePayment = namePayment;
	}
	public Date getDateOrder() {
		return dateOrder;
	}
	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}
	public boolean isTranfer() {
		return tranfer;
	}
	public void setTranfer(boolean tranfer) {
		this.tranfer = tranfer;
	}
	public boolean isShip() {
		return ship;
	}
	public void setShip(boolean ship) {
		this.ship = ship;
	}
	
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdPayment() {
		return idPayment;
	}
	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}
	public Bill(int idBill, int idUser, int idPayment, String information,
			Date dateOrder, boolean tranfer, boolean ship) {
		super();
		this.idBill = idBill;
		this.idUser = idUser;
		this.idPayment = idPayment;
		this.information = information;
		this.dateOrder = dateOrder;
		this.tranfer = tranfer;
		this.ship = ship;
	}
	public Bill(int idBill, String userName, String fullName, Date birthDay,
			String address, String phone, String information,
			String namePayment, Date dateOrder, boolean tranfer, boolean ship) {
		super();
		this.idBill = idBill;
		this.userName = userName;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.address = address;
		this.phone = phone;
		this.information = information;
		this.namePayment = namePayment;
		this.dateOrder = dateOrder;
		this.tranfer = tranfer;
		this.ship = ship;
	}
	
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
