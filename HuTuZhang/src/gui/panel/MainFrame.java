package gui.panel;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static MainFrame instance = new MainFrame();

	private MainFrame() {
		// ���ô����С
		this.setSize(500, 450);
		// ���ô��ڱ���
		this.setTitle("һ����Ϳ��");
		// ���ô��ܵ������
		this.setContentPane(MainPanel.instance);
		// ���������ʾ
		this.setLocationRelativeTo(null);
		// ���ô����С�Ƿ�ɵ�
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		instance.setVisible(true);
	}
}
