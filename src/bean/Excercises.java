package bean;

public class Excercises {
	private int idExcercise;
	private String nameExcercise;
	private String previewExcercise;
	private String detailExcercise;
	private String picture;
	public int getIdExcercise() {
		return idExcercise;
	}
	public void setIdExcercise(int idExcercise) {
		this.idExcercise = idExcercise;
	}
	public String getNameExcercise() {
		return nameExcercise;
	}
	public void setNameExcercise(String nameExcercise) {
		this.nameExcercise = nameExcercise;
	}
	public String getPreviewExcercise() {
		return previewExcercise;
	}
	public void setPreviewExcercise(String previewExcercise) {
		this.previewExcercise = previewExcercise;
	}
	public String getDetailExcercise() {
		return detailExcercise;
	}
	public void setDetailExcercise(String detailExcercise) {
		this.detailExcercise = detailExcercise;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Excercises(int idExcercise, String nameExcercise,
			String previewExcercise, String detailExcercise, String picture) {
		super();
		this.idExcercise = idExcercise;
		this.nameExcercise = nameExcercise;
		this.previewExcercise = previewExcercise;
		this.detailExcercise = detailExcercise;
		this.picture = picture;
	}
	public Excercises() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
