package bean;

public class Training {
	private int idTraining;
	private String nameTraining;
	private int dayTraining;
	private int priceTraining;
	public int getIdTraining() {
		return idTraining;
	}
	public void setIdTraining(int idTraining) {
		this.idTraining = idTraining;
	}
	public String getNameTraining() {
		return nameTraining;
	}
	public void setNameTraining(String nameTraining) {
		this.nameTraining = nameTraining;
	}
	public int getDayTraining() {
		return dayTraining;
	}
	public void setDayTraining(int dayTraining) {
		this.dayTraining = dayTraining;
	}
	public int getPriceTraining() {
		return priceTraining;
	}
	public void setPriceTraining(int priceTraining) {
		this.priceTraining = priceTraining;
	}
	public Training(int idTraining, String nameTraining, int dayTraining,
			int priceTraining) {
		super();
		this.idTraining = idTraining;
		this.nameTraining = nameTraining;
		this.dayTraining = dayTraining;
		this.priceTraining = priceTraining;
	}
	public Training() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
