package util;
/**
 * ͼ�ν�����ϵĹ�����
 */

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIUtil {

	// ͼƬ���λ��
	private static String imageFolder = "img";

	/**
	 * ����Ƿ�Ϊ��
	 * 
	 * @param jtf
	 *            �ؼ�
	 * @param input
	 *            �����ı�
	 * @return
	 */
	public static boolean checkEmpty(JTextField tf, String input) {
		String text = tf.getText().trim();
		if (0 == text.length()) {
			// ����������ʾ����Ϊ��
			JOptionPane.showMessageDialog(null, input + " ����Ϊ��");
			// ��ȡ���뽹��
			tf.grabFocus();

			return false;
		}
		return true;
	}

	/**
	 * �������������Ƿ������ָ�ʽ
	 * 
	 * @param jtf
	 *            �ؼ�
	 * @param input
	 *            �����ı�
	 * @return
	 */
	public static boolean checkNumber(JTextField tf, String input) {
		// ���ж������Ƿ�Ϊ��
		if (!checkEmpty(tf, input)) {
			return false;
		}
		// ��ȡ��������� ��ȥ�ո�
		String text = tf.getText().trim();
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e) {
			// ������������ת���쳣 ����ʾ��ʾ����
			JOptionPane.showMessageDialog(null, input + " ��Ҫ������");
			tf.grabFocus();
			return false;
		}

	}

	/**
	 * ����齨�����������Ƿ�Ϊ��
	 * 
	 * @param tf
	 * @param input
	 *            ������������
	 * @return
	 */
	public static boolean checkZero(JTextField tf, String input) {
		// ���չ��� �ȼ���Ƿ�Ϊ��
		if (!checkEmpty(tf, input)) {
			return false;
		}
		// ��ȡ��������
		String text = tf.getText().trim();

		if (0 == Integer.parseInt(text)) {
			JOptionPane.showMessageDialog(null, input + " ����Ϊ��");
			tf.grabFocus();
			return false;
		}
		return true;
	}

	/**
	 * Ϊһ�����߶���������ǰ��ɫ
	 * 
	 * @param color
	 *            ��ɫ
	 * @param cs
	 *            ���
	 */
	public static void setColor(Color color, JComponent... cs) {
		for (JComponent jComponent : cs) {
			jComponent.setForeground(color);
		}
	}

	/**
	 * ����ť����ͼ��,��ť�ڵ�����,�Լ���ʾ����
	 * 
	 * @param b
	 *            ��ť
	 * @param fileName
	 *            �ļ�����
	 * @param tip
	 *            ��ʾ����
	 */

	public static void setImageIcon(JButton b, String fileName, String tip) {
		// ��ȡͼ����Ϣ
		ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
		// ���ð�ťͼ��
		b.setIcon(i);
		// �����齨����ѡ��С
		b.setPreferredSize(new Dimension(61, 81));
		// ������ʾ����
		b.setToolTipText(tip);
		// ���ñ�ǩ���ı������ͼ��Ĵ�ֱλ�� Ĭ��ֵΪ center
		b.setVerticalTextPosition(JButton.BOTTOM);
		// ���ñ�ǩ���ı������ͼ���ˮƽλ��
		b.setHorizontalTextPosition(JButton.CENTER);
		// ���ð�ť����ʾ���ı�
		b.setText(tip);
	}

	/**
	 * ����Ƥ�� �ڽ�����Ⱦǰ���ò�����Ч
	 */
	public static void useLNF() {
		try {
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ʾ������
	 * 
	 * @param p
	 * @param strech
	 *            �������� 1��ʾ����
	 */
	public static void showPanel(JPanel p, double strech) {
		GUIUtil.useLNF();
		JFrame f = new JFrame();
		f.setSize(500, 500);
		f.setLocationRelativeTo(null);
		CenterPanel cp = new CenterPanel(strech);
		f.setContentPane(cp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		cp.show(p);
	}

	/**
	 * Ĭ��Ϊ0.85���������
	 * 
	 * @param p
	 */
	public static void showPanel(JPanel p) {
		showPanel(p, 0.85);
	}

}
