package ex2;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * ����session������Ӻ͸���
 * @author future
 *
 */
public class BookAddedListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		String name = event.getName();
		Object value = event.getValue();
		System.out.println("������ԣ�" + name + ":" + value);

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		String name = event.getName();
		Object value = event.getValue();
		System.out.println("�������ԣ�" + name + ":" + value);

	}

}
