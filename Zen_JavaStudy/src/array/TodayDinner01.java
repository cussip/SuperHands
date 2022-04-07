package array;

public class TodayDinner01 {

	public static void main(String[] args) {
		// 컴퓨터가 추천하는 저녁 메뉴
		String[] menu = {
			"김치찌게", "볶음밥", "짜장면", "동태탕", "회덮밥",
			"부대찌게", "설렁탕", "돈까스", "대구탕", "라면"
		};
		
		int num = 0;
		/*
		for(int i = 0; i < 100; i++) {
			num = (int)(Math.random() * menu.length);
			System.out.println(menu[num]);
		}
		 */
		num = (int)(Math.random() * menu.length);

		// 저녁식사 메뉴를 랜덤하게 추천하자!
		System.out.println("오늘의 추천 저녁식사는 " + menu[num] + "입니다.");
		
		System.out.println("오늘의 추천 저녁식사는 " + menu[(int)(Math.random() * menu.length)] + "입니다.");
	}

}
