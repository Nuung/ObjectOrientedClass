package MVCpatten.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

import MVCpatten.view.event.AppBtnEvent;

public class AppMain extends JFrame {

	// member value
	private final int WIDTH = 800, HEIGHT = 300;
	private AppUIsetting appUIset;
	
	public AppMain() {
		this.startUI();
	}
	
	// UI 화면 구성 메서드
	private void startUI() {	
		
		this.appUIset = new AppUIsetting(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("MVC Patten Desgin");
		this.setBackground(Color.WHITE);
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		
		// btn Action handdler
		this.AppBtnEvent(appUIset.getbtnPanel());
	} // startUI()
	
	// 각 메뉴에다 적절하게 이벤트 떄려박기
	private void AppBtnEvent(JPanel jpanelBtn) {
		AppBtnEvent btnAction = new AppBtnEvent(jpanelBtn);
		for(int i = 0; i < jpanelBtn.getComponentCount(); i++) {
			JButton jbtnTemp = (JButton) jpanelBtn.getComponent(i);
			jbtnTemp.addActionListener(btnAction);
		} // for
	} // AppBtnEvent
	
	// 화면 로딩 및 리로딩 이벤트 처리 메서드
	private void refreshData() {
		
	}
	
	// 입력 양식 초기화 메서드
	private void clearField() {
		
	}
	
}
