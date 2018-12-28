package Thread;

public class ThreadMain extends Thread {

	public int total;
	private SellManager sm;
	
	public ThreadMain() {
		total = 100;
		sm = new SellManager(this.total);
	}
	
	@Override
	public void run() {
		String tname = Thread.currentThread().getName();
		
		for (int i = 0; i < 3; i++) {
			// this Thread의 Wrok는 '3번의 판매' -> '동기식' sell 함수 호출
			System.out.println(tname + "─판매: " +  sm.sell());
		} // for
		System.out.println(tname + " 종료");
	} // run()
	
	public static void main(String[] args) {
		System.out.println("## 티켓 예매 프로그램 ##");
		
		// 새로운 this 쓰레드 생성 / ps) this 도 지금 Thread인 상태임을 명시
		ThreadMain app = new ThreadMain();
		
		// for문으로 mt를 최대 10개까지 생성
		for (int i = 0; i < 10; i++) {
			Thread mt = new Thread(app);
			mt.start(); // run() method 호출
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			} // try - catch
		} // for
		
		System.out.println("Main 종료!!");
	} // main thread
	
}
