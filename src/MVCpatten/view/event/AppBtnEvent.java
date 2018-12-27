package MVCpatten.view.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import MVCpatten.model.Product;
import MVCpatten.model.ProductDAO;
import MVCpatten.view.AppUIsetting;


public class AppBtnEvent implements ActionListener {

	private AppUIsetting appUIset;
//	private ProductDAO productDAO;
	private ArrayList<Product> firstAllProduct;
	private JButton[] jbtn = new JButton[3];
	
	public AppBtnEvent(AppUIsetting appUIset, ArrayList<Product> firstAllProduct) {
		this.appUIset = appUIset;
		this.firstAllProduct = firstAllProduct;
		
		System.out.print(appUIset.getbtnPanel(3).getComponentCount());
		for(int i = 0; i < jbtn.length; i++) {
			this.jbtn[i] = (JButton) appUIset.getbtnPanel(3).getComponent(i);
		} // for
	} // 생성자
	
	@Override
	public void actionPerformed(ActionEvent e) {
				
		// 등록 버튼 액션
		if(e.getSource() == this.jbtn[0]) {
			System.out.print(this.jbtn[0].getText());
		} // if
		
		// 조회 버튼 액션
		if(e.getSource() == this.jbtn[1]) {
			
			this.appUIset.getTextArea().setText("");
			System.out.print(this.jbtn[1].getText());
			
			for(int i = 0; i < this.firstAllProduct.size(); i++) {
				String tempPrcode = String.valueOf(this.firstAllProduct.get(i).getPrcode());
				String tempPrname =this.firstAllProduct.get(i).getPrname();
				String tempPrice = String.valueOf(this.firstAllProduct.get(i).getPrice());
				String tempMenu = this.firstAllProduct.get(i).getManufacture().toString();
				this.appUIset.getTextArea().append(tempPrcode+", "+tempPrname+", "+tempPrice+", "+tempMenu);
			} // for

			
		} // if
		
		// 삭제 버튼 액션
		if(e.getSource() == this.jbtn[2]) {
			System.out.print(this.jbtn[2].getText());
		} // if
		
	} // actionPerformed()

} // AppBtnEvent Class
