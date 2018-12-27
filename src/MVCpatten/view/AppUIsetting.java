package MVCpatten.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AppUIsetting {

	private AppMain mainFrame; // 메인 프레임
	private JLabel ml; // 메세지 출력부
	private JPanel p1, p2, p3; // 라벨, 입력양식, 버튼 메뉴부
	
	// p2에 속하는 '입력양식' 선택 콤보박스 - 생성후, refreshData 메서드를 충해서 Data (item 값을 통해) 채운다
	private JComboBox cb;
	private Vector<String> items;
	
	private JTextArea textArea; // 전체 목록 출력부
	private JScrollPane scrollP; // 전체 목록 출력부의 Scroll 세팅을 위하여
	
	public AppUIsetting(AppMain mainFrame, Vector<String> items) {
		this.mainFrame = mainFrame;
		this.items = items;
		this.initAllUI();
	}
	
	// ---------------- private Setting ---------------- //
	
	private void initAllUI() {
		this.mainFrame.setLayout(new BorderLayout()); // 수평 및 수직 간격이 10으로 설정되는 것 -> Border.North .. etc를 사용
		this.setLabel();
		this.mainFrame.add(ml, BorderLayout.PAGE_START);
		this.setPanel();
		this.mainFrame.add(p1, BorderLayout.LINE_START);
		this.mainFrame.add(p2, BorderLayout.CENTER);
		this.setTextScroll();
		this.mainFrame.add(scrollP, BorderLayout.LINE_END);
		this.mainFrame.add(p3, BorderLayout.PAGE_END);
	}
	
	private void setPanel() {
		// p1 은 4개의 Label
		this.p1 = new JPanel();
		this.p1.setLayout(new GridLayout(4, 1, 5, 5)); // 생성자로써 ( 행, 열, 수평간격, 수직간격 ) 의 형태로 바툭판 레이아웃이라 생각하자
		JLabel jLtemp = new JLabel("관리번호");
		p1.add(jLtemp);
		jLtemp = new JLabel("상품명");
		p1.add(jLtemp);
		jLtemp = new JLabel("단가");
		p1.add(jLtemp);
		jLtemp = new JLabel("제조사");
		p1.add(jLtemp);
		
		// p2 는 콤보박스와 3개의 텍스트 필드
		this.p2 = new JPanel();
		this.setCombo(this.items);
		p2.add(this.cb);
		for(int i = 0; i < 3; i++) {
			JTextField jTtemp = new JTextField();
			p2.add(jTtemp);
		}
		this.p2.setLayout(new GridLayout(4, 1, 5, 5)); // 생성자로써 ( 행, 열, 수평간격, 수직간격 ) 의 형태로 바툭판 레이아웃이라 생각하자

		// p3 는 3개의 등록, 조회 삭제 버튼
		this.p3 = new JPanel();
		JButton jBtntemp = new JButton("등록");
		p3.add(jBtntemp);
		jBtntemp = new JButton("조회");
		p3.add(jBtntemp);
		jBtntemp = new JButton("삭제");
		p3.add(jBtntemp);
	}
	
	private void setTextScroll() {
		this.textArea = new JTextArea();
		this.textArea.setText("관리번호\t상품평\t단가\t제조사");
		this.scrollP = new JScrollPane(this.textArea);
		this.scrollP.setPreferredSize(new Dimension(400, 50));
	}
	
	private void setLabel() {
		this.ml = new JLabel("메시지출력부");
	}
	
	public void setCombo(Vector<String> items) {
		this.items = items;
		this.cb = new JComboBox<String>(this.items);
	}
	
	// ---------------- Getter And Setter Setting ---------------- //
	public JPanel getbtnPanel(int input) {
		if(input == 1) {
			return p1;
		}
		else if(input == 2) {
			return p2;
		}
		else {
			return p3;
		}
	}
	
	public JTextArea getTextArea() {
		return this.textArea;
	}
	
	public JComboBox getComboBox() {
		return this.cb;
	}
	
}
