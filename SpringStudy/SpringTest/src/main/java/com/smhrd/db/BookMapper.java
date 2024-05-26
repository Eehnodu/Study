package com.smhrd.db;

import java.util.List;

import com.smhrd.model.BookVO;

public interface BookMapper {

	public List<BookVO> bookList();
	
	public int bookInsert(BookVO vo);

}
