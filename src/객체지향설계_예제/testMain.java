//
//package 객체지향설계_예제;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import 객체지향설계_예제.BaseGUI.BaseGUI;
//import 객체지향설계_예제.DB.DBconnection;
//import 객체지향설계_예제.DB.event.EventRegist;
//import 객체지향설계_예제.Lambda.LambdaFormula;
//import 객체지향설계_예제.file.FileInOut;
//import 객체지향설계_예제.file.MemoJang;
//
//public class testMain {
//	
//	public static void main(String[] args) {
//
//		new EventRegist();
//		
////		// for swing GUI
////		new BaseGUI();
//		
//		// member table 사용할때 전체 레코드 연습 코드
//		{ 
//			/*
//			// for db Setting
//			DBconnection dbcon = new DBconnection();
//			ResultSet resultAll = dbcon.getRecodeAll(); // SELECT ALL!
//			
//			try {
//				do { // next하면 포인트가 다음을 다르킨다 생각하자
//					String result_id = resultAll.getString("id");
//					String result_username = resultAll.getString("username");
//					String result_dept = resultAll.getString("dept");
//					String result_birth = resultAll.getString("birth");
//					String result_email = resultAll.getString("email");
//					System.out.println(result_id+", "+result_username+", "+result_dept+", "+result_birth+", "+result_email);
//				} while(resultAll.next()); // do - while : 첫번째 결과 row값도 실행하기 위해
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} // try - catch
//			*/
//		}
//		
//		
//		// JAVA I/O test
//		{
//			/*
//			// for FileInOut class
//			new FileInOut("test1.txt", "test2.txt");
//			
//			// for MemoJang class
//			new MemoJang();
//			
//			*/
//		}
//		
//		
//	} // main
//	
//}
