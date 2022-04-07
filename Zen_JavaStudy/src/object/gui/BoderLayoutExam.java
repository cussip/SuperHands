package object.gui;

import java.awt.*;
import javax.swing.*;

public class BoderLayoutExam extends JFrame {
	BoderLayoutExam() {
		setTitle("Border Layout");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		
		//contentPane.setLayout(new BorderLayout());
		contentPane.setLayout(new BorderLayout(10, 20));
		
		contentPane.add(new JButton("CENTER"), BorderLayout.CENTER);
		contentPane.add(new JButton("EAST"), BorderLayout.EAST);
		contentPane.add(new JButton("WEST"), BorderLayout.WEST);
		contentPane.add(new JButton("SOUTH"), BorderLayout.SOUTH);
		contentPane.add(new JButton("NORTH"), BorderLayout.NORTH);
		
		setSize(400, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BoderLayoutExam();
	}

}
