package 객체지향설계_예제.DB.event;

import java.util.Scanner;

import 객체지향설계_예제.DB.DBconnection;

public class EventRegist {

	private DBconnection dbcon;
	private Scanner scanner = new Scanner(System.in);
	
	// Event 중간 처리 통로 
	public EventRegist() {
		
		this.dbcon = new DBconnection();
		
		System.out.println("## 이벤트 등록을 위해 이름과 이메일을 입력하세요");
		System.out.print("## 이름 : ");
		String uname = scanner.next();
		System.out.print("## 이메일 : ");
		String email = scanner.next();
		
		this.dbcon.connectDB();
		this.dbcon.registUser(uname, email); // 이름과 이메일 INSERT INTO
		System.out.println("## 등록자 명단");
		this.dbcon.printList(); // SELECT * FROM evnet -> reading all
		this.dbcon.closeDB();

	}

}
