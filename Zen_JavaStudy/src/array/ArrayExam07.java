package array;

import javax.swing.JOptionPane;

public class ArrayExam07 {

	public static void main(String[] args) {
		// 인덱스 번호 2개를 입력받아, 그 방에 해당하는 값을 서로 바꾼다.
		// 인덱스 번호의 값이 범위(0 이상 9 이하)를 벗어나면, 다시 입력을 받도록 하자!
		// 2개의 인덱스 번호가 정상범위의 값이 되면 방번호에 해당하는 값을 교환하고
		// 전체 방의 값을 출력시키자.

        int[] 	arr 	= { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        System.out.println("변경할 인덱스 번호를 입력하십시오. 범위는 0 이상 9 이하입니다.");
        boolean flag = true; // while문을 벗어나기 위해 사용할 변수
        int choice1 = 0;
        int choice2 = 0;
        
        while(flag) {
	        choice1 = Integer.parseInt(JOptionPane.showInputDialog("첫번째 인덱스 번호를 입력하세요."));
	        if(choice1 < 0 || choice1 > 9) {
	        	System.out.println("인덱스의 범위를 벗어났습니다.\n다시 입력하십시요.");
	        	continue;
	        } else { // 입력한 값의 범위가 정상이면 while문을 벗어나도록 한다.
	        	// break;
	        	flag = false;
	        }
        }
        
        flag = true;
        while(flag) {
	        choice2 = Integer.parseInt(JOptionPane.showInputDialog("두번째 인덱스 번호를 입력하세요."));
	        if(choice2 < 0 || choice2 > 9) {
	        	System.out.println("인덱스의 범위를 벗어났습니다.\n다시 입력하십시요.");
	        	continue;
	        } else { // 입력한 값의 범위가 정상이면 while문을 벗어나도록 한다.
	        	// break;
	        	flag = false;
	        }
        }
        
        // 입력한 두 숫자에 해당하는 방의 값을 교환한다.

		int	temp	= arr[choice1];
		arr[choice1] = arr[choice2];
		arr[choice2] = temp;
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + ", ");
		
		System.out.println();
		
		String msg = "";
		for(int i = 0; i < arr.length; i++)
			msg += arr[i] + ", ";
		
		JOptionPane.showMessageDialog(null, msg);
        
	}

}





















