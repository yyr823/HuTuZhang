package service;

import java.util.Collections;
import java.util.List;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;

public class CategoryService {
	// ��ȡ���ѷ����DAO��ʵ��
	CategoryDAO categoryDAO = new CategoryDAO();
	/**
	 * ��ȡRecordDAO��ʵ�� �ڻ�ȡ����������id�����Ѽ�¼��cid�����ȡÿ���������Ѵ���
	 */
	RecordDAO recordDAO = new RecordDAO();

	/**
	 * ��ȡȫ�������������Ϣ 1�����������ı��л�ȡȫ�������������Ϣ����ʱ��û��ÿ���������Ѵ�����Ϣ�� 2������������� ���������Ϊ������ѯ���Ѽ�¼��
	 * �������С
	 * 
	 * @return
	 */
	public List<Category> getCategoryWithRecordNumber() {
		// ��ȡ���е����ѷ����¼
		List<Category> cs = new CategoryDAO().getCategory();

		// �������е����ѷ���
		for (Category category : cs) {
			// �������ѷ���id��ѯ���Ѽ�¼
			List<Record> rs = recordDAO.getRecord(category.getId());
			category.setRecordNumber(rs.size());
		}

		Collections.sort(cs, (c1, c2) -> c2.getRecordNumber() - c1.getRecordNumber());
		return cs;

	}

	/**
	 * ����һ���������
	 * 
	 * @param name
	 */
	public void add(String name) {
		categoryDAO.add(new Category(name));
	}

	/**
	 * ����һ���������
	 * 
	 * @param id
	 * @param name
	 */
	public void update(int id, String name) {
		Category c = new Category(name);
		c.setId(id);
		categoryDAO.update(c);
	}

	/**
	 * ����idɾ��һ���������
	 * 
	 * @param id
	 */
	public void delete(int id) {
		categoryDAO.deleteById(id);
	}

}
