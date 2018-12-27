package MVCpatten.view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;

import MVCpatten.model.Product;
import MVCpatten.model.ProductDAO;
import MVCpatten.view.event.AppBtnEvent;

public class AppMain extends JFrame {

	// member value
	private final int WIDTH = 800, HEIGHT = 300;
	private AppUIsetting appUIset;
	private ProductDAO productDAO;
	private ArrayList<Product> firstAllProduct = new ArrayList<Product>();
	
	public AppMain() {
		this.productDAO = new ProductDAO();
		firstAllProduct= this.productDAO.getAll(); // same with the 'datas'!
		this.startUI();
	}
	
	// UI 화면 구성 메서드
	private void startUI() {	
		
		this.appUIset = new AppUIsetting(this, this.productDAO.getItems());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("MVC Patten Desgin");
		this.setBackground(Color.WHITE);
		this.setSize(WIDTH, HEIGHT);
		this.setVisible(true);
		
		// btn Action handdler
		this.AppBtnEvent();
	} // startUI()
	
	// 각 메뉴에다 적절하게 이벤트 떄려박기
	private void AppBtnEvent() {
		AppBtnEvent btnAction = new AppBtnEvent(this.appUIset, this.firstAllProduct);
		int btnCounter = this.appUIset.getbtnPanel(3).getComponentCount();
		for(int i = 0; i < btnCounter; i++) {
			JButton jbtnTemp = (JButton) this.appUIset.getbtnPanel(3).getComponent(i);
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
