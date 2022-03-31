package com.newlecture.web.entity;

import java.sql.Date;

public class NoticeCmtView extends Notice {
	
	private int cmt;
	
	public NoticeCmtView() {
		super();
	}

	public NoticeCmtView(int id, String title, Date regdate, String writerId, String hit, String files, int cmt) {
		super(id, title, regdate, writerId, hit, files, "");
		this.cmt = cmt;
	}

	public int getCmt() {
		return cmt;
	}

	public void setCmt(int cmt) {
		this.cmt = cmt;
	}	
}
