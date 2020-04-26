package lesson.ex1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
/**
 * ����һ��jar�ļ�
 * @author future
 *
 */
public class CodeReturn extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException {
//		�������֪������һ��JAR�ļ�
		response.setContentType("application/jar");
		ServletContext ctx = getServletContext();
//		Ϊ��Դ����һ��������
		InputStream is = ctx.getResourceAsStream("/resources/bookCode.jar");
		int read = -1;
		byte[] bytes = new byte[1024];
		OutputStream os = response.getOutputStream();
		while ((read = is.read(bytes))!=-1) {
			os.write(bytes,0,read);
		}
		os.flush();
		os.close();

	}
}
