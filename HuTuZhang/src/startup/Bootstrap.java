package startup;
/**
 * 启动程序的入口
 */

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import gui.panel.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import util.GUIUtil;

public class Bootstrap {
	public static void main(String[] args) throws InvocationTargetException, InterruptedException {
		/**
		 * 皮肤设置
		 */
		GUIUtil.useLNF();
		/**
		 * 初始化线程
		 */
		SwingUtilities.invokeAndWait(new Runnable() {
			@Override
			public void run() {
				MainFrame.instance.setVisible(true);
				MainPanel.instance.workingPanel.show(SpendPanel.instance);
			}
		});
	}
}