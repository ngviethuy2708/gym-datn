package bean;

public class Payments {
	private int idPayments;
	private String namePayMents;
	private String Detail;
	public int getIdPayments() {
		return idPayments;
	}
	public void setIdPayments(int idPayments) {
		this.idPayments = idPayments;
	}
	public String getNamePayMents() {
		return namePayMents;
	}
	public void setNamePayMents(String namePayMents) {
		this.namePayMents = namePayMents;
	}
	
	public String getDetail() {
		return Detail;
	}
	public void setDetail(String detail) {
		Detail = detail;
	}
	
	public Payments(int idPayments, String namePayMents, String detail) {
		super();
		this.idPayments = idPayments;
		this.namePayMents = namePayMents;
		Detail = detail;
	}
	public Payments(int idPayments, String namePayMents) {
		super();
		this.idPayments = idPayments;
		this.namePayMents = namePayMents;
	}
	
	public Payments() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
