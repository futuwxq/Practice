package lesson.ex1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ʹ��Servlet��ʼ�������������ĳ�ʼ������
 * @author future
 *
 */
public class TestInitParams extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("Test Init Parammeters<br>");
				java.util.Enumeration e = getServletConfig().getInitParameterNames();
				java.util.Enumeration e1 = getServletContext().getInitParameterNames();
				while(e.hasMoreElements()) {
					out.println("<br>param name1 = " + e.nextElement() + "<br>");
				}
				out.println("admin email is" + getServletConfig().getInitParameter("email"));
				out.println("<br>");
				while(e1.hasMoreElements()) {
					out.println("<br>param name2 = " + e1.nextElement() + "<br>");
				}
				out.println("main email is" + getServletContext().getInitParameter("mainEmail"));
					}
	
}
