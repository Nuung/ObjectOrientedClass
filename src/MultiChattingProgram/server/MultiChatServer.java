package MultiChattingProgram.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.google.gson.Gson;

import MultiChattingProgram.model.Message;

public class MultiChatServer {

	// Server Socket and Client's connection Socket
	private ServerSocket ss = null;
	private Socket s = null;
	
	// ArrayList for managing Thread that connected Clients 
	ArrayList<ChatThread> chatThreads = new ArrayList<ChatThread>();
	
	// Object for Logger
	Logger logger;
	
	public static void main(String[] args) {
//		start();
	}
	
	// Start the Server
	public void start() {
		logger = Logger.getLogger(this.getClass().getName());
		
		try {
			// make server socket
			ss = new ServerSocket(8888);
			logger.info("MultiChatServer start");
			
			// waiting the connection with infinte loop
			while(true) {
				s = ss.accept();
				ChatThread chat = new ChatThread(); 
				chatThreads.add(chat); // add list that clients
				chat.start(); // thread start
			} // while
		} catch (Exception e) {
			logger.info("[MultiChatServer]Start() Exception 발생!!!!");
			e.printStackTrace();
		} // try -catch
	} // start()
	
	public void msgSendAll(String msg) {
		
	}
	
	class ChatThread extends Thread {
		// for recived msg
		String msg;
		Message m = new Message();
		Gson gson = new Gson(); // for JSON parser;
		private boolean status = true;
		
		// In out Stream
		private BufferedReader inMsg = null;
		private PrintWriter outMsg = null;
		
		@Override
		public void run() {
			// 상태정보가 true이면 루프를 돌면서 사용자에게서 수신된 메시지 처리
			while(status) {
				try {
					msg = inMsg.readLine(); // 수신된 메시지를 저장 하고
				} catch (IOException e) {
					e.printStackTrace();
				} // try - catch
				
				m = gson.fromJson(msg, Message.class); // 저장된 메시지를 Json -> 에서 -> Message object로 맵핑
		
				if(m.getType().equals("logout")) { //수신한 메시지가 Logout 일때
					chatThreads.remove(this);
					msgSendAll(gson.toJson(new Message(m.getId(), "", "님이 종료했습니다.", "server")));
					// 해당 클라이언트 스레드 종료로 status를 false로 설정
					this.status = false;
				} // if
				else if(m.getType().equals("login")) { //수신한 메시지가 LogIn 일때
					
				}
				
			} // while
		} // run()
		
		
	}
	
}
