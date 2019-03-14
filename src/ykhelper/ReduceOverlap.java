package ykhelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReduceOverlap {

	public static void main(String args[]) {
		int[] input = new int[10];
		int[] tempArr = new int[21];
		ArrayList<Integer> output = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < input.length; i++) {
			int tempInput = sc.nextInt();
			
			if(tempInput <= 10 && tempInput >= -10) {
				input[i] = tempInput;
			} else {
				System.out.println("입력 범위를 벗어났습니다.");
				return;
			} // if - else
			tempArr[i] = 0;
		}
		
		for(int i = 0; i < input.length; i++) {
			tempArr[input[i]+10]++;
		}
		
		for(int i = 0; i < tempArr.length; i++) {
			if(tempArr[i] == 1) {
				output.add(i-10);
			} // if
		} // for
		
		Collections.sort(output);
		printArray(output);
	}
	
	// printing all about ArrayList
	private static void printArray(ArrayList<Integer> list) { 
		for (int i = 0; i < list.size(); i++) { 
			System.out.print(list.get(i) + " "); 
		} // for
		System.out.println(); 
	}
	
}
