package cn.edu.jp.wb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;

public class test2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField queryJTF;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test2 frame = new test2();
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
	public test2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.NORTH);
		
		JPanel bookqueryJP = new JPanel();
		bookqueryJP.setPreferredSize(new Dimension(400, 250));
		tabbedPane.addTab("图书信息查询", null, bookqueryJP, null);
		bookqueryJP.setLayout(new BorderLayout(0, 0));
		
		JPanel queryJP = new JPanel();
		FlowLayout fl_queryJP = (FlowLayout) queryJP.getLayout();
		fl_queryJP.setHgap(30);
		bookqueryJP.add(queryJP, BorderLayout.NORTH);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"--请选择--", "计算机类", "人文类", "化学类", "医学类"}));
		queryJP.add(comboBox);
		
		queryJTF = new JTextField();
		queryJP.add(queryJTF);
		queryJTF.setColumns(20);
		
		JPanel buttonJP = new JPanel();
		FlowLayout flowLayout = (FlowLayout) buttonJP.getLayout();
		flowLayout.setHgap(30);
		bookqueryJP.add(buttonJP, BorderLayout.SOUTH);
		
		JButton okJB = new JButton("确定");
		buttonJP.add(okJB);
		
		JButton resetJB = new JButton("重置");
		buttonJP.add(resetJB);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		bookqueryJP.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Python\u7A0B\u5E8F\u8BBE\u8BA1", "\u738B\u4E94", "99.9", "\u9AD8\u7B49\u6559\u80B2\u51FA\u7248\u793E"},
				{"2", "java\u7A0B\u5E8F\u8BBE\u8BA1", "\u674E\u56DB", "123.9", "\u4EBA\u6C11\u6559\u80B2\u51FA\u7248\u793E"},
			},
			new String[] {
				"id", "\u540D\u79F0", "\u4F5C\u8005", "\u4EF7\u683C", "\u51FA\u7248\u793E"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(128);
		table.getColumnModel().getColumn(4).setPreferredWidth(123);
		scrollPane.setViewportView(table);
		
		JPanel bookmodifyJP = new JPanel();
		tabbedPane.addTab("图书信息修改", null, bookmodifyJP, null);

	}

}
