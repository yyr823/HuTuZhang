package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.SpendPanel;
import service.RecordService;
import util.GUIUtil;

/**
 * ����һ�ʡ��İ�ť����
 * 
 * @author Administrator
 *
 */

public class RecordListener implements ActionListener {

	/**
	 * 1�������ж��Ƿ��з�����Ϣ�����û������ʾ��Ҫ������������� 2������Ľ���Ϊ0 3������ҵ����(Service)�е�add�������Ӽ�¼
	 * 4����ʾ�ɹ�������show��ת��������һ��������
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// ��ȡ������ʵ��
		RecordPanel panel = RecordPanel.instance;
		// �ж��Ƿ��з�����Ϣ
		if (0 == panel.cbModel.getSize()) {
			JOptionPane.showMessageDialog(panel, "���������Ϣ���������");
			// ��ת����ӽ���
			MainPanel.instance.workingPanel.show(CategoryPanel.instance);
			return;
		}

		// �ж��������Ƿ���Ч
		if (!GUIUtil.checkZero(panel.tfSpend, "���ѽ��")) {
			JOptionPane.showMessageDialog(panel, "��������Ч���");
			return;
		}

		// ��ȡ���ѽ��
		int spend = Integer.parseInt(panel.tfSpend.getText());
		// ��ȡ�������
		Category c = (Category) panel.cbCategory.getSelectedItem();
		/**
		 * ����Ĭ��ѡ������������ ���в�����û��ѡ���������͵����
		 */
		// if(c == null){
		// JOptionPane.showMessageDialog(panel, "����ѡ������");
		// }
		// ��ȡ���ѱ�ע ��ȥ�ո�
		String comment = panel.tfComment.getText();
		// ��ȡʱ��
		Date date = panel.datepick.getDate();

		new RecordService().add(spend, c, comment, date);
		// ��ת������һ������
		MainPanel.instance.workingPanel.show(SpendPanel.instance);

	}

}
