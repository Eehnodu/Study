package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex04_Operation")
public class Ex04_Operation extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      int data1 = Integer.valueOf(request.getParameter("num1"));
      int data2 = Integer.valueOf(request.getParameter("num2"));
      String op = request.getParameter("op");

      int result = 0;
      if (op.equals("+")) {
          result = data1 + data2;
      } else if (op.equals("-")) {
          result = data1 - data2;
      } else if (op.equals("*")) {
          result = data1 * data2;
      } else {
          result = data1 / data2;
      }

      PrintWriter out = response.getWriter();
      out.print(result);

         
   }

   
}