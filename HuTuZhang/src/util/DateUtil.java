package util;
/**
 * ʱ��Ĺ�����
 */

import java.util.Calendar;
import java.util.Date;

/**
 * ʱ�乤����
 * 
 * @author Administrator
 *
 */

public class DateUtil {
	// һ��ĺ�����
	private static final long MILLISECOND_DAY = 1000 * 60 * 60 * 24;

	// ��util����������ת��Ϊsql������������
	public static java.sql.Date util2sql(java.util.Date d) {
		return new java.sql.Date(d.getTime());
	}

	/**
	 * ��ȡ���죬���Ұ�ʱ���֣���ͺ��붼��0
	 * 
	 * @return
	 */
	public static Date today() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	/**
	 * ��ȡ�³� ��ͳ��������Ϣ�ǣ����Ǵ����ݿⰴ�����ڲ��ҳ��³�����ĩ������
	 */
	public static Date monthBegin() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.set(Calendar.DATE, 1);

		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		return c.getTime();
	}

	/**
	 * ��ȡ��ĩʱ��
	 */
	public static Date monthEnd() {
		// ���Calendarʵ��
		Calendar c = Calendar.getInstance();
		// ��ʱ���趨Ϊ���������-��-��-Сʱ-����-��
		c.setTime(new Date());
		// �趨�����еĵ�λʱ��Ϊ0
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		// ʱ������Ϊ���µ�һ��
		c.set(Calendar.DATE, 1);
		c.add(Calendar.MONDAY, 1);
		c.add(Calendar.DATE, -1);
		return c.getTime();
	}

	public static int thisMonthTotalDay() {
		long lastDay = monthEnd().getTime();
		long firstDay = monthBegin().getTime();
		return (int) ((lastDay - firstDay) / MILLISECOND_DAY) + 1;
	}

	/**
	 * ��ȡ���»�ʣ�¶�����
	 */

	public static int thisMonthLeftDay() {
		long lastDay = monthEnd().getTime();
		long toDay = today().getTime();
		return (int) ((lastDay - toDay) / MILLISECOND_DAY) + 1;
	}

	public static void main(String[] args) {
		// System.out.println(DateUtil.today());
		// System.out.println(DateUtil.monthBegin());
		System.out.println(DateUtil.monthEnd());
		// System.out.println(thisMonthLeftDay());
		// System.out.println(thisMonthTotalDay());
	}

}
