package lesson.j2ee.ex4;

/**
 * ����ͳ�Ƽ���
 * 
 */
public class StatisticInfo {

	private static int count = 1;

	/**
	 * ÿ�ε��ý�����+1��ע��synchronized������ʹ�ã��������̼�������
	 * 
	 * @return ��ǰ���ʼ���
	 */
	public static synchronized int getCount() {

		return count++;
	}

}