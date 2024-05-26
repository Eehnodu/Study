package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex06_maketable
 */
@WebServlet("/Ex06_maketable")
public class Ex06_maketable extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("</html>");

		out.print("<table border=1>");
		out.print("<tr>");

		for (int i = 1; i <= num; i++) {
			out.print("<td>" + i + "</td>");
		}

		out.print("</tr>");
		out.print("</table>");

		out.print("<body>");
		out.print("</body>");
	
	}

}
