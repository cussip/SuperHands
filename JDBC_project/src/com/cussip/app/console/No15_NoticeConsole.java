package com.cussip.app.console;

import java.io.*;
import java.sql.SQLException;
import java.util.List;

import com.cussip.app.entity.Notice;
import com.cussip.app.service.No13_NoticeService;

public class No15_NoticeConsole {

	private No13_NoticeService service;
	private int page;
	private String searchWord;		//검색어
	private String searchField;		//검색하기 위한 필드(id, 제목, 작성자 등)
	
	
	
	public No15_NoticeConsole() {
		service = new No13_NoticeService();
		page = 1;
		searchField = "TITLE";
		searchWord = "";
	}
	
	public void printNoticeList() throws ClassNotFoundException, SQLException {
		
//		for(Notice n : service.getList()) {
			//아래 방식으로 변경
//		List<Notice> list = service.getList();
			//Notice의 모든 목록을 전부 가져오는 문제. 페이지를 나누기 위해서는 
			//일부만 가져오도록 수정이 필요(페이징)
		List<Notice> list = service.getList(page, searchField, searchWord);
			//페이징 적용
		int count = service.getCount(searchField, searchWord);
//		int lastPage = (int)Math.ceil((double)count / 5);
		int lastPage = count / 5;
		lastPage = count % 5 == 0 ? lastPage : lastPage + 1;
		
		System.out.printf("<공지사항> 총 %d 게시글\n"
				+ "────────────────────────────────────"
				+ "──────────────────────────────────\n"
				, count);
		
		for(Notice n : list) {
			System.out.print(n.getId() + 
					" / " + n.getTitle() + 
					" / " + n.getWriter_id() + 
					" / " + n.getRegdate() + "\n"
			);
		}
		System.out.printf("────────────────────────────────────"
				+ "──────────────────────────────────\n"
				+ "                    %d / %d pages"
				, page, lastPage);

	}

	public int inputNoticeMenu() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("\n\n1.상세조회 / 2.이전 / 3.다음 / 4.글쓰기 / 5.검색 / 0.종료 > ");
		int menu = Integer.parseInt(br.readLine());
		
		return menu;
	}

	public void movePrevList() {
		if(page == 1) {
			System.out.println("────────────────────────────────────");
			System.out.println("[ 이전 페이지가 없습니다. ]");
			System.out.println("────────────────────────────────────");
			return;
		}
		page--;
	}

	public void moveNextList() throws ClassNotFoundException, SQLException {
		//마지막 페이지를 구하는 로직을 추가
		int count = service.getCount(searchField, searchWord);
		int lastPage = count / 5;
		lastPage = count % 5 == 0 ? lastPage : lastPage + 1;
		
		if(page == lastPage) {
			System.out.println("────────────────────────────────────");
			System.out.println("[ 다음 페이지가 없습니다. ]");
			System.out.println("────────────────────────────────────");
			return;
		}
		page++;		
	}

	public void InputSearchWord() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//꼭 공유해야하는 변수나 함수가 아니라면 개별적으로 가지고 있는 것이 더 좋다.
		System.out.println("검색조건을 선택하세요.(title/content/writerId)");
		System.out.print("> ");
		searchField = br.readLine();
		
		System.out.println("검색어를 입력하세요.");
		System.out.print("> ");
		searchWord = br.readLine();
	}
}
