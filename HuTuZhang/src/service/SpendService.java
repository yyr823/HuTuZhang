package service;
/**
 * ����һ�������ҵ����
 * @author Administrator
 *
 */

import java.util.List;

import dao.RecordDAO;
import entity.Record;
import gui.page.SpendPage;
import util.DateUtil;

public class SpendService {

	/**
	 * ��ȡSpendPage���������ڽ�����ʾ
	 * 
	 * @return
	 */
	public SpendPage getSpendPage() {

		// ��ȡ���Ѽ�¼��DAO��ʵ��
		RecordDAO dao = new RecordDAO();
		// ��ȡ�������Ѽ�¼����
		List<Record> thisMonthRecords = dao.getThisMonthRecord();

		// ��ȡ�������Ѽ�¼����
		List<Record> toDayRecords = dao.getToDayRecord();
		// ��ȡ����������
		int thisMonthTotalDay = DateUtil.thisMonthTotalDay();

		// �����ȡ�ĵ�����
		int monthSpend = 0;
		int todaySpend = 0;
		int avgSpendPerDay = 0;
		int monthAvailable = 0;
		int dayAvgAvailable = 0;
		int monthLeftDay = 0;
		int usagePercentage = 0;

		// ���Ԥ��
		int monthBudget = new ConfigService().getIntBudget();

		/**
		 * ͳ�Ʊ������Ѷ� �������µ�ûһ�����Ѽ�¼ ��ȡ�����
		 */
		for (Record record : thisMonthRecords) {
			monthSpend += record.getSpend();
		}

		// ͳ�ƽ�������
		for (Record record : toDayRecords) {
			todaySpend += record.getSpend();
		}
		// �����վ�����
		avgSpendPerDay = monthSpend / thisMonthTotalDay;

		// ���㱾��ʣ��
		monthAvailable = monthBudget - monthSpend;
		// ���������ĩ������
		monthLeftDay = DateUtil.thisMonthLeftDay();
		// �����վ�����
		dayAvgAvailable = monthAvailable / monthLeftDay;
		// ����ʹ�ñ���
		usagePercentage = monthSpend * 100 / monthBudget;
		// ����SpendPage ��return
		return new SpendPage(monthSpend, todaySpend, avgSpendPerDay, monthAvailable, dayAvgAvailable, monthLeftDay,
				usagePercentage);

	}

}