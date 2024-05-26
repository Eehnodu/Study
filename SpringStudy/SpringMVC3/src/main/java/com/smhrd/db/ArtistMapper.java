package com.smhrd.db;

import java.util.List;

import com.smhrd.model.ArtistVO;

public interface ArtistMapper {
	
	// 아티스트 데이터 가져오기 메소드
	public List<ArtistVO> getdata();
}
