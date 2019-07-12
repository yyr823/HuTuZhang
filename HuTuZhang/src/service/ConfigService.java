package service;

import dao.ConfigDAO;
import entity.Config;

/**
 * Service��ҵ���� �Ǽ�����ֱ�ӵ��õ��� ͨ��service����DAO�� �������ݿ�
 * 
 * @author Administrator
 *
 */

public class ConfigService {

	public static final String budget = "budget";
	public static final String mysqlPath = "mysqlPath";
	private static final String default_budget = "500";

	// ����config��DAO
	private static ConfigDAO dao = new ConfigDAO();

	// ��ɳ�ʼ������
	static {
		init();
	}

	/**
	 * ��ʼ��
	 */
	public static void init() {
		init(budget, default_budget);
		init(mysqlPath, "");
	}

	/**
	 * ������Ӧ��keyֵ��value��ʼ��������Ϣ
	 * 
	 * @param key
	 * @param value
	 */
	private static void init(String key, String value) {
		// ����dao��ķ��� ��ȡ��Ӧ��¼
		Config config = dao.getBykey(key);

		// ���Ϊ�ձ�ʾû�иü�¼ ������Ϣû�д������ݿ�
		if (config == null) {
			Config c = new Config();
			c.setKey(key);
			c.setValue(value);
			// ����dao�㷽������������Ϣ��¼�������ݿ�
			dao.add(c);
		}
	}

	/**
	 * ����key�����Ӧ��������Ϣ
	 * 
	 * @param key
	 */
	public String getValueByKey(String key) {
		// ����dao�㷽�� ͨ��key���Config����ʵ��
		Config config = dao.getBykey(key);
		return config.getValue();
	}

	/**
	 * ����һ��������Ϣ
	 * 
	 * @param key
	 * @param value
	 */
	public void update(String key, String value) {
		Config config = dao.getBykey(key);
		config.setValue(value);
		dao.update(config);
	}

	/**
	 * ��ȡԤ��
	 * 
	 * @return
	 */
	public int getIntBudget() {
		return Integer.parseInt(getValueByKey(ConfigService.budget));
	}

}
