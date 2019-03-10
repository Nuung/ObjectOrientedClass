package ykhelper.afterHomework;

import java.util.Scanner;
import java.util.Random;

public class BlackJack {
	Player chul = new Player("철수");
	Player deal = new Player("딜러");
	Random rd = new Random();
	Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]) {
		System.out.println("Start of BlackJack Game");
	} // main
	
	private void gettingCard(int order) {
		System.out.println("◇"+order+"번째 카드를 받았습니다.");
		int cardNum = rd.nextInt() + (10 - 1 +1) +1;
		System.out.println(deal.getName()+"의 "+order+"번째 카드");
		cardNum = rd.nextInt() + (10 - 1 +1) +1;
		System.out.println("○"+chul.getName()+"의 "+order+"번째 카드");
		System.out.println("> Stop or Go : ");
		
		if(sc.next()=="stop" && order==1) {
			System.out.println("※두번째 카드를 받은 뒤부터 결과를 확인할 수 있습니다.");
		} // if
	} // gettingCard()
	
}
