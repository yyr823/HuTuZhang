package gui.panel;
/**
 * ����ͳ�����
 */

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.page.SpendPage;
import service.SpendService;
import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

public class SpendPanel extends WorkingPanel {
	private static final long serialVersionUID = 1L;

	// ����Ƥ��
	static {
		GUIUtil.useLNF();
	}

	// ����ģʽ ����Ψһʵ��
	public static SpendPanel instance = new SpendPanel();

	public JLabel lMonthSpend = new JLabel("��������");
	public JLabel lTodaySpend = new JLabel("��������");
	public JLabel lAvgSpendPerDay = new JLabel("�վ�����");
	public JLabel lMonthLeft = new JLabel("����ʣ��");
	public JLabel lDayAvgAvailable = new JLabel("�վ�����");
	public JLabel lMonthLeftDay = new JLabel("������ĩ");

	public JLabel vMonthSpend = new JLabel();
	public JLabel vTodaySpend = new JLabel();
	public JLabel vAvgSpendPerDay = new JLabel();
	public JLabel vMonthAvailable = new JLabel();
	public JLabel vDayAvgAvailable = new JLabel();
	public JLabel vMonthLeftDay = new JLabel();

	// Բ�μ�¼
	CircleProgressBar bar;

	private SpendPanel() {
		// ���ò���ģʽ
		this.setLayout(new BorderLayout());
		// ��ʼ��Բ��
		bar = new CircleProgressBar();
		// ����Բ����Ϊ��ɫ
		bar.setBackground(ColorUtil.blueColor);
		// ����һ��ؼ��ı���
		GUIUtil.setColor(ColorUtil.grayColor, lMonthSpend, lTodaySpend, lAvgSpendPerDay, lMonthLeft, lDayAvgAvailable,
				lMonthLeftDay, vAvgSpendPerDay, vMonthAvailable, vDayAvgAvailable, vMonthLeftDay);
		GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend, vTodaySpend);

		// ��������
		vMonthSpend.setFont(new Font("΢���ź�", Font.BOLD, 23));
		vTodaySpend.setFont(new Font("΢���ź�", Font.BOLD, 23));

		this.add(center(), BorderLayout.CENTER);
		this.add(south(), BorderLayout.SOUTH);
	}

	private JPanel center() {
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(west(), BorderLayout.WEST);
		p.add(center2(), BorderLayout.CENTER);
		return p;
	}

	private Component center2() {
		return bar;
	}

	private Component west() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4, 1));
		p.add(lMonthSpend);
		p.add(vMonthSpend);
		p.add(lTodaySpend);
		p.add(vTodaySpend);
		return p;
	}

	private JPanel south() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 4));

		p.add(lAvgSpendPerDay);
		p.add(lMonthLeft);
		p.add(lDayAvgAvailable);
		p.add(lMonthLeftDay);
		p.add(vAvgSpendPerDay);
		p.add(vMonthAvailable);
		p.add(vDayAvgAvailable);
		p.add(vMonthLeftDay);

		return p;
	}

	@Override
	public void updateDate() {
		SpendPage spend = new SpendService().getSpendPage();
		vMonthSpend.setText(spend.monthSpend);
		vTodaySpend.setText(spend.todaySpend);
		vAvgSpendPerDay.setText(spend.avgSpendPerDay);
		vDayAvgAvailable.setText(spend.avgDayAvailable);
		vMonthAvailable.setText(spend.monthAvailable);
		vMonthLeftDay.setText(spend.monthLeftDay);

		bar.setProgress(spend.usagePercentage);
		if (spend.isOverSpend) {
			vMonthAvailable.setForeground(ColorUtil.warningColor);
			vMonthSpend.setForeground(ColorUtil.warningColor);
			vTodaySpend.setForeground(ColorUtil.warningColor);
		} else {
			vMonthAvailable.setForeground(ColorUtil.grayColor);
			vMonthSpend.setForeground(ColorUtil.blueColor);
			vTodaySpend.setForeground(ColorUtil.blueColor);
		}
		bar.setForegroundColor(ColorUtil.getByPercentage(spend.usagePercentage));
		addListener();
	}

	@Override
	public void addListener() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		GUIUtil.showPanel(SpendPanel.instance);
	}

}
