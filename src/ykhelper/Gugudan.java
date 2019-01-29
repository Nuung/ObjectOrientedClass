package ykhelper;

import java.util.HashMap;
import java.util.Scanner;

public class Gugudan {

	public static void main(String[] args) {
		
		HashMap <Integer, String> guguMap = new HashMap<>();
		String guguDanOutput;
		String tempString = ""; 
		
		//1.guguMap에 구구단 2단에서 9단까지 저장
		for (int i = 2; i < 10; i++) {
			tempString = "";
			for (int j = 1; j < 10; j++) {
				if (j == 9) {
					tempString += String.valueOf(i*j);
					continue;
				} // if for Not include last word ','
				tempString += String.valueOf(i*j) + ",";
			} // inner for
			guguMap.put(i, tempString);
		} // for
		
        //2.콘솔창으로 부터 인트 데이터를 입력 받음
		Scanner sc = new Scanner(System.in);
		System.out.println("출력할 단 수를 입력 하세요");
        int input = sc.nextInt();
        System.out.println(input);
		
        //3.입력 받은 인트데이터(input)을 키로 guguMap에서  구구단 문자열(guguDanOutput)을 취득하여 콘솔창 에 출력
        guguDanOutput = guguMap.get(input);
        System.out.println(guguDanOutput);
        
	} // main()
}
