package lesson.ex1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
/**
 * ���color���Բ������ʾ
 * @author future
 *
 */
public class SelectBeerServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException { 
		String colorParam = request.getParameter("color"); 
		PrintWriter out = response.getWriter();
		out.println("<html> " + "<body>"
				+ "<h1 align=center>Beer Color</h1>" + "<br>"
				+ "My selected beer color is: " + colorParam + "</body>" + "</html>");
	}
}
