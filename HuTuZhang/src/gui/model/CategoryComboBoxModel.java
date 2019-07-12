package gui.model;
/**
 * ����һ�ʡ������ϵ��������������
 */

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import entity.Category;
import service.CategoryService;

public class CategoryComboBoxModel implements ComboBoxModel<Category> {

	public List<Category> cs = new CategoryService().getCategoryWithRecordNumber();

	Category c;

	public CategoryComboBoxModel() {
		/**
		 * Ĭ��ѡ���һ�� �����ݿ��¼��������һ��
		 */
		if (!cs.isEmpty()) {
			c = cs.get(0);
		}
	}

	@Override
	public int getSize() {
		return cs.size();
	}

	@Override
	public Category getElementAt(int index) {
		return cs.get(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSelectedItem(Object anItem) {
		c = (Category) anItem;
	}

	@Override
	public Object getSelectedItem() {
		if (!cs.isEmpty()) {
			return c;
		} else {
			return null;
		}
	}

}