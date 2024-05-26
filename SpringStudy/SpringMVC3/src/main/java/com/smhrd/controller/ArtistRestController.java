package com.smhrd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smhrd.db.ArtistMapper;
import com.smhrd.model.ArtistVO;

@RestController
public class ArtistRestController {
	
	@Autowired
	private ArtistMapper mapper;
	
	// 아티스트 정보 가져오기
	@GetMapping("/getdata")
	public List<ArtistVO> getdata() {
		List<ArtistVO> result = mapper.getdata();
		return result;
	}
}
