package cn.edu.jp.wb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;

public class Demo02_TabbedPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField queryJTF;
	private JTable table;
	private JTextField ISBNJTF;
	private JTextField bookJTF;
	private JTextField authorJTF;
	private JTextField groupsJTF;
	private JTextField dateJTF;
	private JTextField timesJTF;
	private JTextField priceJTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo02_TabbedPanel frame = new Demo02_TabbedPanel();
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
	public Demo02_TabbedPanel() {
		setTitle("图书管理与修改");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);
		
		JPanel bookQueryJP = new JPanel();
		bookQueryJP.setPreferredSize(new Dimension(400, 250));
		tabbedPane.addTab("图书信息查询", null, bookQueryJP, null);
		bookQueryJP.setLayout(new BorderLayout(0, 0));
		
		JPanel queryJP = new JPanel();
		FlowLayout flowLayout = (FlowLayout) queryJP.getLayout();
		flowLayout.setHgap(30);
		bookQueryJP.add(queryJP, BorderLayout.NORTH);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ISBN", "计算机类", "社科类", "化学类", "医学类"}));
		queryJP.add(comboBox);
		
		queryJTF = new JTextField();
		queryJP.add(queryJTF);
		queryJTF.setColumns(30);
		
		JPanel buttonJP = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) buttonJP.getLayout();
		flowLayout_1.setHgap(20);
		bookQueryJP.add(buttonJP, BorderLayout.SOUTH);
		
		JButton okJB = new JButton("查询");
		buttonJP.add(okJB);
		
		JButton resetJB = new JButton("退出");
		buttonJP.add(resetJB);
		
		JScrollPane scrollPane = new JScrollPane();
		bookQueryJP.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "\u8BA1\u7B97\u673A\u7C7B", "Java\u7A0B\u5E8F\u8BBE\u8BA1", "\u6881\u723D", "\u6E05\u534E\u5927\u5B66\u51FA\u7248\u793E", "2013-01-01", "1", "28.9"},
				{"2", "\u8BA1\u7B97\u673A\u7C7B", "C++\u7A0B\u5E8F\u8BBE\u8BA1", "\u738B\u5CA9", "\u6E05\u534E\u5927\u5B66\u51FA\u7248\u793E", "2013-02-01", "1", "32.0"},
				{"3", "\u793E\u79D1\u7C7B", "\u601D\u60F3\u9053\u5FB7\u4E0E\u6CD5\u6CBB", "\u8C22\u534E", "\u4EBA\u6C11\u90AE\u7535\u51FA\u7248\u793E", "2014-01-01", "2", "15.0"},
			},
			new String[] {
				"\u7F16\u53F7", "\u5206\u7C7B", "\u540D\u79F0", "\u4F5C\u8005", "\u51FA\u7248\u793E", "\u51FA\u7248\u65E5\u671F", "\u51FA\u7248\u6B21\u6570", "\u5355\u4EF7"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel bookModifyJP = new JPanel();
		tabbedPane.addTab("图书信息修改", null, bookModifyJP, null);
		
		JLabel ISBNJL = new JLabel("ISBN:");
		
		JLabel labelJL = new JLabel("类别：");
		
		JLabel bookJL = new JLabel("书名：");
		
		JLabel authorJL = new JLabel("作者：");
		
		JLabel groupsJL = new JLabel("出版社：");
		
		JLabel dateJL = new JLabel("出版日期：");
		
		JLabel timesJL = new JLabel("印刷次数：");
		
		JLabel priceJL = new JLabel("单价：");
		
		ISBNJTF = new JTextField();
		ISBNJTF.setColumns(10);
		
		bookJTF = new JTextField();
		bookJTF.setColumns(10);
		
		authorJTF = new JTextField();
		authorJTF.setColumns(10);
		
		groupsJTF = new JTextField();
		groupsJTF.setColumns(10);
		
		dateJTF = new JTextField();
		dateJTF.setColumns(10);
		
		timesJTF = new JTextField();
		timesJTF.setColumns(10);
		
		priceJTF = new JTextField();
		priceJTF.setColumns(10);
		
		JComboBox labelJC = new JComboBox();
		GroupLayout gl_bookModifyJP = new GroupLayout(bookModifyJP);
		gl_bookModifyJP.setHorizontalGroup(
			gl_bookModifyJP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bookModifyJP.createSequentialGroup()
					.addGap(84)
					.addGroup(gl_bookModifyJP.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_bookModifyJP.createSequentialGroup()
							.addGroup(gl_bookModifyJP.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_bookModifyJP.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_bookModifyJP.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(ISBNJL, 0, 0, Short.MAX_VALUE)
										.addComponent(labelJL, GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
									.addComponent(authorJL, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addComponent(groupsJL, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addComponent(dateJL, Alignment.TRAILING))
								.addComponent(bookJL, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
							.addGap(36)
							.addGroup(gl_bookModifyJP.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(bookJTF, 0, 0, Short.MAX_VALUE)
								.addComponent(dateJTF, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_bookModifyJP.createParallelGroup(Alignment.LEADING, false)
									.addComponent(authorJTF, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
									.addComponent(ISBNJTF, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
									.addComponent(labelJC, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(groupsJTF, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))))
						.addGroup(gl_bookModifyJP.createSequentialGroup()
							.addGroup(gl_bookModifyJP.createParallelGroup(Alignment.LEADING)
								.addComponent(timesJL, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
								.addComponent(priceJL, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_bookModifyJP.createParallelGroup(Alignment.LEADING)
								.addComponent(priceJTF, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(timesJTF, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(234, Short.MAX_VALUE))
		);
		gl_bookModifyJP.setVerticalGroup(
			gl_bookModifyJP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bookModifyJP.createSequentialGroup()
					.addGroup(gl_bookModifyJP.createParallelGroup(Alignment.BASELINE)
						.addComponent(ISBNJL, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(ISBNJTF, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_bookModifyJP.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelJL, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelJC, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_bookModifyJP.createParallelGroup(Alignment.BASELINE)
						.addComponent(bookJTF, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookJL, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_bookModifyJP.createParallelGroup(Alignment.BASELINE)
						.addComponent(authorJL, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(authorJTF, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_bookModifyJP.createParallelGroup(Alignment.BASELINE)
						.addComponent(groupsJTF, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(groupsJL, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_bookModifyJP.createParallelGroup(Alignment.BASELINE)
						.addComponent(dateJL, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateJTF, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_bookModifyJP.createParallelGroup(Alignment.BASELINE)
						.addComponent(timesJL, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(timesJTF, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_bookModifyJP.createParallelGroup(Alignment.BASELINE)
						.addComponent(priceJL, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(priceJTF, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		bookModifyJP.setLayout(gl_bookModifyJP);

	}
}
