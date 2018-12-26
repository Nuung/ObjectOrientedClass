package 객체지향설계_예제.event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuKeyAction implements KeyListener {

	private boolean[] keyDown = new boolean[4];
	
	@Override
	public void keyPressed(KeyEvent keyevent) {
		
		int key = keyevent.getKeyCode();
		if(key == KeyEvent.VK_S && key == KeyEvent.VK_CONTROL) {
			keyDown[0] = true; keyDown[1] = true;
		} // if
		
	}

	@Override
	public void keyReleased(KeyEvent keyevent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent keyevent) {
		// TODO Auto-generated method stub
		
	}

}
