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
	
	public ArrayList<ProductDTO> getAll(){
		this.connectDB();
		this.SQL = "SELECT * FROM product"; // 모든 레코드 가져오기
		
		// 전체 검색 결과 전달 ArrayList 
		ArrayList<ProductDTO> datas = new ArrayList<ProductDTO>();
		
		//관리번호 콤보박스 데이터를 위한 벡터 초기화 -> 'prcode' 의 string 값만 사용할 것
		items = new Vector<String>();
		items.add("전체");
		
		// reading All elements untill the end
		try {
			// DB에 질의 던지기 (ALL)
			pstmt = conn.prepareStatement(this.SQL);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO p = new ProductDTO();
				p.setPrcode(rs.getInt("prcode"));
				p.setPrname(rs.getString("prname"));
				p.setPrice(rs.getInt("price"));
				p.setManufacture(rs.getString("manufacture"));

				// adding to list
				datas.add(p);
				items.add(String.valueOf(rs.getInt("prcode"))); // 콤보박스에 prcode내용 다 삽입				
			} // while
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try - catch
		
		this.closeDB();		
		// DB에서 가져온 모든 Product 형식이 object 가지고 있는 ArrayList datas 리턴
		return datas;
	} // getAll()
	
	// prcode -> comboBox에 넣어져 있고, 그에 해당하는 Product 가져오기
	public ProductDTO getProduct(int prcode) {
		this.connectDB();
		this.SQL = "SELECT * FROM `product` WHERE `prcode` = ?";
		ProductDTO p = null;
		
		try{
			pstmt = conn.prepareStatement(this.SQL);
			pstmt.setInt(1, prcode);
			this.rs = pstmt.executeQuery();
			// prcode는 Primary Key (기본키) -> 즉 유일함 -> first 값만 조지면 됨
			rs.next();
			p = new ProductDTO();
			p.setPrcode(rs.getInt("prcode"));
			p.setPrname(rs.getString("prname"));
			p.setPrice(rs.getInt("price"));
			p.setManufacture(rs.getString("manufacture"));
		} catch(SQLException e) {
			e.printStackTrace();
		} // try - catch
		
		// 정상적으로 SQL 검색후 결과가 존재하면, Product object를 정상적으로 리턴
		if(p != null) {
			this.closeDB();
			return p;
		} else {
			System.out.print("SQL error OR DB error");
			this.closeDB();
			return null;
		} // if - else
	} // getProduct()
	
	// product 삽입하기
	public boolean newProduct(ProductDTO product) {
		this.connectDB();
		this.SQL = "INSERT INTO product VALUES(null, ?, ?, ?)";
		
		try{
			this.pstmt = conn.prepareStatement(this.SQL);
			pstmt.setString(1, product.getPrname());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getManufacture());			
			int resultIN = pstmt.executeUpdate();
			
			// 1 = 성공, 0 = 실패
			if (resultIN == 1) {
				this.closeDB();
				return true;
			} else {
				this.closeDB();
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} // try - catch
		this.closeDB();
		return false;
	} // newProduct()
	
	// product 삭제하기
	public boolean delProduct(int prcode) {
		this.connectDB();
		this.SQL = "DELETE FROM `product` WHERE `prcode` = ?";
		try{
			this.pstmt = conn.prepareStatement(this.SQL);
			pstmt.setInt(1, prcode);
			int resultDel = pstmt.executeUpdate();
			// 1 = 성공, 0 = 실패
			if (resultDel == 1) {
				this.closeDB();
				return true;
			} else {
				this.closeDB();
				return false;
			} // if - else
		} catch(SQLException e) {
			e.printStackTrace();
		} // try - catch
		this.closeDB();
		return false;
	}
	
	// product 수정하기
	public boolean updateProduct(ProductDTO product) {
		this.connectDB();
		this.SQL = "UPDATE `product` SET `prname`=?, `price`=?, `manufacture`=? WHERE `prcode` = ?";
		try{
			this.pstmt = conn.prepareStatement(this.SQL);
			pstmt.setString(1, product.getPrname());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getManufacture());
			pstmt.setInt(4, product.getPrcode());
			int resultUpdate = pstmt.executeUpdate();
			
			// 1 = 성공, 0 = 실패
			if (resultUpdate == 1) {
				this.closeDB();
				return true;
			} else {
				this.closeDB();
				return false;
			} // if - else
		} catch(SQLException e) {
			e.printStackTrace();
		} // try - catch
		this.closeDB();
		return false;
	}
	
	public Vector<String> getItems(){
		return this.items;
	}

}
