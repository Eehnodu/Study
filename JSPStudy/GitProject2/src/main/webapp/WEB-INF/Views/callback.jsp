<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.net.HttpURLConnection"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.InputStreamReader"%>
<%@ page import="com.fasterxml.jackson.databind.JsonNode"%>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page import="com.test.database.DAO"%>
<%@ page import="com.test.model.MemberVO"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.io.UnsupportedEncodingException"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>네이버로그인</title>
</head>
<body>
	<%
	String clientId = "gbLrG9lQfNuwCCfz4nge";//애플리케이션 클라이언트 아이디값";
	String clientSecret = "UXZwOBztuj";//애플리케이션 클라이언트 시크릿값";
	String code = request.getParameter("code");
	String state = request.getParameter("state");
	String redirectURI = URLEncoder.encode("http://localhost:8080/GitProject/fitcallback.do", "UTF-8");
	String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code" + "&client_id=" + clientId
			+ "&client_secret=" + clientSecret + "&redirect_uri=" + redirectURI + "&code=" + code + "&state=" + state;
	String accessToken = "";
	String refresh_token = "";
	
	try {
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		BufferedReader br;
		if (responseCode == 200) { // 정상 호출
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else { // 에러 발생
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		String inputLine;
		StringBuilder res = new StringBuilder();
		while ((inputLine = br.readLine()) != null) {
			res.append(inputLine);
		}
		br.close();
		
		if (responseCode == 200) {
			//            out.println(res.toString());
			//            {"access_token":"AAAAO7XQ8wdHXS1V53PykNcNoFpR-FUOOhfLeorYXzw8C0mB54ty31WTgJuolo4ohfo_h6F4RqJLXxOPh4wyjClM3Xc","refresh_token":"8Xtiizip39OAEJJZMwn4qQJlEZWaKVmcM5z9WdqwWN1f69SEPybAEvAY6IqQoGiidkvygRFHzBHN2l4fipis6MLufBesSUm4u97aHwHCuUjLIdua88siptipWwB5Nt99utiptzzu","token_type":"bearer","expires_in":"3600"}

			// 네이버에 사용자 정보요청. {"access_token":"AAAAO7XQ8wdHXS1V53PykNcNoFpR-FUOOhfLeorYXzw8C0mB54ty31WTgJuolo4ohfo_h6F4RqJLXxOPh4wyjClM3Xc"}
			String token = res.toString();
			String[] tokens = token.split(",");
			accessToken = tokens[0].split(":")[1].replace("\"", "");
			String tokenURL = "https://openapi.naver.com/v1/nid/me";
			URL url2 = new URL(tokenURL);
			HttpURLConnection con2 = (HttpURLConnection) url2.openConnection();
			con2.setRequestMethod("GET");
			con2.setRequestProperty("Authorization", "Bearer " + accessToken);
			int responseCode2 = con2.getResponseCode();
			BufferedReader br2;
			
			if (responseCode2 == 200) { // 정상 호출
			br2 = new BufferedReader(new InputStreamReader(con2.getInputStream()));
			} else { // 에러 발생
			br2 = new BufferedReader(new InputStreamReader(con2.getErrorStream()));
			}
			String inputLine2;
			StringBuilder res2 = new StringBuilder();
			while ((inputLine2 = br2.readLine()) != null) {
			res2.append(inputLine2);
			}
			br2.close();
			// out.println(res2.toString());
			// {"resultcode":"00","message":"success","response":{"id":"7Q16Rs5lkJJSjXg-Qk6M_g_5jkPNMiebolTN-SpOsqw","age":"30-39","gender":"M","email":"dlwlgnsrhy@gmail.com","mobile":"010-2208-3166","mobile_e164":"+821022083166","name":"\uc774\uc9c0\ud6c8","birthday":"03-19","birthyear":"1995"}}
			// get email and name from res2
			String jsonString = res2.toString();
			
			try {
			ObjectMapper mapper = new ObjectMapper();
		 	//Set the character encoding to UTF-8
		 	 mapper.enable(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS);
		 	 mapper.enable(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER);
		 	 mapper.enable(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES);
		 	 mapper.enable(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS);
	     	 mapper.enable(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS);

			JsonNode rootNode = mapper.readTree(jsonString);
	
			// Get the response node
			JsonNode responseNode = rootNode.path("response");
	
			// Extract email and name from the response node
			String email = responseNode.path("email").asText();
			String name = responseNode.path("name").asText();
			String mobile = responseNode.path("mobile").asText();
			String birthyear = responseNode.path("birthyear").asText();
			String birthday = responseNode.path("birthday").asText();
			String nickName = responseNode.path("nickName").asText();
	
			System.out.println("Email: " + email);
			System.out.println("Name: " + name);
			System.out.println("Mobile: " + mobile);
			System.out.println("Birthyear: " + birthyear);
			System.out.println("Birthday: " + birthday);
			System.out.println("nickName: " + nickName);
	
			////////////////////////////////////
			// 회원 가입여부 판단 by email. check if already joined by email.
			DAO dao = new DAO();
			MemberVO result = dao.getMemberByEmail(email);
			if (result == null) {
				//간편회원가입 input태그에 값 담기
		
			try {
			    String encodedEmail = URLEncoder.encode(email, "UTF-8");
			    String encodedName = URLEncoder.encode(name, "UTF-8");
			    String encodedMobile = URLEncoder.encode(mobile, "UTF-8");
			    String encodedBirthyear = URLEncoder.encode(birthyear, "UTF-8");
			    String encodedBirthday = URLEncoder.encode(birthday, "UTF-8");
			    String encodednickName = URLEncoder.encode(nickName, "UTF-8");

			    String redirectUrl = "NaverJoin.do?email=" + encodedEmail 
			                         + "&name=" + encodedName 
			                         + "&mobile=" + encodedMobile 
			                         + "&birthyear=" + encodedBirthyear 
			                         + "&birthday=" + encodedBirthday
			                         + "&nickName=" + encodednickName;

			    response.sendRedirect(redirectUrl);
			} catch (UnsupportedEncodingException e) {
				System.err.println("Unsupported Encoding Exception: " + e.getMessage());
			}
	
			} else {
				// 로그인 // 사용자 정보를 세션에 저장
				session.setAttribute("member", result);
				response.sendRedirect("fitindex.do");
			}
			/////////////////////////////////
	
				} catch (Exception e) {
			e.printStackTrace();
				}
	
			} else {
				// 에러 로깅
				out.println(res.toString());
			}
			} catch (Exception e) {
				// Exception 로깅
			}
		%>
</body>
</html>
