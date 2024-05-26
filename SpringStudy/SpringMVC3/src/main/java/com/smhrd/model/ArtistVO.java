package com.smhrd.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter
@AllArgsConstructor // 모든 필드값을 받는 생성자
@NoArgsConstructor // 기본 생성자
public class ArtistVO {
	private Date collectDate;
	private String channel;
	private String artist;
	private String keyword;
	private long keywordCnt;

}
