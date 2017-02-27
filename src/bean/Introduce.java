package bean;

public class Introduce {
	private int idIntroduce;
	private String nameIntroduce;
	private String previewIntroduce;
	private String detailIntroduce;
	private String picture;
	public int getIdIntroduce() {
		return idIntroduce;
	}
	public void setIdIntroduce(int idIntroduce) {
		this.idIntroduce = idIntroduce;
	}
	public String getNameIntroduce() {
		return nameIntroduce;
	}
	public void setNameIntroduce(String nameIntroduce) {
		this.nameIntroduce = nameIntroduce;
	}
	public String getPreviewIntroduce() {
		return previewIntroduce;
	}
	public void setPreviewIntroduce(String previewIntroduce) {
		this.previewIntroduce = previewIntroduce;
	}
	public String getDetailIntroduce() {
		return detailIntroduce;
	}
	public void setDetailIntroduce(String detailIntroduce) {
		this.detailIntroduce = detailIntroduce;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Introduce(int idIntroduce, String nameIntroduce,
			String previewIntroduce, String detailIntroduce, String picture) {
		super();
		this.idIntroduce = idIntroduce;
		this.nameIntroduce = nameIntroduce;
		this.previewIntroduce = previewIntroduce;
		this.detailIntroduce = detailIntroduce;
		this.picture = picture;
	}
	public Introduce() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}	
