package ykhelper.wordcounter;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		ArrayList<WordClass> totalWordList = new ArrayList<>();
		
		System.out.println("Insert String"); // 입력 알람줄
		String inputString = sc.nextLine(); // 입력받기
		
		while(!inputString.equals("END")) {
			WordClass tempWordClass = new WordClass(inputString);
			totalWordList.add(tempWordClass);
			inputString = sc.nextLine();
		} // while
		
		for (int i = 0; i < totalWordList.size(); i++) {
			totalWordList.get(i).printWordMap();
		} // for
		
	} // main	
}
