package 객체지향설계_예제.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class MemoJang {

	// member val
	String filename;
	Scanner scanner;
	
	public MemoJang() {
		
		// init method
		init();
		
		try {
			// 버퍼를 이용해서 입 출력을 하기
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "euc-kr"));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "euc-kr")); 
			
			String s;
			// reading all untill read char 'q' , 'q' is end of the sentence
			while(!(s = reader.readLine()).equals("q")) {
				writer.write(s + "\r\n"); // 라인피드와 캐리지 리턴, window의 줄바꿈의 특징
			} // while
			
			// free all object
			reader.close();
			writer.close();
			scanner.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		// output method
		resultprint();
		
	} // MemoJang()
	
	private void init() {
		System.out.println("## 간단 메모장 v1.0 ##");
		System.out.print("## 저장할 파일명을 입력해 주세요 : ");
		scanner = new Scanner(System.in);
		this.filename = scanner.next();
		filename += ".txt";
		System.out.println("## 저장은 마지막 라인에 q를 입력해 주세요! \n");	
	}
	
	private void resultprint() {
		System.out.println("## 프로그램을 종료합니다.");
		System.out.println(filename + " << 이 저장 되었습니다!!");
	}
} 
