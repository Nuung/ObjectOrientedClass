package MultiChattingProgram.model;

import javax.swing.JComponent;
import javax.swing.JTextArea;

public class MultiChatData {
	
	private JTextArea msgOut;
	
	public void addObj(JComponent comp) {
		this.msgOut = (JTextArea) comp;
	}
	
	public void refreshData(String msg) {
		this.msgOut.append(msg);
	}
	
}
