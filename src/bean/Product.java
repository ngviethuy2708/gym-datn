package bean;

import java.io.Serializable;

public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idProduct;
	private String nameProduct;
	private String previewProduct;
	private String detailProduct;
	private int priceProduct;
	private int number;
	private int priceBuy;
	private String picture;
	private boolean typeProduct;
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public String getPreviewProduct() {
		return previewProduct;
	}
	public void setPreviewProduct(String previewProduct) {
		this.previewProduct = previewProduct;
	}
	public String getDetailProduct() {
		return detailProduct;
	}
	public void setDetailProduct(String detailProduct) {
		this.detailProduct = detailProduct;
	}
	public int getPriceProduct() {
		return priceProduct;
	}
	public void setPriceProduct(int priceProduct) {
		this.priceProduct = priceProduct;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public boolean isTypeProduct() {
		return typeProduct;
	}
	public void setTypeProduct(boolean typeProduct) {
		this.typeProduct = typeProduct;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getPriceBuy() {
		return priceBuy;
	}
	public void setPriceBuy(int priceBuy) {
		this.priceBuy = priceBuy;
	}
	public Product(int idProduct, String nameProduct, String previewProduct,
			String detailProduct, int priceProduct, String picture,
			boolean typeProduct) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.previewProduct = previewProduct;
		this.detailProduct = detailProduct;
		this.priceProduct = priceProduct;
		this.picture = picture;
		this.typeProduct = typeProduct;
	}
	
	public Product(int idProduct, String nameProduct, String previewProduct,
			String detailProduct, int priceProduct, String picture) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.previewProduct = previewProduct;
		this.detailProduct = detailProduct;
		this.priceProduct = priceProduct;
		this.picture = picture;
	}
	
	
	public Product(int idProduct, String nameProduct, int priceProduct,
			int number, int priceBuy, String picture) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.priceProduct = priceProduct;
		this.number = number;
		this.priceBuy = priceBuy;
		this.picture = picture;
	}
		
	public Product(int idProduct) {
		super();
		this.idProduct = idProduct;
	}
	public Product(String nameProduct) {
		super();
		this.nameProduct = nameProduct;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
