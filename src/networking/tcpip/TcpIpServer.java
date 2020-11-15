package networking.tcpip;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer extends Thread {

	// Socket Programming
	private void RunningServer() {
		try {
			ServerSocket sc = new ServerSocket(3001);
			System.out.println("## Working the Server...");
			
			while (true) {
				Socket s = sc.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				
				System.out.println("## Connected to the Client");
				System.out.println("## Client's Message : " + br.readLine());
				br.close();
			} // while
			
		} catch (Exception e) {
			e.printStackTrace();
		} // try - catch
	}
	
	@Override
	public void run() {
		this.RunningServer();
	} // run()
	
}
