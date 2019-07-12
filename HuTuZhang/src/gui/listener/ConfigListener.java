package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;

import gui.panel.ConfigPanel;
import service.ConfigService;
import util.GUIUtil;

public class ConfigListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * 1�������ж������Ԥ����Ϣ�Ƿ�Ϊ���� 2�������ж�MySQL�ð�װ·���Ƿ���ȷ���жϸ�Ŀ¼��binĿ¼���Ƿ���mysql.exe��
		 * 3)����ConfigService��update�����޸����ݿ�����
		 */
		// ��ȡ������Ϣ�����ʵ��
		ConfigPanel cp = ConfigPanel.instance;

		// �ж������Ԥ���Ƿ�Ϊ���� String�����Ϊ����ĺ���
		if (!GUIUtil.checkNumber(cp.tfBudget, "����Ԥ��")) {
			return;
		}

		// ��ȡmysql�İ�װ·��
		String mysqlPath = cp.tfMysqlPath.getText().trim();

		// �����벻Ϊ�� ���һ�����mysql��װĿ¼�Ƿ���ȷ
		if (0 == mysqlPath.length()) {
			File f = new File(mysqlPath, "bin/mysql.txt");
			// ��·������ȷ �����������Ϣ
			if (!f.exists()) {
				JOptionPane.showMessageDialog(cp, "mysql��װ·������ȷ");
				// ��������»�ȡ����
				cp.tfMysqlPath.grabFocus();
				return;
			}
		}

		// ͨ��˫����֤�� ��������Ϣ����
		ConfigService cs = new ConfigService();
		// ����Ԥ����Ϣ
		cs.update(ConfigService.budget, cp.tfBudget.getText());
		cs.update(ConfigService.mysqlPath, mysqlPath);
		JOptionPane.showMessageDialog(cp, "�����޸ĳɹ�");
	}

}
