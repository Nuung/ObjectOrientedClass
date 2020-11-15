package 객체지향설계_예제.BaseGUI;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import 객체지향설계_예제.event.MenuAction;

public class MenuSet {

	private BaseGUI mainFrame;
	private JMenuBar mb;
	private JMenu fileMenu;
	private JMenuItem jitem;
	
	public MenuSet(BaseGUI frame) {
		this.mainFrame = frame;
		mb = new JMenuBar();
		this.mb = createMenu();
		mainFrame.setJMenuBar(this.mb);
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
		eventInit(fileMenu);
		mb.add(fileMenu);

		// '보기' 메뉴
		fileMenu = new JMenu("보기");
		jitem = new JMenuItem("작게");
		fileMenu.add(jitem);
		jitem = new JMenuItem("보통");
		fileMenu.add(jitem);
		jitem = new JMenuItem("크게");
		fileMenu.add(jitem);
		eventInit(fileMenu);
		mb.add(fileMenu);
		
		// '도움말' 메뉴
		fileMenu = new JMenu("도움말");
		jitem = new JMenuItem("프로그램정보");
		fileMenu.add(jitem);
		eventInit(fileMenu);
		mb.add(fileMenu);
		
		return mb;
	}
	
	// 각 메뉴에다 적절하게 이벤트 떄려박기
	private void eventInit(JMenu menu) {
		MenuAction menuAction = new MenuAction(this.mainFrame);
		int menuLen = menu.getItemCount();
		
		for(int i = 0; i < menuLen; i++) {
			menu.getItem(i).addActionListener(menuAction);
		} // for
		
	} // eventInit
	
}
