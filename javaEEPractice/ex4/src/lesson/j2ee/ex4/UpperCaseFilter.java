package lesson.j2ee.ex4;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ʵ�ֶ�ҳ��������ı��Ĵ�дת��
 * @author future
 *
 */
public class UpperCaseFilter implements Filter {
	protected FilterConfig config;
	@Override
	public void destroy() {
		this.config = null;

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
	ServletResponse newResponse = resp;
	if(req instanceof HttpServletRequest) {
		newResponse = new CharResponseWrapper((HttpServletResponse)resp);
	}
	// ִ��doFilter������ע��˴���Ӧ�����Ѿ��仯
	chain.doFilter(req, newResponse);
	// ����ִ����Ӧ����
	if(newResponse instanceof CharResponseWrapper){
		String text = newResponse.toString(); //���ð�װ��Ӧ������д�ķ������ҳ��������ı�
		if(text != null){
			text = text.toUpperCase();
     //����������ݴ�����������������ؿͻ���
			resp.getWriter().write(text);
			}
	}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;

	}

}
