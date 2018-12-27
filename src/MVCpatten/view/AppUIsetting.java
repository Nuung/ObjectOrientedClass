package MVCpatten.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

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
	private JComboBox cb = new JComboBox(); 
	private JTextArea textArea; // 전체 목록 출력부
	private JScrollPane scrollP; // 전체 목록 출력부의 Scroll 세팅을 위하여
	
	public AppUIsetting(AppMain mainFrame) {
		this.mainFrame = mainFrame;
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
		JLabel jLtemp = new JLabel("관리번호");
		p1.add(jLtemp);
		jLtemp = new JLabel("상품명");
		p1.add(jLtemp);
		jLtemp = new JLabel("단가");
		p1.add(jLtemp);
		jLtemp = new JLabel("제조사");
		p1.add(jLtemp);
		this.p1.setPreferredSize(new Dimension(60, 500));
		
		// p2 는 콤보박스와 3개의 텍스트 필드
		this.p2 = new JPanel();
		p2.add(this.cb);
		for(int i = 0; i < 3; i++) {
			JTextField jTtemp = new JTextField(25);
			p2.add(jTtemp);
		}
		this.p2.setPreferredSize(new Dimension(40, 50));

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
		this.scrollP = new JScrollPane(this.textArea);
		this.scrollP.setPreferredSize(new Dimension(400, 50));
	}
	
	private void setLabel() {
		this.ml = new JLabel("메시지출력부");
	}
	
	// ---------------- Getter And Setter Setting ---------------- //
	public JPanel getbtnPanel() {
		return this.p3;
	}
	
}
