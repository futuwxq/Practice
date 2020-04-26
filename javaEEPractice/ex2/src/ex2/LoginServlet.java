package ex2;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/***
 * cookie�����û������û�����
 * @author future
 *
 */
public class LoginServlet extends HttpServlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String name = request.getParameter("name");
		    String pwd = request.getParameter("pwd");
		    String flag = request.getParameter("isLogin");
		    //�û��ĳ�������admin������������123
		    if (!"admin".equals(name) && !"123".equals(pwd)) {
		        response.sendRedirect("fail.html");
		    } else {
		        if ("on".equals(flag)) {
		            //��������Cookie����
		            Cookie nameCookie = new Cookie("username", name);
		            //����Cookie����Ч��Ϊ3��
		            nameCookie.setMaxAge(60 * 60 * 24 * 3);
		            Cookie pwdCookie = new Cookie("password", pwd);
		            pwdCookie.setMaxAge(60 * 60 * 24 * 3);
		            response.addCookie(nameCookie);
		            response.addCookie(pwdCookie);
		        }
		        response.sendRedirect("success.html");
		    }
	 }

}
