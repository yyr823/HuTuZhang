package service;
/**
 * ��һ�ʽ���
 * ���ü����� ��ȡ���������������
 * 		 ������dao�㷽������������ݴ������ݿ�
 */

import java.util.Date;

import dao.RecordDAO;
import entity.Category;
import entity.Record;

public class RecordService {

	/**
	 * �����ݿ�洢һ�����Ѽ�¼
	 * 
	 * @param record
	 */
	public void add(int spend, Category c, String comment, Date date) {
		new RecordDAO().add(new Record(spend, c.getId(), comment, date));
	}

}