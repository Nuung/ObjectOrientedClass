package ykhelper.afterHomework;

public class Player {
	
	// member 
	private String name;
	private int score;
	
	public Player(String name) {
		this.name = name;
		this.score = 0;
	} // 생성자
	
	public void addScore(int cardNum) {
		this.score += cardNum;
	} // addScore()

	// Getter
	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}	
}