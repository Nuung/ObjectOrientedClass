package MultiChattingProgram.viewer;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiChatUI extends JFrame implements Runnable {

	// Login Panel
	private JPanel loginPanel;
	// Login Button
	protected JButton loginButton;
	
	// Label for Ncikname 
	private JLabel inLabel;
	// Label for output Nickname
	protected JLabel outLabel;
	// Textfiel for input Nickname
	protected JTextField idInput;
	
	// Logout Panel
	private JPanel logoutPanel;
	// Logout Button
	protected JButton logoutButton;
	
	// Message input Panel
	private JPanel msgPanel;
	// Message input Textfield / OutPut Area
	protected JTextField msgInput;
	protected JTextArea msgOut;
	private JScrollPane jsp; // Scroll Bar for Output
	// Exit button
	protected JButton exitButton;
	
	// LayOut for View Changer
	protected Container tab;
	protected CardLayout cardLayout;
	
	// constructer
	public MultiChatUI() {
		
		// main Frame Setting
		super(":: MULTI CHAT ::");
		
		// login panel
		loginPanel = new JPanel();
		loginPanel.setLayout(new BorderLayout());
		idInput = new JTextField(15);
		loginButton = new JButton("LOG IN");
		inLabel = new JLabel("NickName ");
		loginPanel.add(inLabel, BorderLayout.WEST);
		loginPanel.add(idInput, BorderLayout.CENTER);
		loginPanel.add(loginButton, BorderLayout.EAST);
		
		// logout panel
		logoutPanel = new JPanel();
		logoutPanel.setLayout(new BorderLayout());
		outLabel = new JLabel();
		logoutButton = new JButton("LOG OUT");
		logoutPanel.add(outLabel, BorderLayout.CENTER);
		logoutPanel.add(logoutButton, BorderLayout.EAST);
		
		// login or logout Select Panel
		tab = new JPanel();
		cardLayout = new CardLayout();
		tab.setLayout(cardLayout);
		tab.add(loginPanel, "login");
		tab.add(logoutPanel, "logout");
		cardLayout.show(tab, "login");
		
		// Message input Panel
		msgPanel = new JPanel();
		msgPanel.setLayout(new BorderLayout());
		msgInput = new JTextField();
		exitButton = new JButton("EXIT");
		msgPanel.add(msgInput, BorderLayout.CENTER);
		msgPanel.add(exitButton, BorderLayout.EAST);
		
		// Message Output Panel
		msgOut = new JTextArea("", 10, 30);
		msgOut.setEditable(false); // cant edit the contents
		
		// Scroll Bar for Output
		jsp = new JScrollPane(msgOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
		
		// Default Setting for Super (JFrame, adding all Elements)
		this.mainFrameSetting();
	}

	private void mainFrameSetting() {
		// main Frame Setting
		this.setSize(550, 300);
		this.setLayout(new BorderLayout());
		this.add(this.tab, BorderLayout.NORTH); // tab -> cardLayout -> button evetn [ change Show 'login' 'logout' ]
		this.add(this.jsp, BorderLayout.CENTER);
		this.add(this.msgPanel, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	public void addButtonActionListener(ActionListener listener) {
		// Add action Event
		this.loginButton.addActionListener(listener);
		this.logoutButton.addActionListener(listener);
		this.exitButton.addActionListener(listener);
		this.msgInput.addActionListener(listener);
	} // addButtonActionListener()
	
	@Override
	public void run() {
		
	} // run()
	
}
