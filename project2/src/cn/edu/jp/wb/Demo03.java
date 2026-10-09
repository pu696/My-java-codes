package cn.edu.jp.wb;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingUtilities;
import javax.swing.JMenuItem;

public class Demo03 extends JFrame {
	public Demo03() {
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->createAndShowGUI());
	}

	private static void createAndShowGUI() {
		JFrame jf = new JFrame("");
		jf.setBounds(100,200,300,400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setLayout(new BorderLayout());
		
		JMenuBar bar = new JMenuBar();
		JMenu bookJM = new JMenu("读者信息管理");
		JMenu helpJM = new JMenu("帮助");
		
		bar.add(bookJM);
		bar.add(helpJM);
		
		JMenuItem addItem = new JMenuItem("读者信息添加");
		JMenuItem exchangeItem = new JMenuItem("读者信息修改与查询");	
		
		bookJM.add(addItem);
		bookJM.addSeparator();
		bookJM.add(exchangeItem);
		jf.setJMenuBar(bar);
		jf.setVisible(true);
	}
}
