package 객체지향설계_예제;

import java.sql.ResultSet;
import java.sql.SQLException;

import 객체지향설계_예제.BaseGUI.BaseGUI;
import 객체지향설계_예제.DB.DBconnection;
import 객체지향설계_예제.Lambda.LambdaFormula;
import 객체지향설계_예제.file.FileInOut;
import 객체지향설계_예제.file.MemoJang;

public class testMain {
	
	public static void main(String[] args) {
		
		// for swing GUI
		new BaseGUI();
		DBconnection dbcon = new DBconnection();
		ResultSet resultAll = dbcon.getRecodeAll();
		
		try {
			do { // next하면 포인트가 다음을 다르킨다 생각하자
				String result_id = resultAll.getString("id");
				String result_username = resultAll.getString("username");
				String result_dept = resultAll.getString("dept");
				String result_birth = resultAll.getString("birth");
				String result_email = resultAll.getString("email");
				System.out.println(result_id+", "+result_username+", "+result_dept+", "+result_birth+", "+result_email);
			} while(resultAll.next()); // do - while : 첫번째 결과 row값도 실행하기 위해
		} catch (SQLException e) {
			e.printStackTrace();
		} // try - catch
		
//		// for FileInOut class
//		String Path1, Path2;
//		Path1 = "test1.txt";
//		Path2 = "test2.txt";
//		new FileInOut(Path1, Path2);
		
//		// for MemoJang class
//		new MemoJang();
		
//		LambdaFormula test = new LambdaFormula(0, 0);
		
		
	} // main
	
}
