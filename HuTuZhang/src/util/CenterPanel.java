package util;
/**
 * �������
 */

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JPanel;

import gui.panel.WorkingPanel;

public class CenterPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private double rate; // �������
	private JComponent c; // ��ʾ�����
	private boolean strech; // �Ƿ�����

	public CenterPanel(double rate, boolean strech) {
		this.setLayout(null);
		this.rate = rate;
		this.strech = strech;
	}

	// strechĬ��Ϊtrue;
	public CenterPanel(double rate) {
		this(rate, true);
	}

	public void repaint() {
		if (null != c) {
			Dimension containerSize = this.getSize();
			Dimension componentSize = c.getPreferredSize();

			if (strech)
				c.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
			else
				c.setSize(componentSize);
			c.setLocation(containerSize.width / 2 - c.getSize().width / 2,
					containerSize.height / 2 - c.getSize().height / 2);
		}
		super.repaint();
	}

	/**
	 * ��ʾ���
	 * 
	 * @param p
	 */
	public void show(JComponent p) {
		this.c = p;
		// ��ȡ����ʾ����ϵ�ȫ����� ���Ƴ�
		Component[] cs = getComponents();
		for (Component c : cs) {
			remove(c);
		}

		/**
		 * �ж���Ҫ��ʾ������Ƿ���WorkingPanel �� ����Ҫ��updateDate()���ý�����ʾ�����ݿ�ͬ��
		 */
		if (p instanceof WorkingPanel) {
			((WorkingPanel) p).updateDate();
		}
		add(p);
		this.updateUI();
	}
}
