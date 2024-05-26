package JavaFestivalQ;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex28 {

	   public static void main(String[] args) {
	      String str = "01001111";
	      System.out.print(str +"(2) = ");
	      System.out.println(to10(str) + "(10)");
	      
	      ArrayList<Character> arr = new ArrayList<>();
	      for(int i = 0; i<str.length(); i++) {
	    	  arr.add(str.charAt(i));
	      }
	      
	      int sum = 0, count = 1;
	      for(int i = arr.size()-1; i>=0 ;i-- ) {
	    	  sum += ((int)arr.get(i) - 48) * count;
	    	  count *= 2;
	      }
	      System.out.println(sum);
	   }
	   
	   
	   
	   
	   
	   public static int to10(String str) {
	      
	      // 문자열과 문자열에 해당하는 각 문자열을 담을 배열 선언
	      String[] strarr = new String[str.length()];
	      int[] intarr = new int[str.length()];
	      
	      // 문자열을 한 글자씩 배열에 저장
	      strarr = str.split("");
	      
	      int result = 0;
	      // 배열의 시작부터 2의 제곱승이 64->32->16...처럼 감소하는 제곱승을 곱하는 방법
//	      for(int i = 0; i<str.length(); i++) {
//	         // strarr의 값을 하나씩 intarr 배열에 저장하고
//	         intarr[i] = Integer.parseInt(strarr[i]);
//	         // Math.pow --> 제곱을 구하는 함수
//	         // 를 이용하여 각 배열의 값에 2의 제곱인 값을 곱하고 result에 더함
//	         result += intarr[i] * (Math.pow(2,intarr.length-1-i));      
//	      }
	      
	      // 배열의 끝부터 1->2->4->8...처럼 증가하는 제곱승을 곱하는 방법
	      for(int i = str.length()-1; i >= 0; i--) {
	         // Intege.pareseInt함수는 문자열을 정수로 변환해주는 함수
	          intarr[i] = Integer.parseInt(strarr[i]);
	          // 1. intarr[str.length()-1]의 값은 1
	          //    Math.pow(2,str.length()-1-i의 값은 Math.pow(2,0)이므로 2의 0승인 1
	          // 2. for문에 의해서 intarr의 값은 마지막의 앞인 1
	          //    Math.pow함수는 Math.pow(2,1)이므로 2의 1승인 2
	          result += intarr[i] * (Math.pow(2, str.length()-1-i));
	      }

	      return result;
	   }
	}
