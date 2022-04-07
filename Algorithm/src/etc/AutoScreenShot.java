package etc;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.*;

public class AutoScreenShot {

	public static void main(String[] args) throws Exception {

		
		Robot robot = new Robot();
		
		robot.mouseMove(40, 20);
	    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		for(int i = 0; i < 190; i++) {
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.delay(2000);
			robot.keyPress(KeyEvent.VK_PRINTSCREEN);
			robot.delay(1000);		
		}
		
	}

}
