package condition;

public class Cond08 {

	public static void main(String[] args) {
		// 성적에 따라 학점을 구분해주세요.
		int  score = 77;	// 성적
		char grade = ' ';   // 학점

		switch(score) {
			case 100:
			case 99:	case 98:	case 97:	case 96:	case 95:
			case 94:	case 93:	case 92:	case 91:	case 90:
				grade = 'A';
				break;
			case 89:	case 88:	case 87:	case 86:	case 85:
			case 84:	case 83:	case 82:	case 81:	case 80:
				grade = 'B';
				break;
			case 79:	case 78:	case 77:	case 76:	case 75:
			case 74:	case 73:	case 72:	case 71:	case 70:
				grade = 'C';
				break;
			case 69:	case 68:	case 67:	case 66:	case 65:
			case 64:	case 63:	case 62:	case 61:	case 60:
				grade = 'D';
				break;
			default:
				grade = 'F';
		} // End - switch
		System.out.println("당신의 점수는 " + score + "이고, 학점은 " + grade + "입니다.");
	} // End - public static void main(String[] args)

} // End - public class Cond08







