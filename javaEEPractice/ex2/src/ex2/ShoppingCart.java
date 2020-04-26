package ex2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * ���ﳵ����
 */
public class ShoppingCart extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//ȡ��Session�����Session�����ڣ�Ϊ���λỰ��������
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(3*60);//����session����Чʱ��
		Integer itemCount = (Integer)session.getAttribute("itemCount");
		if (itemCount == null)
			itemCount = new Integer(0);	
		//�����������ȡһ����Ӧ�ͻ��˵�������
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String[] itemsSelected;//��ѡ���ѡ��
		String itemName;
		//���մ����Ĳ���
		itemsSelected = request.getParameterValues("item");
		if(itemsSelected != null){
			for(int i = 0 ; i <itemsSelected.length;i++){
				itemName = itemsSelected[i];
				itemCount = new Integer(itemCount.intValue() + 1 );
				//����session
				//�����ÿ����¼
				session.setAttribute("item"+itemCount, itemName);
				//������ܴ���
				session.setAttribute("itemCount", itemCount);
			}
			
			out.println("<html>");
			out.println("<title>");
			out.println("item list");
			out.println("</title>");
			out.println("<body><h4>Session List:</h4><hr><br><br>");
			for(int i = 1 ;i <= itemCount.intValue(); i ++){
				out.println("item" + i);
				out.println(session.getAttribute("item" + i ) + "<hr>");
			}
			out.println("</body>");
			out.println("</html>");
			out.close();
		}
//		session.invalidate();	//����session
	}
}
