package object.phonebook.v1;

//-----------------------------------------------------------------------------------------------------------
// class PhoneInfo
//-----------------------------------------------------------------------------------------------------------
class PhoneInfo {
	String	name;			// 이름
	String	phoneNumber;	// 전화번호
	String	birth;			// 생년월일
	
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
		System.out.println("---------------------------------------------------------------");
		System.out.println("이    름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		if(birth != null)
			System.out.println("생년월일 : " + birth);
	}
	
} // End - class PhoneInfo

//-----------------------------------------------------------------------------------------------------------
// public class PhoneBook01
//-----------------------------------------------------------------------------------------------------------
public class PhoneBook01 {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		PhoneInfo	pi1	= new PhoneInfo("고길동", "010-1234-5678", "1998.12.31");
		PhoneInfo	pi2	= new PhoneInfo("향단이", "010-1111-222");
		
		pi1.showPhoneInfo();
		pi2.showPhoneInfo();

	} // End - public static void main(String[] args)

} // End - public class PhoneBook01














