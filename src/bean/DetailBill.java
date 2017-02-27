package bean;

public class DetailBill {
	private int id;
	private int idbill;
	private int idProduct;
	private String nameProduct;
	private String pictureProduct;
	private int priceProduct;
	private int numOfProduct;
	private int intoMoney;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public String getPictureProduct() {
		return pictureProduct;
	}
	public void setPictureProduct(String pictureProduct) {
		this.pictureProduct = pictureProduct;
	}
	public int getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(int priceProduct) {
		this.priceProduct = priceProduct;
	}
	public int getNumOfProduct() {
		return numOfProduct;
	}
	public void setNumOfProduct(int numOfProduct) {
		this.numOfProduct = numOfProduct;
	}
	public int getIntoMoney() {
		return intoMoney;
	}
	public void setIntoMoney(int intoMoney) {
		this.intoMoney = intoMoney;
	}
	
	public int getIdbill() {
		return idbill;
	}
	public void setIdbill(int idbill) {
		this.idbill = idbill;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	
	public DetailBill(int id, int idbill, int idProduct, int numOfProduct) {
		super();
		this.id = id;
		this.idbill = idbill;
		this.idProduct = idProduct;
		this.numOfProduct = numOfProduct;
	}
	public DetailBill(int id, String nameProduct, String pictureProduct,
			int priceProduct, int numOfProduct, int intoMoney) {
		super();
		this.id = id;
		this.nameProduct = nameProduct;
		this.pictureProduct = pictureProduct;
		this.priceProduct = priceProduct;
		this.numOfProduct = numOfProduct;
		this.intoMoney = intoMoney;
	}
	public DetailBill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
