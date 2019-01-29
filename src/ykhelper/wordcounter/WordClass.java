package ykhelper.wordcounter;

import java.util.Arrays;
import java.util.Vector;

public class WordClass {

	// member
	private Vector<String> wordMap = new Vector<>();
	
	// 생성자
	public WordClass(String input) {
		this.WordCounter(input);
	}
	
	private void WordCounter(String input) {
		String[] wordList = input.split(" ");
		Arrays.sort(wordList); // sorting clear
		int temp = 0;
		
		for (int i = 0; i < wordList.length; i++) {
			for (int j = 0; j < wordList.length; j++) {
				if(wordList[i].equals(wordList[j])){
					temp++;
				} // if
			} // inner for
			
			this.wordMap.add(wordList[i] + " : " + temp);
			i += temp - 1;
			temp = 0;
		} // for
	} // WordCounter()
	
	public void printWordMap() {
        for (int i = 0; i < this.wordMap.size(); i++) {
        	System.out.println(this.wordMap.get(i));
		} // for
	} // printWordMap()
}
