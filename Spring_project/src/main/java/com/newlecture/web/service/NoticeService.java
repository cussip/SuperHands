package com.newlecture.web.service;

import java.sql.SQLException;
import java.util.List;

import com.newlecture.web.entity.Notice;

public interface NoticeService {

	public List<Notice> getList(int page, String field, String query) throws ClassNotFoundException, SQLException;	
	public int getCount(String searchField, String searchWord) throws SQLException, ClassNotFoundException;
	public int insert(Notice notice) throws ClassNotFoundException, SQLException;
	public int update(Notice notice) throws ClassNotFoundException, SQLException;
	public int delete(int id) throws ClassNotFoundException, SQLException;
	
}
