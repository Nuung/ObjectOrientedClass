package MVCpatten.model;

// 구조체가 없는 JAVA에게 CLASS를 만들되, Struct처럼 사용한다 -> 메소드 호출엔 약간의 overhead가 존재한다
public class ProductDTO {
	
	// DB와 Data 교류를 위함 -> 컬럼 정보에 따른 필드(맴버)선언
	// data structer 처럼 하려면 get set 필요 없고 멤버를 그냥 다 public으로 한다 -> 구조체 처럼 사용
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
