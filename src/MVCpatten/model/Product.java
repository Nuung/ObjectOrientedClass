package MVCpatten.model;

public class Product {
	
	// DB와 Data 교류를 위함 -> 컬럼 정보에 따른 필드(맴버)선언
	private int prcode;
	private String prname;
	private int price;
	private String manufacture;
	
	// getter and setter
	public int getPrcode() {
		return prcode;
	}
	public void setPrcode(int prcode) {
		this.prcode = prcode;
	}
	public String getPrname() {
		return prname;
	}
	public void setPrname(String prname) {
		this.prname = prname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}


} // Product Class
