package networking;

import networking.tcpip.TcpIpClient;
import networking.tcpip.TcpIpServer;

public class NetMain {

	public static void main(String args[]) {
//		new Urlhttp();
		TcpIpServer server = new TcpIpServer();
		TcpIpClient client = 	new TcpIpClient();
		
		server.start();
		client.start();
		
	} // main()
	
}
