package MVCpatten.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

// Database Access 
public class ProductDAO {
	
	// DB config Setting
	private ProductDBconfig dbconfig = new ProductDBconfig();
	
	// member -> 멤버의 필드 값들이 곧 DB에서 '컬럼' 의 속성과 같음을 명시하자! -> Product Class 참조
	// 실제 멤버는 DB setting 위한 변수들
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	 
	// 콤보박스 아이템 관리를 위한 벡터
	Vector<String> items = null;
	String SQL;
	
	// 생성자
	public ProductDAO() {
		try {
			pstmt = conn.prepareStatement("INSERT INTO `product` VALUES(?, ?, ?, ?)");
		} catch (SQLException e) {
			e.printStackTrace();
		} // try - catch
	}
	
	void connectDB() {
		
		try {
			Class.forName(dbconfig.getJdbcDriver());
			conn = DriverManager.getConnection(dbconfig.getJdbcUrl(), dbconfig.getdbName(), dbconfig.getdbPass());
		} catch (Exception e) {
			e.printStackTrace();
		} // try - catch
		
	} // connectDB()
	
	void closeDB() {
	
		try {
			this.rs.close();
			this.pstmt.close();
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} // try - catch
		
	} // closeDB()
	
	ArrayList<Product> getAll(){
		this.connectDB();
		this.SQL = "SELECT * FROM product"; // 모든 레코드 가져오기
		
		// 전체 검색 결과 전달 ArrayList 
		ArrayList<Product> datas = new ArrayList<Product>();
		
		//관리번호 콤보박스 데이터를 위한 벡터 초기화 -> 'prcode' 의 string 값만 사용할 것
		items = new Vector<String>();
		items.add("전체");
		
		// reading All elements untill the end
		try {
			while(rs.next()) {
				Product p = new Product();
				p.setPrcode(rs.getInt("prcode"));
				p.setPrname(rs.getString("prname"));
				p.setPrice(rs.getInt("price"));
				p.setManufacture(rs.getString("manufacture"));

				// adding to list
				datas.add(p);
				items.add(String.valueOf(rs.getInt("prcode")));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try - catch
		
		return datas;
	} // getAll()
	
	Product getProduct(int prcode) {
		return null;
	}
	
	boolean newProduct(Product product) {
		return true;
	}
	
	boolean delProduct(int prcode) {
		return true;
	}
	
	boolean updateProduct(Product product) {
		return true;
	}
	
	Vector<String> getItems(){
		return null;
	}

}
