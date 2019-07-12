package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.panel.BackupPanel;
import gui.panel.CategoryPanel;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.RecoverPanel;
import gui.panel.ReportPanel;
import gui.panel.SpendPanel;

public class ToolBarListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// ��ȡ������ʵ��
		MainPanel mp = MainPanel.instance;
		// ��ȡ����İ�ť
		JButton b = (JButton) e.getSource();

		/**
		 * ��ť�಻����Ϊswitch�Ĳ�����������ȫ��ʹ��if�ж���� ��ȡ��������ʵ�� ��������ʾ�ڹ��������
		 */
		if (b == mp.bBackup)
			mp.workingPanel.show(BackupPanel.instance);
		if (b == mp.bCategory)
			mp.workingPanel.show(CategoryPanel.instance);
		if (b == mp.bConfig)
			mp.workingPanel.show(ConfigPanel.instance);
		if (b == mp.bRecord)
			mp.workingPanel.show(RecordPanel.instance);
		if (b == mp.bRecover)
			mp.workingPanel.show(RecoverPanel.instance);
		if (b == mp.bReport)
			mp.workingPanel.show(ReportPanel.instance);
		if (b == mp.bSpend)
			mp.workingPanel.show(SpendPanel.instance);

	}

}
