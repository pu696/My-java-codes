package cn.edu.gg;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {
	 JTextArea textArea;
		JScrollPane scrollPane;
		JTextField textField;
		JButton SendBtn;
		
		JPanel panel;
		JFrame frame;
		
		Socket sock;
		Client(){
		frame = new JFrame("客户端");
		textArea = new JTextArea(6, 20);
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(15, 10, 450, 400);
		textField = new JTextField(30);
		SendBtn = new JButton("发送");
		panel = new JPanel(); 
		
		
		//设置字体
		Font font = new Font("宋体", Font.BOLD, 20);
		textArea.setFont(font);
		textField.setFont(font);
		SendBtn.setFont(new Font("宋体", Font.BOLD, 18));
		
		panel.add(textField);
		panel.add(SendBtn);
		frame.setLayout(new BorderLayout());
		frame.add(scrollPane);
		frame.add(panel, BorderLayout.SOUTH);
		
		//设置监听器
		
			SendBtn.addActionListener(new ActionListener() {

					
					public void actionPerformed(ActionEvent e) {
						new Thread(new ReviceData(sock, true)).start();
						
					}
					
				});
			
			textField.addActionListener(new ActionListener() {

					
					public void actionPerformed(ActionEvent e) {
						new Thread(new ReviceData(sock, true)).start();
						
					}
					
				});
		
		// 窗口设置
			frame.setSize(500, 600);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
				
		init();
		}
		
		public void init() {
			SocketAddress serverAddr = new InetSocketAddress("10.118.87.220", 8888);
			 sock = new Socket();
			try {
				sock.connect(serverAddr);
				textArea.append("连接服务器成功   //..\\\\");
				
					new Thread(new ReviceData(sock, false)).start();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		class ReviceData implements Runnable{
			Socket socket;
			boolean isSend = false;
			ReviceData(Socket s, boolean mode){
				socket =  s;
				isSend = mode;
			}
			
			public void setSocket(Socket s) {this.socket = s;}
			
			
			public void run() {
				while(!isSend) {
				
				try {
					DataInputStream dis = new DataInputStream(socket.getInputStream());
					String str = new String(dis.readUTF());
					textArea.append("\n服务器：" + str);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
				String str = textField.getText();
				if(str.isEmpty()) {
					JOptionPane.showMessageDialog(frame,"请先输入文字再发送！" ,"提示",JOptionPane.INFORMATION_MESSAGE);
					return;
					
				}
				try {
					DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
					dos.writeUTF(str);
					textArea.append("\n客户端：" + str);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textField.setText("");
				}
			}
			
			
		
		public static void main(String[] args) {
			new Client();
		}
}
