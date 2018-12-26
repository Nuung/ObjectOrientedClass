//package MVCpatten.model;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Vector;
//
//public class ProductDAO {
//	
//	// member -> 멤버의 필드 값들이 곧 DB에서 '컬럼' 의 속성과 같음을 명시하자! -> Product Class 참조
//	// 실제 멤버는 DB setting 위한 변수들
//	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
//	private String jdbcUrl = "jdbc:mysql://localhost:3306/javadb";
//	private Connection conn;
//	private PreparedStatement pstmt;
//	private ResultSet rs;
//
//	try {
//		pstmt = conn.prepareStatement("INSERT INTO `product` VALUES(?, ?, ?, ?)");
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} // try - catch
//	 
//	// 콤보박스 아이템 관리를 위한 벡터
//	Vector<String> items = null;
//	String SQL;
//	
//	// 생성자
//	public ProductDAO() {
//		
//	}
//	
//	void connectDB() {
//		
//	}
//	
//	void closeDB() {
//		
//	}
//	
//	ArrayList<Product> getAll(){
//		connectDB();
//		this.SQL = "SELECT * FROM product";
//		
//		// 전체 검색 결과 전달 ArrayList 
//		ArrayList<Product> datas = new ArrayList<Product>();
//		
//		//관리번호 콤보박스 데이터를 위한 벡터 초기화 -> 'prcode' 의 string 값만 사용할 것
//		items = new Vector<String>();
//		items.add("전체");
//		
//		// reading All elements untill the end
//		try {
//			while(rs.next()) {
//				Product p = new Product();
//				p.setPrcode(rs.getInt("prcode"));
//				p.setPrname(rs.getString("prname"));
//				p.setPrice(rs.getInt("price"));
//				p.setManufacture(rs.getString("manufacture"));
//
//				// adding to list
//				datas.add(p);
//				items.add(String.valueOf(rs.getInt("prcode")));				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} // try - catch
//		
//		return null;
//	}
//	
//	Product getProduct(int prcode) {
//		return null;
//	}
//	
//	boolean newProduct(Product product) {
//		return true;
//	}
//	
//	boolean delProduct(int prcode) {
//		return true;
//	}
//	
//	boolean updateProduct(Product product) {
//		return true;
//	}
//	
//	Vector<String> getItems(){
//		return null;
//	}
//	
//	
//	
//
//}
