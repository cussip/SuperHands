package Backjoon_OJ.Gold3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//모든 주석은 설명하려는 코드의 상단에 작성한다.
public class No16236 {
	
	static int bs_size = 2;
	static int bs_eat = 0;
	static int arrN[][];
	static int arrT[][];
	static int N;
	static final int[] moveX = { -1, 1, 0, 0 };
	static final int[] moveY = { 0, 0, -1, 1 };
	

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());		
		
		//2차원 배열 생성
		arrN = new int[N][N];
		
		//물고기의 객체럴 저장할 큐 생성
		Queue<Fish> que = new LinkedList<>();
		
		for(int y = 0; y < N; y++) {	
			st = new StringTokenizer(br.readLine());
			for(int x = 0; x < N; x++) {
				arrN[x][y] = Integer.parseInt(st.nextToken());
				
				//9가 나오면 상어의 위치이다. 상어 객체를 생성한다. 이때 9가 아닌 초기 덩치 2를 사용한다.
				if(arrN[x][y] == 9) {
					Fish bs = new Fish(x, y, bs_size);
					
				// 0 < 숫자 < 9 일경우 먹이이미로 먹이 정보를 객체화하여 que에 삽입한다.
				} else if(arrN[x][y] > 0 && arrN[x][y] < 9) {
					Fish feed = new Fish(x, y, arrN[x][y]);
					que.add(feed);
				}
				
			}//End - for(int x)
		}//End - for(int y)
		
		while(true) {
			
			//큐에서 먹이를 하나 꺼댄다
			
			//먹이와 만날 때까지 탐색한다
			
			//먹이를 만나면 먹이까지 걸린 시간을 확인한다.
			
			//
			
			
			
		}
		
	}
}

class Fish {
	
	static int x;
	static int y;
	static int size;

	public Fish(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
}







