package 객체지향설계_예제.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBconnection {

	private DBconfig dbConfigue;
	private Connection con;
	private Statement st; // connect에 SQL문장 실행하는 방법을 정해주는 객체
	private ResultSet rs; // SQL 결과 받아오는 객체
	
	// 기본 접속 시도해주는 Class
	public DBconnection() {
		// DB conntecion 관련 유저이름, 비밀번호 보안강화를 위한 계층작업
		dbConfigue = new DBconfig();
		
		// DB 커넥션 예외 처리 try - catch
		try {
			Class.forName("com.mysql.jdbc.Driver"); // library의 Dirver Class참조
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb?characterEncoding=UTF-8&serverTimezone=UTC", 
					dbConfigue.getdbName(), dbConfigue.getdbPass());
			st = con.createStatement();
		} catch(Exception e) {
			System.out.println("DB error : " + e.getMessage());
		} // try - catch
	} // 생성자
	
	public ResultSet getRecodeAll() {
		try {
			String SQL = "SELECT * FROM `member`"; // ORDER BY `score` DESC"
			rs = st.executeQuery(SQL); // rs가 SQL 구문의 결과 행 값들을 가지게 된다.
			if(rs.next()) { // SQL구문의 결과값이 존재한다면
				return rs;
			} // if
		} catch(Exception e) {
			System.out.println(" DB searching error (in SQL 구문) : " + e.getMessage());
		} // try - catch
		return rs;
	}
	
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
	
} // DBConnection Class