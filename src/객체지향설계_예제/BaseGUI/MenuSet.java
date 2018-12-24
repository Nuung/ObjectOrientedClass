package 객체지향설계_예제.BaseGUI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuSet {

	private JMenuBar mb;
	private JMenu fileMenu;
	private JMenuItem jitem;
	
	public MenuSet(JFrame frame) {
		mb = new JMenuBar();
		this.mb = createMenu();
		
		frame.setJMenuBar(this.mb);
	}
	
	private JMenuBar createMenu() {
		
		// '파일' 메뉴
		fileMenu = new JMenu("파일");
		jitem = new JMenuItem("새로만들기");
		fileMenu.add(jitem);
		jitem = new JMenuItem("열기");
		fileMenu.add(jitem);
		jitem = new JMenuItem("저장");
		fileMenu.add(jitem);
		jitem = new JMenuItem("다른 이름으로 저장");
		fileMenu.add(jitem);
		jitem = new JMenuItem("끝내기");
		fileMenu.add(jitem);
		mb.add(fileMenu);

		// '보기' 메뉴
		fileMenu = new JMenu("보기");
		jitem = new JMenuItem("작게");
		fileMenu.add(jitem);
		jitem = new JMenuItem("보통");
		fileMenu.add(jitem);
		jitem = new JMenuItem("크게");
		fileMenu.add(jitem);
		mb.add(fileMenu);
		
		// '도움말' 메뉴
		fileMenu = new JMenu("도움말");
		jitem = new JMenuItem("프로그램정보");
		fileMenu.add(jitem);
		mb.add(fileMenu);
		
		return mb;
	}
	
}
