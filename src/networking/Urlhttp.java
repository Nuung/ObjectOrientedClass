package networking;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Urlhttp {

	public Urlhttp() {
		try {
			URL url = new URL("http://www.naver.com:80/index.html");
			System.out.println("Protocol : "+url.getProtocol());
			System.out.println("Host : "+url.getHost());
			System.out.println("Prot : "+url.getPort());
			System.out.println(">> HTML 시작");
			
			InputStream is = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String msg;
			while((msg = br.readLine()) != null) {
				System.out.println(msg);
			} // while
			
			br.close();
			is.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} // try - catch
	}
	
}
