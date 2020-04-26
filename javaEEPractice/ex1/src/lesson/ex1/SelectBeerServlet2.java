package lesson.ex1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
/**
 * ����û�ѡ��brown����redirect��һ��Servlet: ShowBrownBeer.java������ʾ�����û�ѡ��dark����dispatch������һ��Servlet: ShowDarkBeer.java������ʾ
 * @author future
 *
 */
public class SelectBeerServlet2 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException { 
		String colorParam = request.getParameter("color"); 
		if( "brown".equals(colorParam)){
			response.sendRedirect("BrownBeer");		
		}
		else if ("dark".equals(colorParam)){
//			response.sendRedirect("ShowDarkBeer");		
		  request.getRequestDispatcher("DarkBeer").forward(request, response);
		}
		else{
			PrintWriter out = response.getWriter();
			out.println("<html> " + "<body>"
					+ "<h1 align=center>Beer Color</h1>" + "<br>"
					+ "My selected beer color is: " + colorParam + "</body>" + "</html>");
		}
		
	}
}
