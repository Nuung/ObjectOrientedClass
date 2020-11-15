package MultiChattingProgram.model;

public class Message {
	
	private String id; 				// id
	private String passwd; 	// passwoard
	private String msg;			// message for chatting
	private String type;			// shape of the message (login, logout, sendmsg)
	
	public Message() {
		
	}
	
	public Message(String id, String passwd, String msg, String type) {
		this.id = id;
		this.passwd = passwd;
		this.msg = msg;
		this.type = type;
	}

	// ----------------------------------- getter and setter ---------------------------------- //
	
	public  String getType() {
		return this.type;
	}
	
	public String getId() {
		return id;
	}

	public String getPasswd() {
		return passwd;
	}

	public String getMsg() {
		return msg;
	}
	
}
