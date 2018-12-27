package MVCpatten.view.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import MVCpatten.model.Product;
import MVCpatten.model.ProductDAO;
import MVCpatten.view.AppMain;
import MVCpatten.view.AppUIsetting;


public class AppBtnEvent implements ActionListener {

	private AppMain appMain;
	private AppUIsetting appUIset;
	private ProductDAO productDAO;
	private ArrayList<Product> firstAllProduct;
	private JButton[] jbtn = new JButton[3];
	
	public AppBtnEvent(AppMain appMain) {
		this.appMain = appMain;
		this.appUIset = appMain.getAppUIset();
		this.productDAO = appMain.getProductDAO();
		
		System.out.print(appUIset.getbtnPanel(3).getComponentCount());
		for(int i = 0; i < jbtn.length; i++) {
			this.jbtn[i] = (JButton) appUIset.getbtnPanel(3).getComponent(i);
		} // for
	} // 생성자
	
	@Override
	public void actionPerformed(ActionEvent e) {
				
		// 등록 버튼 액션
		if(e.getSource() == this.jbtn[0]) {
			
			JTextField tempPname = (JTextField) this.appUIset.getbtnPanel(2).getComponent(1);
			JTextField tempPrice = (JTextField) this.appUIset.getbtnPanel(2).getComponent(2);
			JTextField tempManu = (JTextField) this.appUIset.getbtnPanel(2).getComponent(3);
			
			Product p = new Product();
			p.setPrname(tempPname.getText());
			p.setPrice(Integer.parseInt(tempPrice.getText()));
			p.setManufacture(tempManu.getText());
			
			System.out.println(this.productDAO.newProduct(p));
			this.actionInquiry();
//			this.appMain.refreshData();
			this.appMain.clearField();
		} // if
		
		// 조회 버튼 액션
		if(e.getSource() == this.jbtn[1]) {
			this.actionInquiry();
		} // if
		
		// 삭제 버튼 액션
		if(e.getSource() == this.jbtn[2]) {
			int findPrcode = Integer.parseInt((String) this.appUIset.getComboBox().getSelectedItem());
			int result = JOptionPane.showConfirmDialog(this.appMain, "진짜"+findPrcode+"번을 삭제하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {
				System.out.print(this.productDAO.delProduct(findPrcode));
				this.appUIset.getComboBox().setSelectedItem("전체");
				this.actionInquiry();
			} // inner 'yes' if
		} // if
		
	} // actionPerformed()
	
	private void actionInquiry() {
		this.appUIset.getTextArea().setText("관리번호\t상품평\t단가\t제조사\n");
		
		if((String) this.appUIset.getComboBox().getSelectedItem() == "전체") {
			// gettig All recode
			this.firstAllProduct = productDAO.getAll();
			
			for(int i = 0; i < this.firstAllProduct.size(); i++) {
				String tempPrcode = String.valueOf(this.firstAllProduct.get(i).getPrcode());
				String tempPrname =this.firstAllProduct.get(i).getPrname();
				String tempPrice = String.valueOf(this.firstAllProduct.get(i).getPrice());
				String tempManu = this.firstAllProduct.get(i).getManufacture();
				this.appUIset.getTextArea().append(tempPrcode+"\t"+tempPrname+"\t"+tempPrice+"\t"+tempManu+"\n");
				this.appMain.clearField();
			} // for
		} // if
		else {
			int findPrcode = Integer.parseInt((String) this.appUIset.getComboBox().getSelectedItem());
			Product Ptemp = this.productDAO.getProduct(findPrcode);

			String tempPrcode = String.valueOf(Ptemp.getPrcode());
			String tempPrname =Ptemp.getPrname();
			String tempPrice = String.valueOf(Ptemp.getPrice());
			String tempManu = Ptemp.getManufacture();
			this.appUIset.getTextArea().append(tempPrcode+"\t"+tempPrname+"\t"+tempPrice+"\t"+tempManu+"\n");
			
			((JTextField) this.appUIset.getbtnPanel(2).getComponent(1)).setText(tempPrname);
			((JTextField) this.appUIset.getbtnPanel(2).getComponent(2)).setText(tempPrice);
			((JTextField) this.appUIset.getbtnPanel(2).getComponent(3)).setText(tempManu);
			
		} // if - else
	}

} // AppBtnEvent Class
