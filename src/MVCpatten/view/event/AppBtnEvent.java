package MVCpatten.view.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import MVCpatten.model.ProductDTO;
import MVCpatten.model.ProductDAO;
import MVCpatten.view.AppMain;
import MVCpatten.view.AppUIsetting;


public class AppBtnEvent implements ActionListener {

	private AppMain appMain;
	private AppUIsetting appUIset;
	private ProductDAO productDAO;
	private ArrayList<ProductDTO> firstAllProduct;
	private JButton[] jbtn = new JButton[3];
	private Boolean IsCanRevise = false;
	
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
			
			// 특정 상품을 조회한 뒤 -> 수정 가능한 상태로 설정
			if(this.IsCanRevise) { // 수정 가능한 상태라면, -> where = combobox's prcode
				
				// combobox에 해당하는 prcode를 가진 Product 찾고 -> update
				int findPrcode = Integer.parseInt((String) this.appUIset.getComboBox().getSelectedItem());
				JTextField tempPname = (JTextField) this.appUIset.getbtnPanel(2).getComponent(1);
				JTextField tempPrice = (JTextField) this.appUIset.getbtnPanel(2).getComponent(2);
				JTextField tempManu = (JTextField) this.appUIset.getbtnPanel(2).getComponent(3);
				
				// 해당하는 정보 기반으로 Produt 만들고 질의 던지기
				ProductDTO p = new ProductDTO();
				p.setPrcode(findPrcode); // 찾은 Product의 prcode ( where 조건 )
				p.setPrname(tempPname.getText());
				p.setPrice(Integer.parseInt(tempPrice.getText()));
				p.setManufacture(tempManu.getText());
				
				this.productDAO.updateProduct(p);
				this.appUIset.setLabel("##메시지 : "+findPrcode+"의 상품을 수정했습니다.");
				this.IsCanRevise = false; // 수정 불가능으로 바꾸고
				this.appMain.refreshData(); // refresh 
			}
			else {
				JTextField tempPname = (JTextField) this.appUIset.getbtnPanel(2).getComponent(1);
				JTextField tempPrice = (JTextField) this.appUIset.getbtnPanel(2).getComponent(2);
				JTextField tempManu = (JTextField) this.appUIset.getbtnPanel(2).getComponent(3);
				
				ProductDTO p = new ProductDTO();
				p.setPrname(tempPname.getText());
				p.setPrice(Integer.parseInt(tempPrice.getText()));
				p.setManufacture(tempManu.getText());
				
				System.out.println(this.productDAO.newProduct(p)); // p를 등록하고
				this.appMain.refreshData(); // refresh 하고
				this.actionInquiry(); // 다시 재조회를 시킨다.
			} // inner if - else (수정 가능 vs 불가능)
		} // if
		
		// 조회 버튼 액션
		if(e.getSource() == this.jbtn[1]) {
			// 조회 메소드 함수화함
			this.actionInquiry();
		} // if
		
		// 삭제 버튼 액션
		if(e.getSource() == this.jbtn[2]) {
			int findPrcode = Integer.parseInt((String) this.appUIset.getComboBox().getSelectedItem());
			int result = JOptionPane.showConfirmDialog(this.appMain, "진짜"+findPrcode+"번을 삭제하시겠습니까?", "Confirm", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {
				System.out.print(this.productDAO.delProduct(findPrcode));
				this.appUIset.getComboBox().setSelectedItem("전체");
				this.appMain.refreshData();
				this.actionInquiry(); // 삭제 후에도 없어진애 빼고 재검색 실시
			} // inner 'yes' if
		} // if
		
	} // actionPerformed()
	
	private void actionInquiry() {
		
		if((String) this.appUIset.getComboBox().getSelectedItem() == "전체") {
			// gettig All recode
			this.appMain.refreshData();
			this.firstAllProduct = productDAO.getAll();
			
			for(int i = 0; i < this.firstAllProduct.size(); i++) {
				String tempPrcode = String.valueOf(this.firstAllProduct.get(i).getPrcode());
				String tempPrname =this.firstAllProduct.get(i).getPrname();
				String tempPrice = String.valueOf(this.firstAllProduct.get(i).getPrice());
				String tempManu = this.firstAllProduct.get(i).getManufacture();
				this.appUIset.getTextArea().append(tempPrcode+"\t"+tempPrname+"\t"+tempPrice+"\t"+tempManu+"\n");
				this.appUIset.setLabel("##메시지 : 총 "+firstAllProduct.size()+"개 상품을 조회했습니다.");
			} // for
			this.IsCanRevise = false;
		} // if
		else {
			this.appMain.clearField();
			this.appUIset.getTextArea().setText("관리번호\t상품명\t단가\t제조사\n");
			int findPrcode = Integer.parseInt((String) this.appUIset.getComboBox().getSelectedItem());
			
			// Getting Product from DB! 'key is prcode!' (in combo box)
			ProductDTO Ptemp = this.productDAO.getProduct(findPrcode);
			String tempPrcode = String.valueOf(Ptemp.getPrcode());
			String tempPrname =Ptemp.getPrname();
			String tempPrice = String.valueOf(Ptemp.getPrice());
			String tempManu = Ptemp.getManufacture();
			
			// text Setting
			this.appUIset.getTextArea().append(tempPrcode+"\t"+tempPrname+"\t"+tempPrice+"\t"+tempManu+"\n");
			this.appUIset.setLabel("##메시지 : "+tempPrcode+"번 상품, "+tempPrname+"을 조회했습니다.");
			this.IsCanRevise = true; // 수정 가능한 상태라고 표시
			
			((JTextField) this.appUIset.getbtnPanel(2).getComponent(1)).setText(tempPrname);
			((JTextField) this.appUIset.getbtnPanel(2).getComponent(2)).setText(tempPrice);
			((JTextField) this.appUIset.getbtnPanel(2).getComponent(3)).setText(tempManu);
			
		} // if - else
	}

} // AppBtnEvent Class
