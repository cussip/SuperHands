package object.gui;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	MyFrame() {
		setTitle("나의 첫번째 프레임");
		setSize(400, 600);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}

}
