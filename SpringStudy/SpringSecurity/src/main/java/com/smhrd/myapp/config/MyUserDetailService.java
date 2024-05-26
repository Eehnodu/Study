package com.smhrd.myapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.smhrd.myapp.entity.Member;
import com.smhrd.myapp.repo.MemberRepository;

// DB에 있는 데이터로도 인증가능하게끔 만들어주기 위해서 생성한 클래스

@Component // --> SC 적재되라고 작성
public class MyUserDetailService implements UserDetailsService {
	
	// DAO == mapper == repository
	@Autowired
	private MemberRepository repo;
	
	// DB에 있는 데이터를 가져와서, security 안에 있는 인증된 사용자를 생성
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 1. DB에서 username을 기준으로 사용자 정보를 조회
		Member findUser = repo.findByUserid(username);
		// 2. 만약에 데이터베이스에 존재하지 않는 user라면
		if(findUser == null) {
			System.out.println("없는 회원입니다.");
		}
		// 3. DB에서 조회한 데이터로 인증받을 사용자 정보를 생성
		return User.builder()
				.username(findUser.getUserid())
				.password(findUser.getPw())
				.roles(findUser.getRole())
				.build();
	} 
}
