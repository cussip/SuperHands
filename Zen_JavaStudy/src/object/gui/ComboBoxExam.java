package object.gui;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ComboBoxExam extends JFrame {
	String[]	fruits	= {"apple", "banana", "mango"};
	ImageIcon[] images = {
			new ImageIcon("C:\\Tool\\workspace\\JavaStudy\\src\\images\\apple.jpg"),
			new ImageIcon("C:\\Tool\\workspace\\JavaStudy\\src\\images\\banana.jpg"),
			new ImageIcon("C:\\Tool\\workspace\\JavaStudy\\src\\images\\mango.jpg")
	};
	JLabel imgLabel = new JLabel(images[0]);
	
	
	ComboBoxExam() {
		setTitle("콤보박스 연습하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JComboBox combo = new JComboBox(fruits);
		c.add(combo);	c.add(imgLabel);
		
		// 콤보박스에 Action Listener을 등록하여, 선택한 아이템의 이미지를 보여준다.
		combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JComboBox 	cb	 	= (JComboBox)e.getSource();
				int			index	= cb.getSelectedIndex();	// 선택한 콤보박스의 인덱스번호를 가져온다.
				imgLabel.setIcon(images[index]);
			}
			
		});
		
		setSize(400, 300);
		setLocation(500, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ComboBoxExam();
	}

}
