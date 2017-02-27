package bean;

import java.sql.Date;

public class Register {
	private int idRegister;
	private int idUsers;
	private int idTraining;
	private String userName;
	private String fullName;
	private Date birthDay;
	private String phoneNumber;
	private String trainingName;
	private int trainingDay;
	private int trainingPrice;
	private Date beginDate;
	private Date endDate;
	private boolean type;
	
	
	public int getIdTraining() {
		return idTraining;
	}
	public void setIdTraining(int idTraining) {
		this.idTraining = idTraining;
	}
	public int getIdUsers() {
		return idUsers;
	}
	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}
	public int getIdRegister() {
		return idRegister;
	}
	public void setIdRegister(int idRegister) {
		this.idRegister = idRegister;
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public int getTrainingDay() {
		return trainingDay;
	}
	public void setTrainingDay(int trainingDay) {
		this.trainingDay = trainingDay;
	}
	public int getTrainingPrice() {
		return trainingPrice;
	}
	public void setTrainingPrice(int trainingPrice) {
		this.trainingPrice = trainingPrice;
	}
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isType() {
		return type;
	}
	public void setType(boolean type) {
		this.type = type;
	}
	public Register(int idRegister, String userName, String fullName,
			Date birthDay, String phoneNumber, String trainingName,
			int trainingDay, int trainingPrice, Date beginDate, Date endDate,
			boolean type) {
		super();
		this.idRegister = idRegister;
		this.userName = userName;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.phoneNumber = phoneNumber;
		this.trainingName = trainingName;
		this.trainingDay = trainingDay;
		this.trainingPrice = trainingPrice;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.type = type;
	}
	
	
	public Register(int idRegister, int idTraining, Date beginDate, Date endDate) {
		super();
		this.idRegister = idRegister;
		this.idTraining = idTraining;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	public Register(int idRegister, int idUsers, int idTraining,
			String userName, String fullName, Date beginDate, Date endDate) {
		super();
		this.idRegister = idRegister;
		this.idUsers = idUsers;
		this.idTraining = idTraining;
		this.userName = userName;
		this.fullName = fullName;
		this.beginDate = beginDate;
		this.endDate = endDate;
	}
	
	public Register(String userName, String fullName, Date birthDay,
			String phoneNumber, String trainingName, int trainingDay,
			int trainingPrice, Date beginDate, Date endDate, boolean type) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.phoneNumber = phoneNumber;
		this.trainingName = trainingName;
		this.trainingDay = trainingDay;
		this.trainingPrice = trainingPrice;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.type = type;
	}
	
	
	public Register(int idRegister, int idUsers, int idTraining,
			Date beginDate, Date endDate, boolean type) {
		super();
		this.idRegister = idRegister;
		this.idUsers = idUsers;
		this.idTraining = idTraining;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.type = type;
	}
	public Register(int idUsers, Date endDate) {
		super();
		this.idUsers = idUsers;
		this.endDate = endDate;
	}
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
