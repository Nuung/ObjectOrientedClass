package networking.tcpip;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpIpClient extends Thread{

	private String socketip = "127.0.0.1";
	private int socketport = 3001;
	
	private void RunningClient() {
		try {
			Thread.sleep(1000);
			
			Socket s = new Socket(this.socketip, this.socketport);
			System.out.println("## Working the Client...");
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			pw.println("[ Hello? ] From the Client...!");
			pw.close();
			System.out.println("## Client's Channel : "+s.getChannel());
			s.close();
			System.out.println("## End of the Client...");
		} catch(Exception e) {
			e.printStackTrace();
		} // try - catch
	}
	
	@Override
	public void run() {
		this.RunningClient();
	} // run()
	
}
