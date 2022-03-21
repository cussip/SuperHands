package ex1;

import java.io.IOException;
import java.sql.SQLException;

import com.cussip.app.console.No15_NoticeConsole;

public class No15_Program {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		
		No15_NoticeConsole console = new No15_NoticeConsole();
		EXIT:
		while(true) {
			console.printNoticeList();
			int menu = console.inputNoticeMenu();
			switch(menu) {
			case 1:				//상세조회	
				break;
			case 2:				//이전
				console.movePrevList();
				break;
			case 3:				//다음
				console.moveNextList();
				break;
			case 4:				//글쓰기
				break;
			case 5:				//검색
				console.InputSearchWord();
				break;
			case 0:				//시스템종료
				System.out.println("See you again!");
				break EXIT;
			default:
				System.out.println("\nSelect again!(Wrong Number)");
				break;
			}
		}	
	}
}
