package object.gui.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//-----------------------------------------------------------------------------------------------------------
// public class MiniCalculator extends JFrame implements ActionListener
//-----------------------------------------------------------------------------------------------------------
public class MiniCalculator extends JFrame implements ActionListener {

	//-----------------------------------------------------------------------------------------------------------
	// 변수 선언
	//-----------------------------------------------------------------------------------------------------------
	private	JPanel		panel;
	private	JTextField	tField;		// 액정
	private	JButton[]	buttons;	// 버튼들을 가리키는 참조변수
	// 버튼 위에 쓰여질 기호와 숫자들
	private	String[]	labels = {	"7", "8", "9", "+",
									"4", "5", "6", "-",
									"1", "2", "3", "*",
									"0", "C", "=", "/"	};
			
	// actionPerformed에서 사용할 변수들을 선언한다.
	private	String		tempName;			// 버튼 이름 불러오기
	private	String		tempString;			// tField(액정)에 적힌 텍스트를 받아올 때 사용한다.
	private	int			tempNum1	= 0;	// 첫번째 숫자
	private	String		tempNum2	= "";	// 두번째 숫자
	private	boolean		is_ready	= false;// 사칙연산 중 앞의 숫자와 뒤의 숫자를 구분하기 위해서 사용한다.
	private	String		who			= "";	// 사칙연산자 중 어떤 연산자가 사용이 되었는지 저장하기 위해 사용한다.
	
	//-----------------------------------------------------------------------------------------------------------
	// actionPerformed에서 사용하는 변수들을 한번에 초기화하는 메서드
	//-----------------------------------------------------------------------------------------------------------
	protected void calculateInit() {
		tempName	= "";
		tempString	= "";
		tempNum1	= 0;
		tempNum2	= "";
		is_ready	= false;
		who			= "";
	} // End - protected void calculateInit()
	
	//-----------------------------------------------------------------------------------------------------------
	// 생성자
	//-----------------------------------------------------------------------------------------------------------
	public MiniCalculator() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("계산기");
		
		tField	= new JTextField(12);
		panel	= new JPanel();	// 버튼 들이 올라갈 판넬
		
		tField.setFont(new Font("Arial", Font.ITALIC+Font.BOLD, 32));
		tField.setText("0");		// 처음에는 액정에 0을 보여준다.
		tField.setEnabled(false);	// 액정에 글자를 직접 쓰지 못하게 한다.
		
		panel.setLayout(new GridLayout(4, 4, 2, 2)); // row, col, hgap, vgap
		buttons = new JButton[16];	// 숫자 10개와 연산자 6

		
		int index = 0;
		// 16개의 버튼을 만든다.
		for(int rows = 0; rows < 4; rows++) {
			for(int cols = 0; cols < 4; cols++) {
				// 배열의 번호(index)를 rows와 cols를 이용해서 사용하려면 상단에 기술한다.
				// 또는 index를 증가시켜서 사용하려면 작업이 끝나는 하단에 기술하면된다.
				index = rows * 4 + cols;
				
				buttons[index]= new JButton(labels[index]); // 버튼을 만들면서 버튼 위에 글자를 쓴다.
				buttons[index].setFont(new Font("Arial", Font.BOLD, 30));
				buttons[index].addActionListener(this);	// 버튼마다 액션리스너를 설정한다.
				
				if(cols >= 3)
					buttons[index].setForeground(Color.red); // 사칙연산 기호만 빨간색으로 만든다.
				else
					buttons[index].setForeground(Color.blue);
				
				buttons[index].setBackground(Color.yellow);
				
				
				panel.add(buttons[index]);	// 만든 버튼을 판넬에 올린다.
				// index++;
			}
		} // 끝 - 버튼 만들기
		
		add(tField, BorderLayout.NORTH);
		add(panel,  BorderLayout.CENTER);
		
		this.setSize(400, 300);	// 프레임의 크기
		setLocation(500, 200);	// 프레임이 나타나는 위치
		setResizable(false);	// 프레임의 크기를 변경하지 못하게 하려면 false를 사용한다.
		setVisible(true);		// 프레임을 화면에 나타나게 한다.
		
		
	} // End - public MiniCalculator()
	
	//-----------------------------------------------------------------------------------------------------------
	// 문자열이 숫자로 사용이 될 수 있는지 판단
	//-----------------------------------------------------------------------------------------------------------
	public static boolean isNumber(String str) {
		try {
			double d = Double.parseDouble(str);	
		} catch(NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 계산하는 부분 : 숫자2개와 연산자를 받아서 계산한 값을 돌려준다.
	//-----------------------------------------------------------------------------------------------------------
	protected int Calculate(int num1, int num2, String sign) {
		// 연산부호에 따라 계산한 결과를 돌려준다.
		switch(sign) {
			case "+":	return	num1 + num2;
			case "-":	return	num1 - num2;
			case "*":	return	num1 * num2;
			case "/":	return	num1 / num2;
			default:
				return -1;
		}
		
	} // End - protected int Calculate(int num1, int num2, String sign)
	
	//-----------------------------------------------------------------------------------------------------------
	// public void actionPerformed(ActionEvent e)
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			// 버튼의 이름을 가져온다.
			tempName	= e.getActionCommand();
			System.out.println("tempName : " + tempName);
			
			// 화면 지우기 버튼을 눌렀을 경우
			if(tempName.equals("C")) {
				tField.setText("");	// 액정에 있는 글자들을 모두 지우고,
				// 메소드를 그대로 종료시킨다.
				// 메소드가 void형이라도 return을 사용할 수 있다.
				// (단, 리턴에 값이 있으면 안되고, 메소드 종료용도로 사용한다.)
				return;
			}
			
			tempString	= tField.getText(); // 지금까지 액정(tField)에 적힌 텍스트를 가져온다.
			
			// 버튼을 눌렀을 경우 텍스트필드에 0뿐이라면 그 0을 지워버린다.
			// 않그러면 0 + 5 => 05 이런 형태가 되기 때문에
			if(tempString.equals("0"))
				tempString = "";
			
			// 첫번째 숫자가 있고, 사칙연산버튼을 눌렀을 경우
			if((tempName.equals("+") || tempName.equals("-") || tempName.equals("*") || tempName.equals("/")) && !is_ready) {
				// 사칙연산에 사용될 버튼 들이면서 is_ready라는 boolean값이 false인 경우
				// tField에 있는 숫자들을 모두 가져와서 tempNum1에 저장한다.
				tempNum1	= Integer.parseInt(tempString);
				// System.out.println("첫번째 숫자 : " + tempNum1);
				is_ready = true;	// 연산기호가 눌려졌으므로 is_ready값을 true로 한다.
				// is_ready를 사용하는 목적은 사칙연산 중 앞의 숫자와 뒤의 숫자를 구분하기 위해서
				// 50 + 30
				
				// who는 사칙연산자 중에서 누른 버튼에 대한 것(+,-,*,/)를 가지고 있다.
				who	= tempName;
				
				// tField에 지금까지 누른 내용과 방금 누른 버튼을 보여준다.
				tField.setText(tempString + tempName);
			} else if(tempName.equals("=") && is_ready && !tempNum2.equals("") ) {
				// = 버튼을 눌렀고 is_ready가 true이며 tempNum2가 공백이 아닐 경우
				// 숫자1, 숫자2가 있고, 연산자가 눌린 상태에서 = 을 누른경우
				int temp = Integer.parseInt(tempNum2);
				
				// 2개의 숫자를 연산한 결과를 문자열로 바꾸어서 액정에 보여준다.
				tField.setText(Integer.toString(Calculate(tempNum1, temp, who)));
				
				calculateInit();
			} else if(tempName.equals("=") && (!is_ready || tempNum2.equals(""))) {
				// = 버튼은 눌렀으나
				// 연산버튼이 눌려지지 않은 상태(!is_ready) 또는 tempNum2(오른쪽 피연산)가 공백인 경우는
				// 아무 것도 하지 않는다.
			} else {
				// (원래있던 내용) + (방금 누른 내용)
				tField.setText(tempString + tempName); 
			}
			
			if(is_ready && isNumber(tempName)) {
				// is_ready가 true이면서 (연산자가 준비가 되어있으며)
				// 방금 누른 버튼이 숫자일 경우
				tempNum2 += tempName;
				// String타입 tempNum2에 방금 누른 버튼을 이어 붙인다.
				// tempNum2가 int 타입이 아니고, String 타입인 이유이기도 하다.
				// int 일 경우 다른 값이 대입이 되기 때문이다.
				// tempNum의 값이 1이고, tempName이 2인 경우
				// tempNum2 += tempName을 하게되면
				// tempNum2가 3이 된다.(우리가 원하는 것은 12이다.)
			}
			
			
		} catch (Exception ex) {
			tField.setText("");	// 오류가 나면 초기화를 시킨다.
			calculateInit();
		}
		
		
	} // End - public void actionPerformed(ActionEvent e)

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		new MiniCalculator();
	} // End - public static void main(String[] args)

} // End - public class MiniCalculator extends JFrame implements ActionListener








