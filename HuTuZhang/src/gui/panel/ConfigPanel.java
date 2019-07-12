package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.listener.ConfigListener;
import service.ConfigService;
import util.ColorUtil;
import util.GUIUtil;

public class ConfigPanel extends WorkingPanel {

	private static final long serialVersionUID = 1L;

	static {
		GUIUtil.useLNF();
	}

	public static ConfigPanel instance = new ConfigPanel();

	JLabel lBudget = new JLabel("����Ԥ��(��)");
	public JTextField tfBudget = new JTextField("0");

	JLabel lMysql = new JLabel("MySQL��װĿ¼");
	public JTextField tfMysqlPath = new JTextField("");

	JButton bUpdate = new JButton("����");

	public ConfigPanel() {
		GUIUtil.setColor(ColorUtil.grayColor, lBudget, lMysql);
		GUIUtil.setColor(ColorUtil.blueColor, bUpdate);

		JPanel pInput = new JPanel();
		JPanel pSubmit = new JPanel();
		int gap = 40;
		pInput.setLayout(new GridLayout(4, 1, gap, gap));

		pInput.add(lBudget);
		pInput.add(tfBudget);
		pInput.add(lMysql);
		pInput.add(tfMysqlPath);

		this.setLayout(new BorderLayout());
		this.add(pInput, BorderLayout.NORTH);

		pSubmit.add(bUpdate);
		this.add(pSubmit, BorderLayout.CENTER);

		addListener();

		// updateDate();
	}

	/**
	 * Ϊ��ť��Ӽ���
	 * 
	 * @param args
	 */
	public void addListener() {
		ConfigListener c = new ConfigListener();
		bUpdate.addActionListener(c);
	}

	public static void main(String[] args) {
		GUIUtil.showPanel(ConfigPanel.instance);
	}

	@Override
	public void updateDate() {
		ConfigService cs = new ConfigService();
		// �����ݿ��л�ȡ������Ϣ
		String budget = cs.getValueByKey(ConfigService.budget);
		String mysqlPath = cs.getValueByKey(ConfigService.mysqlPath);
		// ��������Ϣ��ʾ�ڽ���
		tfBudget.setText(budget);
		tfMysqlPath.setText(mysqlPath);

		// ������ȡ����
		tfBudget.grabFocus();
	}

}
