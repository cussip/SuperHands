package array;

import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		// 컴퓨터와 하는 가위바위보 게임
		Scanner sc = new Scanner(System.in);
		
		String		player; 	// 사용자
		String		computer;	// 컴퓨터
		int[]		score	= new int[3];	// 0:승, 1:무, 2:패
		String[]	sArr	= {"가위", "바위", "보"};
		boolean		exitFlag	= true;	// while 을 빠져나기기 위해 사용하는 변수
		
		while(exitFlag) {
			System.out.println("가위, 바위, 보 중에 하나를 입력하십시오(종료를 입력하면 게임이 종료됩니다.) : ");
			player = sc.nextLine();
			
			if(!player.equals("가위") && !player.equals("바위") && !player.equals("보")
									  && !player.equals("종료")) {
				continue;
			} else if(player.equals("종료")) {
				exitFlag = false;
				continue;
				// break;
			}
			
			// 컴퓨터가 낸 가위,바위,보
			computer = sArr[(int)(Math.random() * sArr.length)];
			System.out.println(computer);
			
			// 판정
			if(player.equals("가위")) {
				if(computer.equals("가위")) {
					System.out.println("무승부");		score[1] += 1;
				} else if(computer.equals("바위")) {
					System.out.println("컴퓨터 승");	score[2] += 1;
				} else if(computer.equals("보")) {
					System.out.println("사용자 승");	score[0] += 1;
				}
			} else if(player.equals("바위")) {
				if(computer.equals("가위")) {
					System.out.println("사용자 승");	score[0] += 1;
				} else if(computer.equals("바위")) {
					System.out.println("무승부");		score[1] += 1;
				} else if(computer.equals("보")) {
					System.out.println("컴퓨터 승");	score[2] += 1;
				}
			} else if(player.equals("보")) {
				if(computer.equals("가위")) {
					System.out.println("컴퓨터 승");	score[2] += 1;
				} else if(computer.equals("바위")) {
					System.out.println("사용자 승");	score[0] += 1;
				} else if(computer.equals("보")) {
					System.out.println("무승부");		score[1] += 1;
				}
			} else if(player.equals("종료")) {
				exitFlag = false;
				continue;
			} else {
				System.out.println("가위, 바위, 보 중 하나를 입력하셔야 합니다.");
				System.out.println("종료를 입력하면 프로그램이 끝납니다.");
			}
			
			System.out.println("현재 사용자의 전적은 " + score[0] + "승 " + score[1] + "무 " + score[2] + "패");
			System.out.println("현재 컴퓨터의 전적은 " + score[2] + "승 " + score[1] + "무 " + score[0] + "패");
			System.out.println("-----------------------------------------------------------");
			
		} // End - while()
		
		
		
		

	} // End - public static void main(String[] args)

} // End - public class RockPaperScissors
