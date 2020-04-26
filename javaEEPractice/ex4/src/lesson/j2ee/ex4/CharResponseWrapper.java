package lesson.j2ee.ex4;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 *  ʹ��java.io.CharArrayWriter���������ı�������а�װ
 *  
 * @author future
 *
 */
public class CharResponseWrapper extends HttpServletResponseWrapper {
	protected CharArrayWriter charWriter; // ����Ӧ���������д������
	protected PrintWriter writer;
	protected boolean getOutputStreamCalled;
	protected boolean getWriterCalled;

	public CharResponseWrapper(HttpServletResponse response) {
		super(response);
		// ����writer
		charWriter = new CharArrayWriter();
	}

	/**
	 * ����getOutputStream()����
	 */
	public ServletOutputStream getOutputStream() throws IOException {
		// ���getWriter()�����������ˣ��Ͳ��ܵ���getOutputStream()����
		if (getWriterCalled) {
			throw new IllegalStateException("getWriter already called");
		}
		getOutputStreamCalled = true;
		return super.getOutputStream();
	}

	/**
	 * ����getWriter()����
	 */
	public PrintWriter getWriter() throws IOException {
		if (writer != null) {
			return writer;
		}
		// ���getOutputStream()�����������ˣ��Ͳ��ܵ��÷���getWriter()
		if (getOutputStreamCalled) {
			throw new IllegalStateException("getOutputStream already called");
		}
		getWriterCalled  =true;
		writer = new PrintWriter(charWriter);
		return writer;
	}
	
	/**
	 * ����Ӧ�������ַ�������
	 */
	public String toString() {
		String s = null;
		if(writer != null){
			s = charWriter.toString();
		}
		return s;
	}
	
}
