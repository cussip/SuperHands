package object.gui.grimpan;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//-----------------------------------------------------------------------------------------------------------
// 메인 창에서 PaintTool 버튼을 누를 때 나오는 화면
//-----------------------------------------------------------------------------------------------------------
public class PaintToolFrame extends JFrame {

	JButton btnPlus, btnMinus, btnClear, btnAllClear, btnClose, btnColor;
	JPanel	p;
	
	//-----------------------------------------------------------------------------------------------------------
	// 생성자
	//-----------------------------------------------------------------------------------------------------------
	public PaintToolFrame() {
		super("그리기 도구");
		Container c = getContentPane();
		
		p = new JPanel();
		c.add(p, "Center");
		
		// p.add(btnPlus = new JButton("크게"));
		btnPlus		= new JButton("크게");
		btnMinus	= new JButton("작게");
		btnClear	= new JButton("지우기");
		btnAllClear	= new JButton("모두지우기");
		btnColor	= new JButton("색상표");
		btnClose	= new JButton("닫기");
		
		p.add(btnPlus);
		p.add(btnMinus);
		p.add(btnClear);
		p.add(btnAllClear);
		p.add(btnColor);
		p.add(btnClose);
		
	} // End - public PaintToolFrame()
	
} // End - public class PaintToolFrame extends JFrame






