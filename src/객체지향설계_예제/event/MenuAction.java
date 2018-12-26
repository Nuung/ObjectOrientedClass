package 객체지향설계_예제.event;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import 객체지향설계_예제.BaseGUI.BaseGUI;

public class MenuAction implements ActionListener {

	private BaseGUI mainFrame;
	private File openedFile; // 바로 저장을 위해
	
	// Action 생성자!
	public MenuAction(BaseGUI mainFrame) {
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// getting btn text value
		Object source =  e.getSource();
        String butSrcTxt = ((AbstractButton) source).getText();
		
        // ----------------------------------------------File events----------------------------------------------- //
        if(butSrcTxt == "새로만들기") {
        	this.mainFrame.dispose();
        	new BaseGUI().getTextArea().setText("");
        	return;
        } // if 새로만들기
        
		if(butSrcTxt == "열기") {
			JFileChooser choosed = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files", "txt");
		    choosed.setFileFilter(filter);
		    
		    // 열기 다이얼로그 출력 부분
		    int returnVal = choosed.showOpenDialog(this.mainFrame);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		       System.out.println("You chose to open this file: " + choosed.getSelectedFile().getName());
				try {
					File f = choosed.getSelectedFile();
					this.openedFile = f; // 바로 저장을 위한 opened File object
					
					FileReader fis = new FileReader(f); 
					int i = 0; 
					mainFrame.getTextArea().setText("");
					
					// Read all Char untill the end
					while((i = fis.read()) != -1) {
						// Read and append to TextArea that char
						mainFrame.getTextArea().append(String.valueOf((char)i));
					} // while
					fis.close();
				} catch(Exception error) {
					System.out.println(error);
				} // try ~ catch
				
		    } // inner if
		    return;
		} // if 열기
		
		if(butSrcTxt == "저장") {
			// 이미 '열기'를 통해서 파일을 열어서 opened File이 존재하는 경우
			if(this.openedFile != null) {
				String str = mainFrame.getTextArea().getText().trim();

				try {
					FileWriter fw = new FileWriter(this.openedFile);
					fw.write(str);
					fw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				} // try - catch
				
			} // inner if
			else { // 열기를 통해서 파일을 열지 않은 경우
				JFileChooser choosed = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files", "txt");
			    choosed.setFileFilter(filter);
			    
			    // 저장 다이얼로그 출력 부분
			    int returnVal = choosed.showOpenDialog(this.mainFrame);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {

					try {
						// text area 의 text trim값을 String으로 저장하고
						String str = mainFrame.getTextArea().getText().trim();
						// 문자열 길이가 1보다 작으면 그냥 바로 exit 
						if(str.length() < 1) return;
						
						// 파일 열고 쓰고 -> 이미 파일 열기로 파일을 불러 왔을때, 또는 존재하지 않을때
						File f = choosed.getSelectedFile();
						FileWriter fw = new FileWriter(f); 
						fw.write(str);
						fw.close();
					} catch(Exception error) {
						System.out.println(error);
					} // try ~ catch
			    } // inner if
			} // if - else
			return;
		} // if 저장
		
		if(butSrcTxt == "열기") {
			JFileChooser choosed = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files", "txt");
		    choosed.setFileFilter(filter);
		    
		    // 열기 다이얼로그 출력 부분
		    int returnVal = choosed.showOpenDialog(this.mainFrame);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		       System.out.println("You chose to open this file: " + choosed.getSelectedFile().getName());
				try {
					File f = choosed.getSelectedFile();
					this.openedFile = f; // 바로 저장을 위한 opened File object
					
					FileReader fis = new FileReader(f); 
					int i = 0; 
					mainFrame.getTextArea().setText("");
					
					// Read all Char untill the end
					while((i = fis.read()) != -1) {
						// Read and append to TextArea that char
						mainFrame.getTextArea().append(String.valueOf((char)i));
					} // while
					fis.close();
				} catch(Exception error) {
					System.out.println(error);
				} // try ~ catch
				
		    } // inner if
		    return;
		} // if 열기
		
		if(butSrcTxt == "다른 이름으로 저장") {

			JFileChooser choosed = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT files", "txt");
		    choosed.setFileFilter(filter);
		    
		    // 저장 다이얼로그 출력 부분
		    int returnVal = choosed.showOpenDialog(this.mainFrame);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {

				try {
					
					// text area 의 text trim값을 String으로 저장하고
					String str = mainFrame.getTextArea().getText().trim();
					// 문자열 길이가 1보다 작으면 그냥 바로 exit 
					if(str.length() < 1) return;

					File f = choosed.getSelectedFile();
					FileWriter fw = new FileWriter(f); 
					fw.write(str);
					fw.close();
					
				} catch(Exception error) {
					System.out.println(error);
				} // try ~ catch
				
		    } // inner if
		    return;
		} // if 다른이름으로 저장
		
		if(butSrcTxt == "끝내기") {
			try {
				this.mainFrame.dispose();
			} catch(Exception error) {
				System.out.println(error);
			} // try ~ catch
			return;
		} // if 끝내기
		
		// ----------------------------------------------text size events----------------------------------------------- //
		if(butSrcTxt == "작게") {
			Font fnt = new Font("arial", 1, 10);
			this.mainFrame.getTextArea().setFont(fnt);
		} // if 끝내기
		
		if(butSrcTxt == "보통") {
			Font fnt = new Font("arial", 1, 12);
			this.mainFrame.getTextArea().setFont(fnt);
		} // if 끝내기
		
		if(butSrcTxt == "크게") {
			Font fnt = new Font("arial", 1, 14);
			this.mainFrame.getTextArea().setFont(fnt);
		} // if 끝내기
		
	} // actionPerformed()

}
