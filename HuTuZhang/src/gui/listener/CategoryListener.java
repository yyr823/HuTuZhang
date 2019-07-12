package gui.listener;
/**
 * ���ѷ������ļ���
 * 		�ڼ�������ʶ�����İ�ť�������Ƿֱ����ü���
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import service.CategoryService;

public class CategoryListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		CategoryPanel p = CategoryPanel.instance;

		// ��ȡ����Դ�İ�ť
		JButton button = (JButton) e.getSource();
		if (button == p.bAdd) {
			String name = JOptionPane.showInputDialog(null);
			// Ԥ������Ϊ�յĴ���
			if (0 == name.length()) {
				JOptionPane.showMessageDialog(p, "�������Ʋ���Ϊ��");
				return;
			}
			new CategoryService().add(name);

		}

		if (button == p.bEdit) {
			// ��ȡ��ѡ�е��������
			Category c = p.getSelectCategory();
			/*********************/
			String name = JOptionPane.showInputDialog("�޸ķ�������", c.getName());
			if (0 == name.length()) {
				JOptionPane.showMessageDialog(p, "�������Ʋ���Ϊ��");
				return;
			}
			new CategoryService().update(c.getId(), name);
		}

		if (button == p.bDelete) {
			// ��ȡ��Ҫɾ���ķ���
			Category c = p.getSelectCategory();

			// �жϸ������Ѵ��� ���д�����������ɾ��
			if (0 != c.getRecordNumber()) {
				JOptionPane.showMessageDialog(p, "�÷��������Ѽ�¼����ɾ��");
				return;
			}
			// �ظ�ȷ���Ƿ�Ҫɾ��
			if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "ȷ��Ҫɾ����"))
				return;

			new CategoryService().delete(c.getId());
		}

		p.updateDate();

	}

}
