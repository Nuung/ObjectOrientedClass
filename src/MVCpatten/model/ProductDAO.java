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
				items.add(String.valueOf(rs.getInt("prcode"))); // 콤보박스에 prcode내용 다 삽입				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try - catch
		
		// DB에서 가져온 모든 Product 형식이 object 가지고 있는 ArrayList datas 리턴
		return datas;
	} // getAll()
	
	// prcode -> comboBox에 넣어져 있고, 그에 해당하는 Product 가져오기
	Product getProduct(int prcode) {
		this.SQL = "SELECT * FROM `product` WHERE `prcode` = ?";
		Product p = null;
		
		try{
			pstmt = conn.prepareStatement(this.SQL);
			pstmt.setInt(1, prcode);
			this.rs = pstmt.executeQuery();
			// prcode는 Primary Key (기본키) -> 즉 유일함 -> first 값만 조지면 됨
			rs.next();
			p = new Product();
			p.setPrcode(rs.getInt("prcode"));
			p.setPrname(rs.getString("prname"));
			p.setPrice(rs.getInt("price"));
			p.setManufacture(rs.getString("manufacture"));
		} catch(SQLException e) {
			e.printStackTrace();
		} // try - catch
		
		// 정상적으로 SQL 검색후 결과가 존재하면, Product object를 정상적으로 리턴
		if(p != null) {
			return p;
		} else {
			System.out.print("SQL error OR DB error");
			return null;
		} // if - else
	} // getProduct()
	
	// product 삽입하기
	boolean newProduct(Product product) {
		this.SQL = "INSERT INTO `product` VALUES(?, ?, ?, ?)";
		
		try{
			this.pstmt = conn.prepareStatement(this.SQL);
			pstmt.setInt(1, product.getPrcode());
			pstmt.setString(2, product.getPrname());
			pstmt.setInt(3, product.getPrice());
			pstmt.setString(4, product.getManufacture());
			int resultIN = pstmt.executeUpdate();
			
			// 1 = 성공, 0 = 실패
			if (resultIN == 1) {
				return true;
			} else {
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} // try - catch
		return false;
	} // newProduct()
	
	// product 삭제하기
	boolean delProduct(int prcode) {
		this.SQL = "DELETE FROM `product` WHERE `prcode` = ?";
		try{
			this.pstmt = conn.prepareStatement(this.SQL);
			pstmt.setInt(1, prcode);
			int resultDel = pstmt.executeUpdate();
			// 1 = 성공, 0 = 실패
			if (resultDel == 1) {
				return true;
			} else {
				return false;
			} // if - else
		} catch(SQLException e) {
			e.printStackTrace();
		} // try - catch
		return false;
	}
	
	// product 수정하기
	boolean updateProduct(Product product) {
		this.SQL = "UPDATE `product` SET `prname`=? `price`=? `manfacture`=? WHERE `prcode` = ?";
		try{
			this.pstmt = conn.prepareStatement(this.SQL);
			pstmt.setString(1, product.getPrname());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getManufacture());
			pstmt.setInt(4, product.getPrice());
			int resultUpdate = pstmt.executeUpdate();
			
			// 1 = 성공, 0 = 실패
			if (resultUpdate == 1) {
				return true;
			} else {
				return false;
			} // if - else
		} catch(SQLException e) {
			e.printStackTrace();
		} // try - catch
		return false;
	}
	
	Vector<String> getItems(){
		return this.items;
	}

}
