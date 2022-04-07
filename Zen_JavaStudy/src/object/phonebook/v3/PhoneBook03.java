package object.phonebook.v3;

import java.util.Scanner;

//-----------------------------------------------------------------------------------------------------------
// 전화번호 정보
//-----------------------------------------------------------------------------------------------------------
class PhoneInfo {
	String	name;
	String	phoneNumber;
	String	birth;
	
	public PhoneInfo(String name, String num, String birth) {
		this.name	= name;
		phoneNumber	= num;
		this.birth	= birth;
	}
	public PhoneInfo(String name, String num) {
		this.name	= name;
		phoneNumber	= num;
		this.birth	= null;
	}
	public void showPhoneInfo() {
		System.out.println("-----------------------------------------------------------------");
		System.out.println("이    름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		if(birth != null)
			System.out.println("생년월일 : " + birth);
	}
} // End - class PhoneInfo
//-----------------------------------------------------------------------------------------------------------
// 전화번호부 기능(입력, 조회, 삭제)
//-----------------------------------------------------------------------------------------------------------
class PhoneBookManager {
	final int MAX_CNT = 100;	// 전화번호 자료 최대 100건
	
	// PhoneInfo를 담을 수 있는 방이 100개 생성되는 것이 아니라,
	// PhoneInfo형태의 메모리를 가리키는 참조변수가 100개 만들어 지는 것이다.
	// infoStorage[curPos++] = new PhoneInfo(name, phone, birth);
	PhoneInfo[] infoStorage = new PhoneInfo[MAX_CNT];
	int curPos = 0; // 배열에 마지막으로 저장된 위치
	
	//-----------------------------------------------------------------------------------------------------------
	// 전화번호 정보 입력
	public void inputData() {
		System.out.println("전화번호 정보 입력을 시작합니다.");
		System.out.print("이    름 : ");
		String 	name	= MenuViewer.keyboard.nextLine();
		System.out.print("전화번호 : ");
		String 	phone	= MenuViewer.keyboard.nextLine();
		System.out.print("생년월일 : ");
		String	birth	= MenuViewer.keyboard.nextLine();
		
		infoStorage[curPos++] = new PhoneInfo(name, phone, birth);
		// curPos++;
		System.out.println("전화번호 정보 입력이 완료되었습니다.");
	}
	//-----------------------------------------------------------------------------------------------------------
	// 이름으로 정보 검색
	public void searchData() {
		System.out.println("이름으로 전화번호 정보를 검색합니다.");
		System.out.print("이 름 : ");
		String name = MenuViewer.keyboard.nextLine();
		
		// search(name)에 찾고자하는 이름을 넣어서 호출하면,
		// 이름에 해당하는 자료를 찾으면 방번호를 받고, 아니면 -1을 돌려받는다.
		int dataIndex = search(name);
		if(dataIndex < 0) { // 이름에 해당하는 자료가 없다면
			System.out.println("해당하는 자료가 없습니다.");
		} else { // 이름에 해당하는 자료를 찾으면
			infoStorage[dataIndex].showPhoneInfo();
			System.out.println("데이터 검색이 완료되었습니다.");
		}
	}
	//-----------------------------------------------------------------------------------------------------------
	// 전화번호 정보 삭제
	public void deleteData() {
		System.out.println("이름에 해당하는 전화번호 정보를 삭제합니다.");
		System.out.print("이름 : ");
		String	name = MenuViewer.keyboard.nextLine();
		
		// search(name) 메서드에 이름을 넣어서 실행하면,
		// 이름에 해당하는 자료가 있으면 찾은 방번호를 돌려받고, 못찾았으면 -1을 돌려받는다.
		int dataIndex = search(name);
		if(dataIndex < 0) { // 이름에 해당하는 자료가 없다면
			System.out.println("이름에 해당하는 자료가 없습니다.");
		} else { // 이름에 해당하는 자료를 찾았으면
			// 해당 데이터를 삭제하고, 뒤에 있는 자료들을 앞으로 하나씩 보낸다.
			// 작업시작은 이름에 해당하는 자료를 찾은데에서부터 시작하면 된다.
			for(int idx = dataIndex; idx < (curPos -1); idx++) {
				infoStorage[idx] = infoStorage[idx+1];
			}
			curPos--;
			System.out.println("데이터 삭제가 완료되었습니다.");
		}
		
	}
	//-----------------------------------------------------------------------------------------------------------
	// 이름으로 데이터가 어느 위치에 있는지 찾아주는 메서드
	private int search(String name) {
		// 현재 데이터가 들어있는 곳까지만 검색한다.
		for(int idx = 0; idx < curPos; idx++) { // 데이터가 있는데 까지만 검사한다.
			PhoneInfo curInfo = infoStorage[idx]; // 데이터 한건을 추출한다.
			if(name.compareTo(curInfo.name) == 0) // 방에 찾는 이름을 발견하면
				return idx; // 방번호를 돌려준다.
		}
		return -1; // 검색이 끝날 때까지 이름을 못찾으면 -1을 돌려준다.
	}
} // End - class PhoneBookManager
//-----------------------------------------------------------------------------------------------------------
// 전화번호부 메뉴
//-----------------------------------------------------------------------------------------------------------
class MenuViewer {
	public static Scanner keyboard = new Scanner(System.in);
	
	public static void showMenu() { // 메뉴를 보여주는 메서드
		System.out.println("----------------------------------------------------");
		System.out.println("하시고자 하는 작업에 해당하는 번호를 입력해주십시요.");
		System.out.println("1. 전화번호 입력");
		System.out.println("2. 이름으로 검색");
		System.out.println("3. 이름으로 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 : ");
	}
} // End - class MenuViewer

//-----------------------------------------------------------------------------------------------------------
// public class PhoneBook03
//-----------------------------------------------------------------------------------------------------------
public class PhoneBook03 {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		
		PhoneBookManager manager = new PhoneBookManager(); // 입력, 삭제, 조회를 사용하기 위해서 객체를 생성한다.
		int choice = 0;	// 메뉴를 선택한 값을 저장할 변수
		
		while(true) {
			// 화면에 메뉴를 보여준다.
			// static method()는 클래스를 생성하지 않고 클래스이름.메서드()로 사용할 수 있다.
			MenuViewer.showMenu();
			
			// 메뉴를 보고 작업을 선택한다.
			choice = MenuViewer.keyboard.nextInt();
			MenuViewer.keyboard.nextLine();
			
			// 선택한 값에 따라서 작업을 처리한다.
			switch(choice) {
				case 1: // 입력
					manager.inputData();
					break;
				case 2: // 조회
					manager.searchData();
					break;
				case 3: // 삭제
					manager.deleteData();
					break;
				case 0: // 종료
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("메뉴를 보고 작업을 다시 선택해주십시오.");
					break;
			}
		} // End - while(true)
		
	} // End - public static void main(String[] args)

} // End - public class PhoneBook03















