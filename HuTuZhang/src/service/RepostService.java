package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.RecordDAO;
import entity.Record;
import util.DateUtil;

public class RepostService {

	/**
	 * ��һ���µ����Ѽ�¼�л�ȡĳһ������ѽ��
	 * 
	 * @param d
	 * @param monthRawData
	 * @return
	 */
	public int getDaySpend(Date d, List<Record> monthRawData) {
		int daySpend = 0;
		for (Record record : monthRawData) {
			if (record.getDate().equals(d)) {
				daySpend += record.getSpend();
			}
		}
		return daySpend;
	}

	public int getDaySpend(Date d) {
		List<Record> dayRecordList = new RecordDAO().getRecord(d);
		int daySpend = 0;
		for (Record record : dayRecordList) {
			daySpend += record.getSpend();
		}
		return daySpend;
	}

	/**
	 * ��ȡ���µ����Ѽ�¼����
	 * 
	 * @return
	 */
	public List<Record> getThisMonthRecords() {
		List<Record> monthAllRecord = new RecordDAO().getThisMonthRecord();
		List<Record> result = new ArrayList<Record>();

		// ��ȡ���µ�һ��
		Date monthBegin = DateUtil.monthBegin();
		// ��ȡ����������
		int monthTotalDay = DateUtil.thisMonthTotalDay();

		// ��ȡʵ��
		Calendar c = Calendar.getInstance();

		// �������� ������ÿһ������ѽ��
		for (int i = 0; i < monthTotalDay; i++) {
			Record record = new Record();
			// ���㲢��ȡ���յ�ʱ������ʵ��
			c.setTime(monthBegin);
			c.add(Calendar.DATE, i);
			Date eachDayOfThisMontg = c.getTime();

			int todaySpend = getDaySpend(eachDayOfThisMontg, monthAllRecord);
			record.setSpend(todaySpend);
			result.add(record);

		}

		return result;

	}
}