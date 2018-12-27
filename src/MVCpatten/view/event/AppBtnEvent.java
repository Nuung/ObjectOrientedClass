package MVCpatten.view.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;


public class AppBtnEvent implements ActionListener {

	private JButton[] jbtn = new JButton[3];
	
	public AppBtnEvent(JPanel btnPanel) {
		System.out.print(btnPanel.getComponentCount());
		for(int i = 0; i < jbtn.length; i++) {
			this.jbtn[i] = (JButton) btnPanel.getComponent(i);
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
			System.out.print(this.jbtn[1].getText());
		} // if
		
		// 삭제 버튼 액션
		if(e.getSource() == this.jbtn[2]) {
			System.out.print(this.jbtn[2].getText());
		} // if
		
	} // actionPerformed()

} // AppBtnEvent Class
