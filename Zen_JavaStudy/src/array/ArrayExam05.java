package array;

import javax.swing.JOptionPane;

public class ArrayExam05 {

	public static void main(String[] args) {
		// arr 배열 안의 변경하고 싶은 인덱스 번호를 입력받고,
		// 바꿀 값을 입력받아서 해당하는 방의 값을 변경하고 모든 방의 값을 출력해주세요.

		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

		// int index = Integer.parseInt(JOptionPane.showInputDialog("바꾸고 싶은 배열의 인덱스 번호를 입력하세요"));
		int index = Integer.parseInt(JOptionPane.showInputDialog("바꾸고 싶은 배열의 인덱스 번호를 입력하세요"));
		int value = Integer.parseInt(JOptionPane.showInputDialog("값을 입력하세요."));
		
		System.out.println("인덱스 : " + index + ",  값 : " + value);
		arr[index] = value;
		
		for(int i = 0; i < arr.length; i++)
			System.out.println(i + "번째 방 : " + arr[i]);
		
	}

}
