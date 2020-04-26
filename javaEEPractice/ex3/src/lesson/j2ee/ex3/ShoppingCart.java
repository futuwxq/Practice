package lesson.j2ee.ex3;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/**
 * ���ﳵ����
 * 
 */
public class ShoppingCart extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// ȡ��Session����
		// ���Session�����ڣ�Ϊ���λỰ�����˶���
		HttpSession session = req.getSession(true);
		Integer itemCount = (Integer) session.getAttribute("itemCount");
		// ���session���µ�
		if (itemCount == null)
			itemCount = new Integer(0);

		PrintWriter out = res.getWriter();
		res.setContentType("text/html");

		// ���մ����Ĳ���
		String[] itemsSelected;
		String itemName;
		itemsSelected = req.getParameterValues("item");

		if (itemsSelected != null) {
			for (int i = 0; i < itemsSelected.length; i++) {
				itemName = itemsSelected[i];
				System.out.println(itemName);
				itemCount = new Integer(itemCount.intValue() + 1);
				// �������Ŀ
				session.setAttribute("item" + itemCount, itemName);
				// ����Ŀ
				session.setAttribute("itemCount", itemCount);
			}
		}

		out.println("<html>");
		out.println("<title>");
		out.println("item list");
		out.println("</title>");
		out.println("<body><h4>Session List:</h4><hr><br><br>");
		for (int i = 1; i <= itemCount.intValue(); i++) {
			out.println((String) session.getAttribute("item" + i) + "<hr>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}