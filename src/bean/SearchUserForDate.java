package bean;

import java.sql.Date;

public class SearchUserForDate {
	private String type;
	private Date date;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public SearchUserForDate(String type, Date date) {
		super();
		this.type = type;
		this.date = date;
	}
	public SearchUserForDate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
