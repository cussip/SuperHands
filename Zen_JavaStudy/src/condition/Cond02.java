package condition;

public class Cond02 {

	public static void main(String[] args) {
		// 조건문
		int visitCount = 0;
		
		if(visitCount < 1) {
			System.out.println("처음 방문하셨군요.");
		} else {
			System.out.println("다시 방문해주셔서 감사합니다.");
		}

		if(visitCount < 1) 
			System.out.println("처음 방문하셨군요.");
		else 
			System.out.println("다시 방문해주셔서 감사합니다.");
		

	}

}
