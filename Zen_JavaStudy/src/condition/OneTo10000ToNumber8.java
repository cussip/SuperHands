package condition;

public class OneTo10000ToNumber8 {

	public static void main(String[] args) {
		/*
		 * 1 부터 10000까지의 정수에는 8이라는 숫자가 총 몇 번나오는가요?
		 * 18, 88, 8088
		 * 답 : 4000개
		 */
		int	count	= 0;	// 8이라는 숫자의 누적 카운트
		int	wonbon	= 0;	// 검사대상이 되는 i를 임시로 저장하는 변수
		
		for(int i = 1; i <= 10000; i++) {
			wonbon = i;
			while(i >= 10) {
				if(i % 10 == 8) {
					count++;
					//i /= 10;
				//} else {
					//i /= 10;
				}
				i /= 10;
			}
			
			if(i == 8) { // 10밑에는 8이 나오는 숫자가 8 하나밖에 없다.
				count++;
			}
			i = wonbon;
		}
		
		System.out.println("1 ~ 10000까지 8이 나오는 횟수 : " + count);

		//-------------------------------------------------------------
		count = 0;
		for(int num = 1; num <= 10000; num++) {
			for(int y = num; y > 0; y /= 10) {// y != 0; // y = y / 10 (10으로 나눈 몫)
				if(y % 10 == 8) {
					count++;
				}
			}
			
		}
		
		System.out.println("1 ~ 10000까지 8이 나오는 횟수 : " + count);
		
		
	}

}













