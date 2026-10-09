package cn.edu.jp.wb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField LoginJTF;
	private JPasswordField passJPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel loginJL = new JLabel("用户名");
		
		LoginJTF = new JTextField();
		LoginJTF.setColumns(10);
		
		JLabel LoginPassJL = new JLabel("密  码");
		
		passJPF = new JPasswordField();
		
		JButton LoginJB = new JButton("登录");
		LoginJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = LoginJTF.getText();
				String pass = new String(passJPF.getPassword());
				if("张三".contentEquals(user)&&"123456".contentEquals(pass)) {
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
					ActionListener listener = new ActionListener()
					{
						@Override
						public void actionPerformed(ActionEvent e) {
							Demo02_TabbedPanel frame = new Demo02_TabbedPanel();
							frame.setVisible(true);
						}
					};
					exchangeItem.addActionListener(listener);
					addItem.addActionListener(new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							System.exit(0);
						}
					});
					jf.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"登录失败！");			
				}
			}
		});
		
		JButton resetJB = new JButton("清空");
		resetJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginJTF.setText("");
				passJPF.setText("");
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(90)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(LoginPassJL, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addComponent(loginJL, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passJPF)
								.addComponent(LoginJTF, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(68)
							.addComponent(LoginJB, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(resetJB, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(128, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginJL, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(LoginJTF, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(LoginPassJL, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(passJPF, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(LoginJB, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(resetJB, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(65))
		);
		contentPane.setLayout(gl_contentPane);

	}
}
