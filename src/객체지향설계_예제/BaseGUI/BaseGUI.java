package 객체지향설계_예제.BaseGUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BaseGUI extends JFrame{

	private final int WIDTH = 512, HEIGHT = 512;
	private JTextArea mainTextArea;
	
	public BaseGUI() {
		new MenuSet(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("GUI test");
		this.setBackground(Color.WHITE);
		
		this.add(mainTextArea = new JTextArea());
		// below this line, we can make any componets 
		
//		this.setLayout(new FlowLayout()); // 기본적으로 Frame은 플로우레이아웃을 사용한다 (디폴드 값)
//		this.setLayout(new BorderLayout(10, 10)); // 수평 및 수직 간격이 10으로 설정되는 것 -> Border.North .. etc를 사용
//		this.setLayout(new CardLayout()); // (수평간격, 수직간격) -> 카드게임에서 누를때마다 카드가 바뀌는 걸 생각, 버튼의 중첩 사용, 컴포넌트를 겹겹이 겹침
//		ps) null Layout ? -> setBounds(시작X, 시작Y, 폭, 높이) 메서드를 사용해서 절대 위치들을 설정해준다.
//		this.setLayout(new GridLayout(3, 3, 5, 5)); // 생성자로써 ( 행, 열, 수평간격, 수직간격 ) 의 형태로 바툭판 레이아웃이라 생각하자
		
		
//		JButton btnArray[] = new JButton[9];
//		for( int i = 0; i < btnArray.length; i++) {
//			btnArray[i] = new JButton("버튼"+i);
//			this.add(btnArray[i]);
//		} // for
		
		// ──────────── end
		
		this.setSize(512, 512);
		setVisible(true);
	}
	
	public JTextArea getTextArea() {
		return this.mainTextArea;
	}
	
}
