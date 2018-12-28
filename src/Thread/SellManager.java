package Thread;

public class SellManager {

	private int total;
	
	public SellManager(int total) {
		this.total = total;
	}
	
	// '동기화 된 변수'
	synchronized int sell() {
		total--;
		// total을 -- 하고 5초 동안 잠
		try {
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		} // try - catch
		return total;
	} // sell()
	
}