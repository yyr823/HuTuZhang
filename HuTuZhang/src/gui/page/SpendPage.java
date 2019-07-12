package gui.page;

public class SpendPage {
	public String monthSpend; // ��������
	public String todaySpend; // ��������
	public String avgSpendPerDay;; // �վ�����
	public String monthAvailable; // ����ʣ��
	public String avgDayAvailable; // �վ�����
	public String monthLeftDay; // ������ĩ
	public int usagePercentage; // ʹ�ñ���
	public boolean isOverSpend; // �Ƿ�֧ Ĭ��Ϊfalse

	/**
	 * ���캯�� ����int ��ʾ����ת��ΪString
	 */
	public SpendPage(int monthSpend, int todaySpend, int avgSpendPerDay, int monthAvailable, int dayAvgAvailable,
			int monthLeftDay, int usagePercentage) {
		this.monthSpend = "��" + monthSpend;
		this.todaySpend = "��" + todaySpend;
		this.avgSpendPerDay = "��" + avgSpendPerDay;
		// �ж��Ƿ�֧
		if (monthAvailable < 0) {
			this.isOverSpend = true;
		}

		if (isOverSpend) {
			this.monthAvailable = "��֧" + (0 - monthAvailable);
			this.avgDayAvailable = "��0";
		} else {
			this.monthAvailable = "��" + monthAvailable;
			this.avgDayAvailable = "��" + dayAvgAvailable;
		}

		this.monthLeftDay = monthLeftDay + "��";
		this.usagePercentage = usagePercentage;

	}
}
