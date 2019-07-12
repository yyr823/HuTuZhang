package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;

public class MainPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	// �ڽ�����Ⱦǰ����Ƥ��
	static {
		GUIUtil.useLNF();
	}

	// ���õ���ģʽ
	public static MainPanel instance = new MainPanel();

	// Ϊ�˼�����ʹ�õķ��� �������ʹ��public����
	// ������ʵ��
	public JToolBar tb = new JToolBar();
	public JButton bSpend = new JButton();
	public JButton bRecord = new JButton();
	public JButton bCategory = new JButton();
	public JButton bReport = new JButton();
	public JButton bConfig = new JButton();
	public JButton bBackup = new JButton();
	public JButton bRecover = new JButton();

	public CenterPanel workingPanel;

	// ˽�л��乹�캯��
	private MainPanel() {
		GUIUtil.setImageIcon(bSpend, "home.png", "����һ��");
		GUIUtil.setImageIcon(bRecord, "record.png", "��һ��");
		GUIUtil.setImageIcon(bCategory, "category2.png", "���ѷ���");
		GUIUtil.setImageIcon(bReport, "report.png", "�����ѱ���");
		GUIUtil.setImageIcon(bConfig, "config.png", "����");
		GUIUtil.setImageIcon(bBackup, "backup.png", "����");
		GUIUtil.setImageIcon(bRecover, "restore.png", "�ָ�");

		tb.add(bSpend);
		tb.add(bRecord);
		tb.add(bCategory);
		tb.add(bReport);
		tb.add(bConfig);
		tb.add(bBackup);
		tb.add(bRecover);

		// �û������ƶ�������
		tb.setFloatable(false);

		workingPanel = new CenterPanel(0.8);

		setLayout(new BorderLayout());
		// ���������ڽ����Ϸ���ʾ
		add(tb, BorderLayout.NORTH);
		// ��Ҫ�Ĺ����������м�
		add(workingPanel, BorderLayout.CENTER);

		ButtonListener();
	}

	public void ButtonListener() {
		ToolBarListener tbl = new ToolBarListener();
		bBackup.addActionListener(tbl);
		bSpend.addActionListener(tbl);
		bCategory.addActionListener(tbl);
		bConfig.addActionListener(tbl);
		bRecord.addActionListener(tbl);
		bReport.addActionListener(tbl);
		bRecover.addActionListener(tbl);

	}

	public static void main(String[] args) {
		GUIUtil.showPanel(MainPanel.instance, 1);
	}

}
