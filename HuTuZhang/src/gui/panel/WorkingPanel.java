package gui.panel;

import javax.swing.JPanel;

public abstract class WorkingPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	/**
	 * ��Ľ��汣�ֺ����ݿ��ͬ��
	 */
	public abstract void updateDate();

	/**
	 * Ϊ�������Ӽ�����
	 */
	public abstract void addListener();
}
