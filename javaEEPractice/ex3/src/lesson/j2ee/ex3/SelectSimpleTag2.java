package lesson.j2ee.ex3;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * �Զ���ѡ���ǩ
 * ���ѡ���
 * @author future
 *
 */
public class SelectSimpleTag2 extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {
		String[] color = { "light", "amber", "brown", "dark" };
		String outPrint = "";
		outPrint += "<select name='color' size='1'>";
		for (int i = 0; i < color.length; i++) {
			outPrint += "<option>";
			outPrint += color[i];
			outPrint += "</option>";
		}
		outPrint += "</select>";
		getJspContext().getOut().print(outPrint);
	}
}
