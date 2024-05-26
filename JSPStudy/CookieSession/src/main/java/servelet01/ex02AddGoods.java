package servelet01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet을 생성할 때 url mapping을 잡아주면 좋은점?
// ---> /가 없으면 다음 ㅠㅔ이지로 넘어가지 않기때문에, 내 실수를 방지할 수 있다!
// 여기서도 수정해도 되나요? >> 네! 상관없습니다

@WebServlet("/AddGoods")
public class ex02AddGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] product = request.getParameterValues("product");
		if (product == null) {
			response.sendRedirect("Shop.jsp");
		} else {
			for (int i = 0; i < product.length; i++) {
				Cookie cookie = new Cookie("product" + (i + 1), product[i]);
				cookie.setMaxAge(3600 * 24);
				response.addCookie(cookie);
			}
		}

		Cookie[] result = request.getCookies();
		String keyword = "product";
		for (int i = 0; i < result.length; i++) {
			if (result[i].getName().contains(keyword)) {
				Cookie cookie_remove = new Cookie("product" + (i + 1), "");
				cookie_remove.setMaxAge(0);
				response.addCookie(cookie_remove);
			}
		}
	}

}
