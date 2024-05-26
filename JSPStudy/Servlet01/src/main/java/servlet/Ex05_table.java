package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex05_table
 */
@WebServlet("/Ex05_table")
public class Ex05_table extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("</html>");

		out.print("<table border=1>");
		out.print("<tr>");

		for (int i = 1; i <= 6; i++) {
			out.print("<td>" + i + "</td>");
		}

		out.print("</tr>");
		out.print("</table>");

		out.print("<body>");
		out.print("</body>");
	}

}
