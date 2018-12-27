package MVCpatten.view;

import java.awt.Color;

import javax.swing.JFrame;

public class AppMain extends JFrame {

	private final int WIDTH = 1024, HEIGHT = 512;
	
	public AppMain() {
		this.startUI();
	}
	
	// UI 화면 구성 메서드
	private void startUI() {	
		
		new AppUIsetting(this);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("MVC Patten Desgin");
		this.setBackground(Color.WHITE);
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		
	} // startUI()
	
	// 이벤트 처리 전용 메서드
	private void actionPerformed() {
		
	}
	
	// 화면 로딩 및 리로딩 이벤트 처리 메서드
	private void refreshData() {
		
	}
	
	// 입력 양식 초기화 메서드
	private void clearField() {
		
	}
	
}
