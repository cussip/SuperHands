package Backjoon_OJ.Bronze1;

import java.io.*;
import java.util.ArrayList;

public class No20362 {
	public static void main(String[] args) throws IOException {

		BufferedReader 		br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> list = new ArrayList<>(); 
		
		String	info 		= br.readLine();
		String 	infoArr[] 	= info.split(" ");
		int 	num 		= Integer.parseInt(infoArr[0]);
		String 	callNick	= infoArr[1];
		int		count 		= 0;
				
		for(int i = 0; i < num; i++) {
			list.add(br.readLine());			
		}
		
		for(int i = 0; i < list.size(); i++) {
			int spaceNum01 = list.get(i).indexOf(" ");
			
			String nick = list.get(i).substring(0, spaceNum01);
			String answer = list.get(i).substring(spaceNum01 + 1);
			System.out.println(i + ") nick: " + nick 
								 + " || answer: " + answer);
			
			if(callNick.equals(nick)) {
				for(int j = 0; j < i; j++) {
					int spaceNum02 = list.get(j).indexOf(" ");
					String answer02 = list.get(j).substring(spaceNum02 + 1);
					if(answer.equals(answer02)) {
						count++;
					}
				}
			}
		}
		
		System.out.println(count);	
	}
}

/*
유니대전 퀴즈쇼

- 문제
올해 인천대에서는 코로나19로 인해 온라인 축제를 개최했다. 축제 내용 중에는 퀴즈쇼가 있는데, 
초청 연예인이 채팅을 보고 정답을 맞힌 사람의 닉네임을 읽어 1명에게 상품을 주는 이벤트이다.

축제를 즐기던 철이는 퀴즈쇼가 끝난 뒤 커뮤니티에 당첨자보다 정답을 빨리 쳤다며 아쉬워하는 
사람들이 나타난 것을 보았다. 채팅 기록을 갖고 있는 철이는 그런 아쉬운 사람들이 몇 명이나 
있는지 알고 싶어졌다. 채팅 기록은 여러 줄로 이루어져 있는데, 각 줄에는 채팅을 친 사람의 
닉네임과 채팅 내용이 담겨있다.

채팅 기록과 당첨자가 주어졌을 때 아쉬운 사람의 수를 구해보자. 아쉬운 사람은 당첨자보다 
빨리 정답을 외친 사람이다.

- 입력
첫 번째 줄에 채팅 개수 N과 정답자의 닉네임 S가 공백으로 구분되어 주어진다. (2 ≤ N ≤ 1,000)

두 번째 줄부터 차례로 N개의 채팅 기록이 시간순으로 주어진다. 채팅 기록은 닉네임과 채팅 
내용이 공백으로 구분되어 주어진다. 각 닉네임과 채팅 내용은 길이가 1이상 10이하이며 알파벳 
소문자로만 이루어져 있다.

한 사람이 두 번 이상 채팅을 친 경우는 주어지지 않으며, 정답자의 닉네임 S는 반드시 채팅 
기록에 등장한다.

- 출력
첫 번째 줄에 아쉬운 사람의 명수를 출력한다.

- 예제 입력 1 
3 duck
oridya hello
orihehe hi
duck hi

- 예제 출력 1 
1

- 예제 입력 2 
8 orihehe
orihehe duck
skynet duck
rdd duck
vega duck
reversing duck
dongbin duck
kimyh duck
hunni duck

- 예제 출력 2 
0
실제로는 아쉬운 사람이 없을 수도 있다.

- 예제 입력 3 
8 orihehe
hunni duck
skynet duck
rdd duck
vega duck
reversing duck
dongbin duck
kimyh duck
orihehe duck

- 예제 출력 3 
7

- 예제 입력 4 
8 orihehe
hunni dduck
skynet dduck
rdd dduck
vega dduck
reversing dduck
dongbin dduck
kimyh dduck
orihehe duck

- 예제 출력 4 
0
*/