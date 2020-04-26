package ex2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * ʹ��cookie�����¼��Ϣ
 */
public class Login extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String name = request.getParameter("name");
		boolean judge = false;
		// ��ȡcookie
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				// �ҵ���Ϊname��cookie
				if (cookies[i].getName().equals("name")) {
					cookies[i].setValue(name);
					judge = false;// cookie�Ѿ���ֵ
				}
			}
			// ���cookie��û�����ɣ����½�һ��cookie
			if (judge) {
				Cookie cookie = new Cookie("name", name);
				// ����cookie����������
				cookie.setMaxAge(12 * 60 * 60);
				response.addCookie(cookie);
			}

			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<title>");
			out.println("�û��б�");
			out.println("</title>");
			out.println("<body><h4>�û��б�</h4><hr><br><br>");
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("name")) {
					out.print("�û�����" + cookies[i].getValue());
				}
			}

			out.println("</body>");
			out.println("</html>");
			out.close();

		}
	}
}
