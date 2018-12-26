package 객체지향설계_예제.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DBconnection {

	private DBconfig dbConfigue;
	private Connection con;
	private Statement st; // connect에 SQL문장 실행하는 방법을 정해주는 객체
	private ResultSet rs; // SQL 결과 받아오는 객체
	
	// 기본 접속 시도해주는 Class
	public void connectDB() {
		// DB conntecion 관련 유저이름, 비밀번호 보안강화를 위한 계층작업
		this.dbConfigue = new DBconfig();
		
		// DB 커넥션 예외 처리 try - catch
		try {
			// cj 6 이상 버전 -> error meg 안뜨게
			Class.forName(this.dbConfigue.getJdbcDriver()); // library의 Dirver Class참조
			con = DriverManager.getConnection(this.dbConfigue.getJdbcUrl(),	dbConfigue.getdbName(), dbConfigue.getdbPass());
			st = con.createStatement();
		} catch(Exception e) {
			System.out.println("DB error : " + e.getMessage());
		} // try - catch
		
	} // 생성자
	
	public void closeDB() {
		try {
			this.rs.close();
			this.st.close();
			this.con.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet getRecodeAll() {
		
		try {
			String SQL = "SELECT * FROM `event`"; // ORDER BY `score` DESC"
			rs = st.executeQuery(SQL); // rs가 SQL 구문의 결과 행 값들을 가지게 된다.
			if(rs.next()) { // SQL구문의 결과값이 존재한다면
				return rs;
			} // if
		} catch(Exception e) {
			System.out.println(" DB searching error (in SQL 구문) : " + e.getMessage());
		} // try - catch
		
		return rs;
	} // getRecodeAll()
	
	public void registUser(String uname, String email){
		
		String SQL = "INSERT INTO `event` VALUES(?, ?)";
		try {
			// 3단계 : Statement 생성
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, uname);
			pstmt.setString(2, email);
			
			// 4단계 : SQL 문 쿼리 전송
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} // try - catch
		
	} // registUser()
	
	public void printList(){
		
		this.rs = this.getRecodeAll();
		try {
			while(rs.next()) {
				String result_uname = rs.getString("uname");
				String result_email = rs.getString("email");
				System.out.println(result_uname+", "+result_email);
			} // while
		} catch (SQLException e) {
			e.printStackTrace();
		} // try - catch
		
	} // printList()
	
//	public ResultSet setRecode
	
	{
	/* searching DB에서 testing
	// SQL, 실행 기본 구조
	public boolean isAdmin(String gooname) {
		try {
			String SQL = "SELECT * FROM `market` WHERE `gooname` = '"+ gooname +"'";
			rs = st.executeQuery(SQL); // rs가 SQL 구문의 결과 행 값들을 가지게 된다.
			if(rs.next()) { // SQL구문의 결과값이 존재한다면
				return true;
			}
		} catch(Exception e) {
			System.out.println(" DB searching error (in SQL 구문) : " + e.getMessage());
		} // try - catch
		return false;
	} // isAdmin()
	
	public ResultSet getResultSet(String gooname) {
		try {
			String SQL = "SELECT * FROM `market` WHERE `gooname` = '"+ gooname +"'";
			rs = st.executeQuery(SQL); // rs가 SQL 구문의 결과 행 값들을 가지게 된다.
			if(rs.next()) { // SQL구문의 결과값이 존재한다면
				return rs;
			} // if
		} catch(Exception e) {
			System.out.println(" DB searching error (in SQL 구문) : " + e.getMessage());
		} // try - catch
		return rs;
	}
	
	
	// DB에 Game Score Insert [ member DB ]
	public void InsertScore(int score) {
		int isInsert;
		String playerName = "HyeonWoo";
		
		try {
			String SQL = "INSERT INTO gamescore(name, score)";
			SQL += " VALUES(" + "'"+playerName+"', '"+score+"')";
			
			// DB값 UPDATE의 경우, 사용하는 메소드가 달라짐을 유의
			isInsert = st.executeUpdate(SQL);
			 System.out.println(isInsert > 0 ?"등록 성공":"등록 실패");
			
			 // DB 자원 반납
			 st.close(); con.close();
		} catch(Exception e) {
			System.out.println(" DB searching error (in SQL 구문) : " + e.getMessage());
		} // try - catch
	} // InsertScore()
	
	public ResultSet getLeaderBoard() {
		try {
			String SQL = "SELECT * FROM `gamescore` ORDER BY `score` DESC";
			rs = st.executeQuery(SQL); // rs가 SQL 구문의 결과 행 값들을 가지게 된다.
			if(rs.next()) { // SQL구문의 결과값이 존재한다면
				return rs;
			} // if
		} catch(Exception e) {
			System.out.println(" DB searching error (in SQL 구문) : " + e.getMessage());
		} // try - catch
		return rs;
	}
	
	public ResultSet getMyLeaderBoard(String name) {
		try {
			String SQL = "SELECT * FROM `gamescore` WHERE `name` = '"+ name +"' ORDER BY `score` DESC";
			rs = st.executeQuery(SQL); // rs가 SQL 구문의 결과 행 값들을 가지게 된다.
			if(rs.next()) { // SQL구문의 결과값이 존재한다면
				return rs;
			} // if
		} catch(Exception e) {
			System.out.println(" DB searching error (in SQL 구문) : " + e.getMessage());
		} // try - catch
		return rs;
	}
	*/
	}
	
} // DBConnection Class